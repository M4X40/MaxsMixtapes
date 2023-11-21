package com.m4x4.mixtapes.item;

import com.m4x4.mixtapes.sound.MMSongs;
import com.m4x4.mixtapes.sound.soundPlayer;
import com.mojang.authlib.GameProfile;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.ProfilePublicKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MMBlockmanUsage extends Item {
    public MMBlockmanUsage(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level world, @NotNull Player player, @NotNull InteractionHand hand) {
        System.out.println("Blockman M2 Click");
        SoundEvent testsound = MMSongs.TEST_SOUND.get();
        soundPlayer.playSound(player, testsound, 1, 1);
        return super.use(world, player, hand);
    }
}