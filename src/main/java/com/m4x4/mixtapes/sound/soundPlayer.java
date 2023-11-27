package com.m4x4.mixtapes.sound;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.ClientRecipeBook;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.StatsCounter;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.ProfilePublicKey;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.m4x4.mixtapes.sound.MMSongs;

public class soundPlayer {
        public static void playSound(Player pl, SoundEvent se) {
            if (!pl.level.isClientSide) {
                return;
            }
            pl.level.playSound(pl, pl, se, SoundSource.RECORDS, 1, 1);
    }
}
