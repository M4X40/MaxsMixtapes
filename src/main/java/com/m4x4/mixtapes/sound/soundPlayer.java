package com.m4x4.mixtapes.sound;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.ProfilePublicKey;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.m4x4.mixtapes.sound.MMSongs;

public class soundPlayer {
    public static void playSound(Player player, SoundEvent soundEvent, float volume, float pitch) {
        if (!player.level.isClientSide) {
            return;
        }
        player.level.playLocalSound(player.getX(), player.getY(), player.getZ(), soundEvent, SoundSource.MASTER, volume, pitch, false);
    }
}
