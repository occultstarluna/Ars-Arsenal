package com.minttea.minecraft.arsarsenal.common.armor;

import com.hollingsworth.arsnouveau.api.event.SpellModifierEvent;
import com.hollingsworth.arsnouveau.api.spell.AbstractSpellPart;
import com.hollingsworth.arsnouveau.api.spell.SpellSchool;
import com.hollingsworth.arsnouveau.common.capability.ManaCapability;
import com.hollingsworth.arsnouveau.common.util.PortUtil;
import com.minttea.minecraft.arsarsenal.setup.registries.ItemRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.List;

public class SchoolArmor extends MagicArmor implements IAnimatable {


     private SpellSchool school;
     public final List<DamageSource> preventedTypes;

     public SchoolArmor(IArmorMaterial material, EquipmentSlotType slot, SpellSchool school, List<DamageSource> preventedTypes) {
          super(material, slot, ItemRegistry.defaultItemProperties());
          this.school = school;
          this.preventedTypes = preventedTypes;

     }


     @Override
     public int getMaxManaBoost(){
          return 100;
     }

     @Override
     public int getManaRegenBonus(){
          return 9;
     }


     @Override
     public void onArmorTick(ItemStack stack, World world, PlayerEntity player)
     {
          if(world.isClientSide || world.getGameTime()%200!=0||stack.getDamageValue()==0)
          {return;}

          ManaCapability.getMana(player).ifPresent(mana->{
               if(mana.getCurrentMana()>20){
                    mana.removeMana(20);
                    stack.setDamageValue(stack.getDamageValue() -1);
               }
          });
     }
     public void onModifier(SpellModifierEvent event) {
          if(school.isPartOfSchool(event.spellPart))
          {
               event.builder.addAmplification(1);
          }
     }

     public double getDiscount(List<AbstractSpellPart> recipe)
     {
          for (AbstractSpellPart part: recipe) {
               if(part.getSchools().contains(this.school))
                    return 0.1;
          }
          return 0;
     }

     @Override
     public void registerControllers(AnimationData animationData) {

     }
     public AnimationFactory factory = new AnimationFactory(this);

     @Override
     public AnimationFactory getFactory() {
          return factory;
     }

     public String getTextureName() {
          return "magic_hat";
     }
}
