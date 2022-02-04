package com.minttea.minecraft.arsarsenal.common.armor;

import com.hollingsworth.arsnouveau.api.event.SpellModifierEvent;
import com.hollingsworth.arsnouveau.api.spell.AbstractSpellPart;
import com.hollingsworth.arsnouveau.api.spell.SpellSchool;
import com.minttea.minecraft.arsarsenal.setup.registries.ItemRegistry;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.List;

public class SchoolArmor extends MagicArmor implements IAnimatable {


     public SpellSchool getSchool() {
          return school;
     }

     private SpellSchool school;
     public final List<DamageSource> preventedTypes;

     public SchoolArmor(ArmorMaterial material, EquipmentSlot slot, SpellSchool school, List<DamageSource> preventedTypes) {
          super(material, slot, ItemRegistry.defaultItemProperties());
          this.school = school;
          this.preventedTypes = preventedTypes;
          this.repairCost = 20;
     }


     @Override
     public int getMaxManaBoost(ItemStack i){
          return 100;
     }

     @Override
     public int getManaRegenBonus(ItemStack i){
          return 9;
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
