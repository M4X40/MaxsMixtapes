package com.m4x4.mixtapes.tabs;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import static com.m4x4.mixtapes.item.MMCassettes.Blockman;
import static com.m4x4.mixtapes.item.MMCassettes.TestCassette;

public class MMItemTab extends CreativeModeTab {
    private MMItemTab(int index, String label) {
        super(index, label);
    }

    @Override
    public @NotNull ItemStack makeIcon() {
        return new ItemStack(Blockman.get());
    }

    public static final MMItemTab instance = new MMItemTab(CreativeModeTab.TABS.length, "MM Items");
}
