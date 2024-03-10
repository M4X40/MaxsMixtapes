package com.m4x4.mixtapes.functions.handlers;

import com.m4x4.mixtapes.network.MMDebugLogging;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;


public class MMStoreCurrentSong {
    private static SoundEvent currentSong;

    public static void setCurrentSong(Entity en, SoundEvent song) {
        if (song != null) {
            MMDebugLogging.debugS("Trying to set song | ------");
            currentSong = song;
            MMDebugLogging.debugS("Song set to " + song + " | -------");
        }
    }

    public static SoundEvent getCurrentSong(Entity en) {
        return currentSong;
    }
}
