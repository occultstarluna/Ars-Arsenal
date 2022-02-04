package com.minttea.minecraft.arsarsenal.common.armor;

import com.hollingsworth.arsnouveau.api.mana.IManaEquipment;
import com.hollingsworth.arsnouveau.common.capability.CapabilityRegistry;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class MagicArmor extends ArmorItem implements IManaEquipment {

    protected int repairCost = 0;
    public MagicArmor(ArmorMaterial materialIn, EquipmentSlot slot, Properties builder) {
        super(materialIn, slot, builder);
    }


    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player)
    {
        if(world.isClientSide || world.getGameTime()%200!=0||stack.getDamageValue()==0)
        {return;}

        CapabilityRegistry.getMana(player).ifPresent(mana->{
            if(mana.getCurrentMana()>repairCost){
                mana.removeMana(repairCost);
                stack.setDamageValue(stack.getDamageValue() -1);
            }
        });
    }



}
