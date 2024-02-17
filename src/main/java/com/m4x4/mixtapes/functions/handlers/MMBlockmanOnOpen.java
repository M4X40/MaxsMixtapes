package com.m4x4.mixtapes.functions.handlers;

import com.m4x4.mixtapes.maxs_mixtapes;
import com.m4x4.mixtapes.network.MMDebugLogging;
import com.m4x4.mixtapes.network.MMGlobals;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class MMBlockmanOnOpen {
    public static void BlockmanOnOpen(Entity en) {
        MMDebugLogging.debugS("Opened Blockman");
        maxs_mixtapes.queueServerWork(40, () -> {
            MMDebugLogging.debugS(String.valueOf(MMGlobals.Accessor.getSwapOnOpen(en)));
            if (MMGlobals.Accessor.getSwapOnOpen(en)) {
                for (int i = 0; i < MMGlobals.Accessor.getSwapAmount(en); i++) {
                    MMBlockmanStoreSlots.retrieveSlots(en);
                    MMBlockmanQueueHandler.SwapSlots(en);
                    MMDebugLogging.debugS(String.valueOf(i));
                }
                MMGlobals.Accessor.setSwapOnOpen(en, false);
                MMGlobals.Accessor.setSwapAmount(en, 0);
            } else {
                MMDebugLogging.debugS("Didnt work dumbass | " + MMGlobals.Accessor.getSwapOnOpen(en));
            }
        });
    }
}
