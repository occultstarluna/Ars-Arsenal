package com.minttea.minecraft.arsarsenal.common.items;

import com.hollingsworth.arsnouveau.ArsNouveau;
import com.hollingsworth.arsnouveau.api.item.ICasterTool;
import com.hollingsworth.arsnouveau.api.item.IScribeable;
import com.hollingsworth.arsnouveau.api.spell.AbstractSpellPart;
import com.hollingsworth.arsnouveau.api.spell.ISpellCaster;
import com.hollingsworth.arsnouveau.api.spell.Spell;
import com.hollingsworth.arsnouveau.common.items.SpellBook;
import com.hollingsworth.arsnouveau.common.items.SpellParchment;
import com.hollingsworth.arsnouveau.common.util.PortUtil;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class SpellGem extends Item implements ICasterTool {
    public SpellGem() {
        super(new Item.Properties().stacksTo(64).tab(ArsNouveau.itemGroup));
    }

    @Override
    public boolean onScribe(World world, BlockPos blockPos, PlayerEntity player, Hand hand, ItemStack itemStack) {
        ItemStack held = player.getMainHandItem();

        if(!(held.getItem() instanceof SpellParchment || held.getItem() instanceof SpellBook || held.getTag()==null))
            return false;

        Spell spell = new Spell();
        List<AbstractSpellPart> parts = null;
        if(held.getItem() instanceof SpellParchment) {
            parts = SpellParchment.getSpellRecipe(held);
        } else if(held.getItem() instanceof SpellBook) {
            parts = ((SpellBook) held.getItem()).getCurrentRecipe(held).recipe;
        }
        if(parts != null){
            spell = new Spell(parts);
            String spellTag = held.getTag().getString("spell");
            if(parts.size() +getSpell(itemStack).getSpellSize() > 32)
            {
                PortUtil.sendMessageCenterScreen(player, new StringTextComponent("Spell too complex."));
                return false;
            } else if (parts.size() == 0) {
                itemStack.getTag().putString("spell","");
            }else {
                if (getSpell(itemStack).getSpellSize() > 0) {
                    if(addToSpell(itemStack, spellTag)) {
                        PortUtil.sendMessageCenterScreen(player, new StringTextComponent("Added parts to spell: " + spell.getDisplayString()));
                        return true;
                    }
                } else {
                    if (setSpell(itemStack,spellTag)) {
                        PortUtil.sendMessageCenterScreen(player, new StringTextComponent("Set Spell: " + spell.getDisplayString()));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getItemInHand(handIn);
        ISpellCaster caster = getSpellCaster(stack);
        if(caster.getSpell() != Spell.EMPTY)
        {
            caster.getSpell().setCost(0);
        }
        ActionResult<ItemStack> result =  caster.castSpell(worldIn, playerIn, handIn, new TranslationTextComponent("ars_nouveau.wand.invalid"));
        if(result.getResult() == ActionResultType.CONSUME)
        {
            stack.shrink(1);
        }
        return result;
    }

    private boolean setSpell(ItemStack itemStack, String recipe) {
        itemStack.getTag().putString("spell",recipe);
        return true;
    }
    private Spell getSpell(ItemStack stack){
        assert stack.getTag() != null;
        return Spell.deserialize(stack.getTag().getString("spell"));
    }
    private boolean addToSpell(ItemStack itemStack, String recipe) {
        String spellTag = itemStack.getTag().getString("spell");
        spellTag+= recipe;
        itemStack.getTag().putString("spell",spellTag);
        return true;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag p_77624_4_) {
        if(!stack.hasTag() || stack.getTag().getString("spell").equals(""))
            return;

        //List<AbstractSpellPart> spellsFromTagString = SpellRecipeUtil.getSpellsFromTagString();
        Spell spell = Spell.deserialize(stack.getTag().getString("spell"));
        //LOGGER.debug("fuckin, okay" + spell.getDisplayString());

        tooltip.add(new StringTextComponent(spell.getDisplayString()));

    }
}
