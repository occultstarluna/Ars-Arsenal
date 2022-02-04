package com.minttea.minecraft.arsarsenal.client.renderer.item;

import com.hollingsworth.arsnouveau.client.renderer.item.FixedGeoItemRenderer;
import com.minttea.minecraft.arsarsenal.common.items.SourceSteelPick;

public class PickRenderer extends FixedGeoItemRenderer<SourceSteelPick> {
    public PickRenderer() {
        super(new PickModel());
    }
}
