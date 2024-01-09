package com.m4x4.mixtapes.sound;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;

public class soundPlayer {
        public static void playSound(Player pl, SoundEvent se) {
            if (!pl.level.isClientSide) {
                return;
            }
            // player, entity, event, source, volume, pitch
            pl.level.playSound(pl, pl, se, SoundSource.RECORDS, 1, 1);
    }
}
