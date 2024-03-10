package com.m4x4.mixtapes.functions.handlers;

import com.m4x4.mixtapes.network.MMDebugLogging;
import com.m4x4.mixtapes.network.MMGlobals;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;

public class MMBlockmanQueueHandler {
    public static void SwapSlots(Entity en) {
        ItemStack S0 = MMBlockmanStoreSlots.getSlotStack(0);
        ItemStack S1 = MMBlockmanStoreSlots.getSlotStack(1);
        ItemStack S2 = MMBlockmanStoreSlots.getSlotStack(2);
        ItemStack S3 = MMBlockmanStoreSlots.getSlotStack(3);
        ItemStack S4 = MMBlockmanStoreSlots.getSlotStack(4);
        ItemStack S5 = MMBlockmanStoreSlots.getSlotStack(5);
        ItemStack S6 = MMBlockmanStoreSlots.getSlotStack(6);
        ItemStack S7 = MMBlockmanStoreSlots.getSlotStack(7);
        ItemStack S8 = MMBlockmanStoreSlots.getSlotStack(8);
        ItemStack S9 = MMBlockmanStoreSlots.getSlotStack(9);
        MMBlockmanStoreSlots.setSlot(en, 9, S0);
        MMBlockmanStoreSlots.setSlot(en, 8, S9);
        MMBlockmanStoreSlots.setSlot(en, 7, S8);
        MMBlockmanStoreSlots.setSlot(en, 6, S7);
        MMBlockmanStoreSlots.setSlot(en, 5, S6);
        MMBlockmanStoreSlots.setSlot(en, 4, S5);
        MMBlockmanStoreSlots.setSlot(en, 3, S4);
        MMBlockmanStoreSlots.setSlot(en, 2, S3);
        MMBlockmanStoreSlots.setSlot(en, 1, S2);
        MMBlockmanStoreSlots.setSlot(en, 0, S1);
    }

    public static void QueueHandler(Entity en) {
        if (MMGlobals.Accessor.getswapOnOpen(en)) {
            MMDebugLogging.debugS("Before: " + MMGlobals.Accessor.getswapAmount(en));
            MMGlobals.Accessor.setswapAmount(en, MMGlobals.Accessor.getswapAmount(en) + 1);
            MMDebugLogging.debugS("After: " + MMGlobals.Accessor.getswapAmount(en));
            if (MMGlobals.Accessor.getswapAmount(en) > 9) {
                MMGlobals.Accessor.setswapAmount(en, 0);
            }
        }
    }
}
