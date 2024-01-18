package com.m4x4.mixtapes.sound;

import com.m4x4.mixtapes.network.MMGlobals;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.client.sounds.WeighedSoundEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import org.jetbrains.annotations.Nullable;

public class soundPlayer {
        public static void playSound(Player pl, SoundEvent se) {
            if (!pl.level.isClientSide) {
                return;
            }
            // player, entity, event, source, volume, pitch
            pl.level.playSound(pl, pl, se, SoundSource.RECORDS, 1, 1);
    }
}
