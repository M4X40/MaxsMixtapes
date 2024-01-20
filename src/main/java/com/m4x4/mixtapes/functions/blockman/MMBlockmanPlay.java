package com.m4x4.mixtapes.functions.blockman;

import com.m4x4.mixtapes.functions.handlers.MMBlockmanErroring;
import com.m4x4.mixtapes.functions.handlers.MMBlockmanStoreSlots;
import com.m4x4.mixtapes.item.MMCassetteItem;
import com.m4x4.mixtapes.item.MMItems;
import com.m4x4.mixtapes.network.MMGlobals;
import com.m4x4.mixtapes.sound.MMSongs;
import com.m4x4.mixtapes.sound.soundPlayer;
import com.m4x4.mixtapes.world.inventory.MMBlockmanMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;

import com.m4x4.mixtapes.maxs_mixtapes;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import com.m4x4.mixtapes.maxs_mixtapes;

public class MMBlockmanPlay {
    public static void ButtonPressed (Entity en, Player pl, Boolean showerrors) throws InterruptedException {
        int OldStopCount = MMGlobals.Accessor.getStopCounter(pl);
        MMBlockmanStoreSlots.retrieveSlots(en);
        Item Cassette = MMBlockmanStoreSlots.getSlot(0);
        MMBlockmanErroring.CheckForErrors(Cassette, pl, en, showerrors);
        SoundEvent song = MMBlockmanErroring.returnSong();
        Boolean SuccessfulPlay = MMBlockmanErroring.returnSuccess();

        Boolean LoopCheck = MMGlobals.Accessor.getIsLooped(pl);
        Boolean QueueCheck = MMGlobals.Accessor.getIsQueued(pl);
        if (SuccessfulPlay && (LoopCheck || QueueCheck)) {
            int length = ((RecordItem) Cassette).getLengthInTicks();
            maxs_mixtapes.queueServerWork(length, () -> {
                if (OldStopCount == MMGlobals.Accessor.getStopCounter(pl)) {
                    if (!QueueCheck && LoopCheck) { // Loop 1
                        if (en instanceof Player _plr ? _plr.containerMenu instanceof MMBlockmanMenu : false) {
                            try {
                                ButtonPressed(en, pl, true);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        } else {
                            Item Slot0 = MMBlockmanStoreSlots.getSlot(0);
                            MMBlockmanErroring.CheckForErrors(Slot0, pl, en, true);
                            if (MMBlockmanErroring.returnSuccess()) {
                                soundPlayer.playSound(pl, song);
                            }
                        }

                    } else if (QueueCheck && LoopCheck) { // Loop all
                        // Cycle Slots
                        // Play new song
                        //
                    } else { // Queue only
                        //To be implemented
                    }
                }
            });
        }

    }
}