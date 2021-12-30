package com.minttea.minecraft.arsarsenal.common.events;

import com.hollingsworth.arsnouveau.api.event.SpellCastEvent;
import com.hollingsworth.arsnouveau.api.event.SpellModifierEvent;
import com.hollingsworth.arsnouveau.common.capability.ManaCapability;
import com.hollingsworth.arsnouveau.common.util.PortUtil;
import com.minttea.minecraft.arsarsenal.ArsArsenal;
import com.minttea.minecraft.arsarsenal.common.armor.SchoolArmor;
import com.minttea.minecraft.arsarsenal.common.armor.SourceSteelArmor;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ArsArsenal.MODID)
public class ArmorEvents {


    @SubscribeEvent
    public static void spellResolveEvent(SpellModifierEvent event)
    {
        for(ItemStack stack:event.caster.getArmorSlots())
        {
            if(stack.getItem() instanceof SchoolArmor)
            {
                ((SchoolArmor) stack.getItem()).onModifier(event);

            }
        }

        PortUtil.sendMessage(event.caster, new StringTextComponent("Old damage"));
    }

    @SubscribeEvent
    public static void spellCastEvent(SpellCastEvent event)
    {
        double discount = 0;
        PortUtil.sendMessage(event.getEntityLiving(), new StringTextComponent("Old cost: " + event.spell.getCastingCost()));
        for(ItemStack stack:event.getEntityLiving().getArmorSlots())
        {
            if(stack.getItem() instanceof SchoolArmor)
            {
                discount += ((SchoolArmor) stack.getItem()).getDiscount(event.spell.recipe);

            }
        }

        event.spell.setCost((int) (event.spell.getCastingCost() * (1-discount)));
        PortUtil.sendMessage(event.getEntityLiving(), new StringTextComponent("New cost: " + event.spell.getCastingCost()));
    }
    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        LivingEntity entity = event.getEntityLiving();
        if(entity instanceof PlayerEntity) {
            int discount = 0;



            for (ItemStack stack : entity.getArmorSlots()) {
                Item item = stack.getItem();
                if (item instanceof SchoolArmor
                        &&
                        ((SchoolArmor) item).preventedTypes.contains(event.getSource())
                ) {

                    stack.setDamageValue(stack.getDamageValue() - 1);
                    discount++;

                } else if(item instanceof SourceSteelArmor
                        &&
                        (
                                event.getSource().isMagic() ||
                                        event.getSource().getEntity() instanceof LightningBoltEntity ||
                                        event.getSource() == DamageSource.MAGIC
                        )
                )
                    {

                        ManaCapability.getMana((PlayerEntity) entity).ifPresent(mana->{
                            mana.addMana(event.getAmount()/8);
                            stack.setDamageValue(stack.getDamageValue() -1);
                            event.setAmount(event.getAmount() -  (event.getAmount() / 8));
                        });
                    }


            }

            int finalDiscount = discount;
            if(finalDiscount > 0 )
            ManaCapability.getMana(entity).ifPresent(mana -> {
                mana.addMana(event.getAmount() * (finalDiscount / 8));
                event.setAmount(event.getAmount() - (event.getAmount() * (finalDiscount / 8)));


            });
        }

    }

}
