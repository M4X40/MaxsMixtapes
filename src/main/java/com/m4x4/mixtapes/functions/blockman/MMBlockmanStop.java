package com.m4x4.mixtapes.functions.blockman;

import com.m4x4.mixtapes.functions.handlers.MMBlockmanStoreSlots;
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
        Item Cassette = MMBlockmanStoreSlots.getSlot(0);
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
        MMGlobals.Accessor.setSwapAmount(pl, 0);
        MMGlobals.Accessor.setSwapOnOpen(pl, false);

    }
}
