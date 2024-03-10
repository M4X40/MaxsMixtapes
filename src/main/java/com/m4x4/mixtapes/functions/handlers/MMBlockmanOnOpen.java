package com.m4x4.mixtapes.functions.handlers;

import com.m4x4.mixtapes.maxs_mixtapes;
import com.m4x4.mixtapes.network.MMDebugLogging;
import com.m4x4.mixtapes.network.MMGlobals;
import com.m4x4.mixtapes.world.inventory.MMBlockmanMenu;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class MMBlockmanOnOpen {
    public static void BlockmanOnOpen(Entity en) {
        MMDebugLogging.debugS("Opened Blockman | " + MMGlobals.Accessor.getswapOnOpen(en));
        maxs_mixtapes.queueServerWork(40, () -> {
            MMDebugLogging.debugS(String.valueOf(MMGlobals.Accessor.getswapOnOpen(en)));
            if (MMGlobals.Accessor.getswapOnOpen(en)) {
                for (int i = 0; i < MMGlobals.Accessor.getswapAmount(en); i++) {
                    MMBlockmanStoreSlots.retrieveSlots(en);
                    MMBlockmanQueueHandler.SwapSlots(en);
                    MMDebugLogging.debugS(String.valueOf(i));
                }
                MMGlobals.Accessor.setswapOnOpen(en, false);
                MMGlobals.Accessor.setswapAmount(en, 0);
            } else {
                MMDebugLogging.debugS("Didnt work dumbass | " + MMGlobals.Accessor.getswapOnOpen(en));
            }
        });
    }
}
