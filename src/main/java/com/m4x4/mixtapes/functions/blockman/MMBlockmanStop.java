package com.m4x4.mixtapes.functions.blockman;

import com.m4x4.mixtapes.functions.handlers.MMBlockmanStoreSlots;
import com.m4x4.mixtapes.item.MMCassetteItem;
import com.m4x4.mixtapes.network.MMDebugLogging;
import com.m4x4.mixtapes.network.MMGlobals;
import com.m4x4.mixtapes.world.inventory.MMBlockmanMenu;
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
        if (en instanceof Player _plr && _plr.containerMenu instanceof MMBlockmanMenu) {
            MMBlockmanStoreSlots.retrieveSlots(en);
        }
        MMDebugLogging.debugS(MMBlockmanStoreSlots.getSlot(0).toString());
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
        MMGlobals.Accessor.setstopCounter(pl ,MMGlobals.Accessor.getstopCounter(pl) + 1);
        MMGlobals.Accessor.setswapAmount(pl, 0);
        MMGlobals.Accessor.setswapOnOpen(pl, false);
        MMDebugLogging.debugS(Cassette + " | " + song);
    }
}
