package com.m4x4.mixtapes.functions.blockman;

import com.m4x4.mixtapes.item.MMCassetteItem;
import com.m4x4.mixtapes.network.MMGlobals;
import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.RecordItem;

import java.util.Map;
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
        MMGlobals.Accessor.setStopCounter(pl ,MMGlobals.Accessor.getStopCounter(pl) + 1);

    }
}
