package com.m4x4.mixtapes.functions.blockman;

import com.m4x4.mixtapes.network.MMGlobals;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

import com.m4x4.mixtapes.maxs_mixtapes;

public class MMBlockmanLoop {
    public static void ButtonPressed (Entity en, Player pl) {
        Boolean check = MMGlobals.Accessor.getIsLooped(en);

        MMGlobals.Accessor.setIsLooped(en, !check);

        maxs_mixtapes.LOGGER.debug(String.valueOf(!check));

        if (check) {
            // Inactive button images
        } else {
            // Active button images
        }
    }
}

