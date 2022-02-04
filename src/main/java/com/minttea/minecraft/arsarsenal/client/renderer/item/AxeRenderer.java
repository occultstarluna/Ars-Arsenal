package com.minttea.minecraft.arsarsenal.client.renderer.item;

import com.hollingsworth.arsnouveau.client.renderer.item.FixedGeoItemRenderer;
import com.minttea.minecraft.arsarsenal.common.items.SourceSteelAxe;

public class AxeRenderer extends FixedGeoItemRenderer<SourceSteelAxe> {
    public AxeRenderer() {
        super(new AxeModel());
    }

}
