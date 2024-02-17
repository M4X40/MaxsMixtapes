package com.m4x4.mixtapes.functions.blockman;

import com.m4x4.mixtapes.functions.handlers.MMBlockmanErroring;
import com.m4x4.mixtapes.functions.handlers.MMBlockmanQueueHandler;
import com.m4x4.mixtapes.functions.handlers.MMBlockmanStoreSlots;
import com.m4x4.mixtapes.network.MMDebugLogging;
import com.m4x4.mixtapes.network.MMGlobals;
import com.m4x4.mixtapes.sound.soundPlayer;
import com.m4x4.mixtapes.world.inventory.MMBlockmanMenu;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;

import com.m4x4.mixtapes.maxs_mixtapes;
import net.minecraft.world.item.RecordItem;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class MMBlockmanPlay {
    public static void ButtonPressed (Entity en, Player pl, Boolean showerrors) throws InterruptedException {
        MMBlockmanStop.ButtonPressed(en, pl);
        int OldStopCount = MMGlobals.Accessor.getStopCounter(pl);
        MMBlockmanStoreSlots.retrieveSlots(en);
        Item Cassette = MMBlockmanStoreSlots.getSlot(0);
        MMBlockmanErroring.CheckForErrors(Cassette, pl, en, showerrors, true); // Also plays audio
        SoundEvent song = MMBlockmanErroring.returnSong();
        Boolean SuccessfulPlay = MMBlockmanErroring.returnSuccess();

        Boolean LoopCheck = MMGlobals.Accessor.getIsLooped(pl);
        Boolean QueueCheck = MMGlobals.Accessor.getIsQueued(pl);

        final int[] SongNum = {0};

        LoopCycle(en, pl, SuccessfulPlay, MMBlockmanStoreSlots.getSongs(en, pl), SongNum, MMBlockmanStoreSlots.getSongLengths(en, pl));

    }

    public static void LoopCycle(Entity en, Player pl, Boolean SuccessfulPlay, SoundEvent[] Songs, int[] SongNum, int[] SongLengths) {
        Boolean LoopCheck = MMGlobals.Accessor.getIsLooped(pl);
        Boolean QueueCheck = MMGlobals.Accessor.getIsQueued(pl);
        int OldStopCount = MMGlobals.Accessor.getStopCounter(pl);

        if (SuccessfulPlay && (LoopCheck || QueueCheck)) {
            int length = SongLengths[SongNum[0]];
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
                            MMBlockmanErroring.CheckForErrors(Slot0, pl, en, true, true);
                            LoopCycle(en, pl, SuccessfulPlay, Songs, SongNum, SongLengths);
                        }
                    } else if (QueueCheck) { // Queue System
                        int NextSongIndex = 1;
                        if (SongNum[0] < 8) {
                            for (int i = 1; i < Songs.length - 1 - SongNum[0]; i++) {
                                if (Songs[i] != null) {
                                    NextSongIndex = i;
                                    break;
                                }
                                NextSongIndex = -1;
                            }
                            if (NextSongIndex != -1) {
                                SongNum[0] += NextSongIndex;
                            } else {
                                SongNum[0] = 0;
                            }
                        } else if (SongNum[0] == 8) {
                            if (Songs[9] != null) {
                                SongNum[0] = 9;
                            } else {
                                SongNum[0] = 0;
                            }
                        } else {
                            SongNum[0] = 0;
                        }
                        MMDebugLogging.debugS(Arrays.toString(MMBlockmanStoreSlots.getSongNames(en, pl)));
                        MMDebugLogging.debugS("" + String.valueOf(NextSongIndex) + " | " + String.valueOf(SongNum[0]));
                        if (SongNum[0] != 0 || LoopCheck) { // Continue (Both Queue Only AND Loop All)
                            if (en instanceof Player _plr ? _plr.containerMenu instanceof MMBlockmanMenu : false) {
                                // Open
                                for (int i = 0; i < NextSongIndex; i++) {
                                    MMBlockmanStoreSlots.retrieveSlots(en);
                                    MMBlockmanQueueHandler.SwapSlots(en);
                                }
                            } else {
                                // Closed
                                MMGlobals.Accessor.setSwapOnOpen(en, true);
                                MMBlockmanQueueHandler.QueueHandler(en);
                                MMDebugLogging.debugS("[SwapStuff] " + String.valueOf(MMGlobals.Accessor.getSwapOnOpen(en)) + " | " + String.valueOf(MMGlobals.Accessor.getSwapAmount(en)));
                            }
                            soundPlayer.playSound(pl, Songs[SongNum[0]]);

                            LoopCycle(en, pl, SuccessfulPlay, Songs, SongNum, SongLengths);
                        } else { // Stop (Queue Only End)
                            MMBlockmanStoreSlots.retrieveSlots(en);
                            MMBlockmanQueueHandler.SwapSlots(en);
                            MMGlobals.Accessor.setIsQueued(en, false);
                        }
                    }
                }
            });
        }
    }
}