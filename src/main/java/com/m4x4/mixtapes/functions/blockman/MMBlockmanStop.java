package com.m4x4.mixtapes.functions.blockman;

import com.m4x4.mixtapes.debug.MMDebugMessaging;
import com.m4x4.mixtapes.item.MMCassetteItem;
import com.m4x4.mixtapes.sound.soundPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MinecartItem;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;

public class MMBlockmanStop {
    public static void ButtonPressed (Entity en, Player pl) {
        ItemStack CassetteStack = en instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY;
        Item Cassette = CassetteStack.getItem();
        SoundEvent song;
        if (Cassette.getClass() == MMCassetteItem.class) {
            song = ((MMCassetteItem) Cassette).getMMSong();
        } else if (Cassette.getClass() == RecordItem.class) {
            song = ((RecordItem) Cassette).getSound();
        } else {
            return;
        }

        Minecraft.getInstance().getSoundManager().stop(song.getLocation(), SoundSource.RECORDS);

//        String songnamespace = String.valueOf(song.getLocation());
//        String plName = String.valueOf(pl.getName().getString());
//        String command  = "stopsound ".concat(plName).concat(" record ").concat(songnamespace);
//        System.out.println(command);

    }
}
