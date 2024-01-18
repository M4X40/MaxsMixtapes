package com.m4x4.mixtapes.functions.blockman;

import com.m4x4.mixtapes.network.MMGlobals;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class MMBlockmanQueue {
    public static void ButtonPressed (Entity en, Player pl) {
        Boolean check = MMGlobals.Accessor.getIsQueued(en);

        MMGlobals.Accessor.setIsQueued(en, !check);

        if (check) {
            // Inactive button images
        } else {
            // Active button images
        }
    }
}
