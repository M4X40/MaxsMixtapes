package com.m4x4.mixtapes.functions.blockman;

import com.m4x4.mixtapes.functions.handlers.MMStoreCurrentSong;
import com.m4x4.mixtapes.network.MMDebugLogging;
import com.m4x4.mixtapes.network.MMGlobals;
import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class MMBlockmanStop {
    public static void ButtonPressed (Entity en, Player pl) {
        SoundEvent song = MMStoreCurrentSong.getCurrentSong(en);
        try {
            MMDebugLogging.debugS(song.toString());
        } catch (Exception ignored) {}

        if (song != null) {
            Minecraft.getInstance().getSoundManager().stop(song.getLocation(), SoundSource.RECORDS);
            MMGlobals.Accessor.setstopCounter(pl, MMGlobals.Accessor.getstopCounter(pl) + 1);
//            MMGlobals.Accessor.setswapAmount(pl, 0);
//            MMGlobals.Accessor.setswapOnOpen(pl, false);
        }
    }
}
