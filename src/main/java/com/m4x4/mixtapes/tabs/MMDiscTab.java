package com.m4x4.mixtapes.tabs;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import static com.m4x4.mixtapes.item.MMCassettes.Blockman;

public class MMDiscTab extends CreativeModeTab {
    private MMDiscTab(int index, String label) {
        super(index, label);
    }

    @Override
    public @NotNull ItemStack makeIcon() {
        return new ItemStack(Blockman.get());
    }

    public static final MMDiscTab instance = new MMDiscTab(CreativeModeTab.TABS.length, "MM Cassettes");
}
