package com.minttea.minecraft.arsarsenal.common.armor;

import com.hollingsworth.arsnouveau.common.capability.ManaCapability;
import com.hollingsworth.arsnouveau.setup.ItemsRegistry;
import com.minttea.minecraft.arsarsenal.setup.registries.ItemRegistry;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class SourceSteelArmor extends MagicArmor{
    public SourceSteelArmor(EquipmentSlotType slot) {
        super(Materials.sourceSteel, slot, ItemRegistry.defaultItemProperties());
    }

    @Override
    public int getMaxManaBoost(){
        return 60;
    }

    @Override
    public int getManaRegenBonus(){
        return 8;
    }


    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player)
    {
        if(world.isClientSide || world.getGameTime()%200!=0||stack.getDamageValue()==0)
        {return;}

        ManaCapability.getMana(player).ifPresent(mana->{
            if(mana.getCurrentMana()>30){
                mana.removeMana(30);
                stack.setDamageValue(stack.getDamageValue() -1);
            }
        });
    }
}
