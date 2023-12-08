package com.m4x4.mixtapes.tabs;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import static com.m4x4.mixtapes.item.MMItems.cassette_alpha;

public class MMDiscTab extends CreativeModeTab {
    private MMDiscTab(int index, String label) {
        super(index, label);
    }

    @Override
    public @NotNull ItemStack makeIcon() {
        return new ItemStack(cassette_alpha.get());
    }

    public static final MMDiscTab instance = new MMDiscTab(CreativeModeTab.TABS.length, "MM Cassettes");
}
