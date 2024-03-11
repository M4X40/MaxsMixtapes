package com.m4x4.mixtapes.functions.handlers;

import com.m4x4.mixtapes.network.MMDebugLogging;
import net.minecraft.sounds.SoundEvent;


public class MMStoreCurrentSong {
    private static SoundEvent currentSong;

    public static void setCurrentSong(SoundEvent song) {
        if (song != null) {
            currentSong = song;
            MMDebugLogging.debugS("Song set to " + song + " | -------");
        }
    }

    public static SoundEvent getCurrentSong() {
        return currentSong;
    }
}
