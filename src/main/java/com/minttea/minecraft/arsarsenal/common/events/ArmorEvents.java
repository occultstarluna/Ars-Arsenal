package com.minttea.minecraft.arsarsenal.common.events;

import com.hollingsworth.arsnouveau.api.event.SpellCastEvent;
import com.hollingsworth.arsnouveau.api.event.SpellModifierEvent;
import com.hollingsworth.arsnouveau.api.spell.SpellSchool;
import com.hollingsworth.arsnouveau.api.spell.SpellSchools;
import com.hollingsworth.arsnouveau.common.capability.CapabilityRegistry;
import com.hollingsworth.arsnouveau.common.potions.ModPotions;
import com.minttea.minecraft.arsarsenal.ArsArsenal;
import com.minttea.minecraft.arsarsenal.common.armor.SchoolArmor;
import com.minttea.minecraft.arsarsenal.common.armor.SourceSteelArmor;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;

@Mod.EventBusSubscriber(modid = ArsArsenal.MODID)
public class ArmorEvents {


    @SubscribeEvent
    public static void spellResolveEvent(SpellModifierEvent event)
    {
        if(event.caster != null) {
            for (ItemStack stack : event.caster.getArmorSlots()) {
                if (stack.getItem() instanceof SchoolArmor) {
                    ((SchoolArmor) stack.getItem()).onModifier(event);

                }
            }
        }
    }

    @SubscribeEvent
    public static void spellCastEvent(SpellCastEvent event)
    {
        double discount = 0;
        for(ItemStack stack:event.getEntityLiving().getArmorSlots())
        {
            if(stack.getItem() instanceof SchoolArmor)
            {
                discount += ((SchoolArmor) stack.getItem()).getDiscount(event.spell.recipe);

            }
        }

        event.spell.setCost((int) (event.spell.getCastingCost() * (1-discount)));

    }
    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        LivingEntity entity = event.getEntityLiving();
        if (entity instanceof Player) {
            int discount = 0;
            HashMap<SpellSchool, Integer> bonusMap = new HashMap<>();
            for (ItemStack stack : entity.getArmorSlots()) {
                Item item = stack.getItem();
                if (item instanceof SchoolArmor &&((SchoolArmor) item).preventedTypes.contains(event.getSource())) {
                    discount++;
                    if(!bonusMap.containsKey(((SchoolArmor) item).getSchool()))
                    {
                        bonusMap.put(((SchoolArmor) item).getSchool(), 1);
                    } else {
                        bonusMap.put(((SchoolArmor) item).getSchool(), bonusMap.get(((SchoolArmor) item).getSchool())+1);
                    }
                }
                else if(item instanceof SourceSteelArmor
                        && (event.getSource().isMagic() ||
                        event.getSource().getEntity() instanceof LightningBolt ||
                        event.getSource() == DamageSource.MAGIC)
                ) {discount++;}
            }

        if (bonusMap.getOrDefault(SpellSchools.ELEMENTAL_FIRE,0) == 4 && (entity.isOnFire() && !(entity.isInLava()))) {
            entity.clearFire();
        }
        if (bonusMap.getOrDefault(SpellSchools.ELEMENTAL_WATER,0) == 4 && (entity.getAirSupply() < 1 && entity.isInWater())) {
            entity.setAirSupply(entity.getMaxAirSupply());
            if(event.getSource() == DamageSource.DROWN)
            {
                event.setAmount(event.getAmount()/2);
            }
        }
        if (bonusMap.getOrDefault(SpellSchools.ELEMENTAL_EARTH,0) == 4 && entity.getEyePosition().y() < 60 && ((Player) entity).getFoodData().getFoodLevel() < 1) {
            ((Player) entity).getFoodData().setFoodLevel(10);
        }
        if (bonusMap.getOrDefault(SpellSchools.ELEMENTAL_AIR, 0) == 4 && event.getSource().isFall()) {
            event.setAmount(event.getAmount() / 2);
        }
        float finalDiscount = discount;
        if(finalDiscount > 0 ){
            CapabilityRegistry.getMana(entity).ifPresent(mana -> event.getEntityLiving().addEffect(new MobEffectInstance(ModPotions.MANA_REGEN_EFFECT, 200, (int) (Math.floor(finalDiscount /2)))));
            event.setAmount(event.getAmount() - (event.getAmount() * (finalDiscount / 8)));
        }

        }
    }

}
