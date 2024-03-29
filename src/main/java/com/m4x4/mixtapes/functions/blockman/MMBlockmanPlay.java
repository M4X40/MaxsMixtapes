package com.m4x4.mixtapes.functions.blockman;

import com.m4x4.mixtapes.functions.handlers.MMBlockmanErroring;
import com.m4x4.mixtapes.functions.handlers.MMBlockmanStoreSlots;
import com.m4x4.mixtapes.functions.handlers.MMStoreCurrentSong;
import com.m4x4.mixtapes.network.MMDebugLogging;
import com.m4x4.mixtapes.network.MMGlobals;
import com.m4x4.mixtapes.network.MMPacket;
import com.m4x4.mixtapes.network.MMPacketHandler;
import com.m4x4.mixtapes.world.inventory.MMBlockmanMenu;
import net.minecraft.client.Game;
import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.GameMasterBlockItem;
import net.minecraft.world.item.Item;

import com.m4x4.mixtapes.maxs_mixtapes;
import net.minecraftforge.event.TickEvent;

import java.util.ArrayList;
import java.util.List;

public class MMBlockmanPlay {

    private static Boolean shouldWait = false;
    private static int tickCounter = 0;
    public static List<Object> params = new ArrayList<Object>();

    public static void ButtonPressed (Entity en, Player pl, Boolean showerrors, int SlotNum) throws InterruptedException {
        MMBlockmanStop.ButtonPressed(pl);
        MMBlockmanStop.ButtonPressed(pl);
        MMBlockmanStop.ButtonPressed(pl);
        params.clear();
        int OldStopCount = MMGlobals.Accessor.getstopCounter(pl);
        MMBlockmanStoreSlots.retrieveSlots(en);
        Item Cassette = MMBlockmanStoreSlots.getSlot(SlotNum);
        MMBlockmanErroring.CheckForErrors(Cassette, pl, en, showerrors, true); // Also plays audio
        SoundEvent song = MMBlockmanErroring.returnSong();
        MMStoreCurrentSong.setCurrentSong(song);
        Boolean SuccessfulPlay = MMBlockmanErroring.returnSuccess();

        final int[] SongNum = {0};

        LoopCycle(en, pl, SuccessfulPlay, MMBlockmanStoreSlots.getSongs(en, pl), SongNum, MMBlockmanStoreSlots.getSongLengths(en, pl));
    }

    public static void LoopCycle(Entity en, Player pl, Boolean SuccessfulPlay, SoundEvent[] Songs, int[] SongNum, int[] SongLengths) {
        final Boolean[] LoopCheck = {MMGlobals.Accessor.getIsLooped(pl)};
        MMDebugLogging.debugS(String.valueOf(LoopCheck[0]));
        int OldStopCount = MMGlobals.Accessor.getstopCounter(pl);
        //final Object lock = new Object();

        if (SuccessfulPlay && (LoopCheck[0])) {
            int length = SongLengths[SongNum[0]];
            params.clear();
            params.clear();
            params.add(en);
            params.add(pl);
            params.add(Songs);
            params.add(SongNum);
            params.add(SongLengths);
            params.add(OldStopCount);
            MMPacketHandler.INSTANCE.sendToServer(new MMPacket("loop", MMBlockmanStoreSlots.getSongLengths(en, pl)[0]));
        } else {
            MMBlockmanStop.ButtonPressed(pl);
        }
    }

    public static void Loop() {
        params = returnParams();
        Entity en = (Entity) params.get(0);
        MMDebugLogging.debugS(String.valueOf(en));
        Player pl = (Player) params.get(1);
        SoundEvent[] Songs = (SoundEvent[]) params.get(2);
        int[] SongNum = (int[]) params.get(3);
        int[] SongLengths = (int[]) params.get(4);
        final Boolean[] LoopCheck = {MMGlobals.Accessor.getIsLooped(pl)};
        int OldStopCount = (int) params.get(5);
        LoopCheck[0] = MMGlobals.Accessor.getIsLooped(pl);
        //QueueCheck[0] = MMGlobals.Accessor.getIsQueued(pl);
        if (OldStopCount == MMGlobals.Accessor.getstopCounter(pl)) {
            MMBlockmanStop.ButtonPressed(pl);
            if (LoopCheck[0]) { // Loop 1
                if (en instanceof Player _plr ? _plr.containerMenu instanceof MMBlockmanMenu : false) {
                    try {
                        ButtonPressed(en, pl, true, 0);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    Item Slot0 = MMBlockmanStoreSlots.getSlot(0);
                    MMDebugLogging.debugS(String.valueOf(Slot0));
                    MMBlockmanErroring.CheckForErrors(Slot0, pl, en, true, true);
                    LoopCycle(en, pl, MMBlockmanErroring.returnSuccess(), Songs, SongNum, SongLengths);
                }
            }
//                    else if (QueueCheck) { // Queue System
//                        synchronized(lock) { // Add a synchronized block
//                            MMDebugLogging.debugS("Entering QueueCheck block");
//                            int NextSongIndex = 1;
//                            if (SongNum[0] < 8) {
//                                MMDebugLogging.debugS("SongNum[0] < 8, looking for next song index");
//                                for (int i = 1; i < Songs.length - 1 - SongNum[0]; i++) {
//                                    if (Songs[i] != null) {
//                                        NextSongIndex = i;
//                                        break;
//                                    }
//                                    NextSongIndex = -1;
//                                }
//                                MMDebugLogging.debugS("NextSongIndex: " + NextSongIndex);
//                                if (NextSongIndex != -1) {
//                                    SongNum[0] += NextSongIndex;
//                                } else {
//                                    SongNum[0] = 0;
//                                }
//                            } else if (SongNum[0] == 8) {
//                                MMDebugLogging.debugS("SongNum[0] == 8, checking if Songs[9] is not null");
//                                if (Songs[9] != null) {
//                                    SongNum[0] = 9;
//                                } else {
//                                    SongNum[0] = 0;
//                                }
//                            } else {
//                                SongNum[0] = 0;
//                            }
//                            MMDebugLogging.debugS("SongNum[0]: " + SongNum[0]);
//                            MMDebugLogging.debugS(Arrays.toString(MMBlockmanStoreSlots.getSongNames(en, pl)));
//                            MMDebugLogging.debugS("" + String.valueOf(NextSongIndex) + " | " + String.valueOf(SongNum[0]));
//                            if (SongNum[0] != 0 || LoopCheck) { // Continue (Both Queue Only AND Loop All)
//                                MMDebugLogging.debugS("Entering Continue block");
//                                if (en instanceof Player _plr ? _plr.containerMenu instanceof MMBlockmanMenu : false) {
//                                    // Open
//                                    MMDebugLogging.debugS("GUI is open, swapping slots");
//                                    for (int i = 0; i < NextSongIndex; i++) {
//                                        MMBlockmanStoreSlots.retrieveSlots(en);
//                                        MMBlockmanQueueHandler.SwapSlots(en);
//                                    }
//                                } else {
//                                    // Closed
//                                    MMDebugLogging.debugS("GUI is closed, setting swapOnOpen to true");
//                                    MMGlobals.Accessor.setswapOnOpen(en, true);
//                                    MMBlockmanQueueHandler.QueueHandler(en);
//                                    MMDebugLogging.debugS("[SwapStuff] " + String.valueOf(MMGlobals.Accessor.getswapOnOpen(en)) + " | " + String.valueOf(MMGlobals.Accessor.getswapAmount(en)));
//                                }
//                                maxs_mixtapes.queueServerWork(20, () -> {
//                                    synchronized(lock) {
//                                        try {
//                                            MMDebugLogging.debugS("Playing sound: " + Songs[SongNum[0]]);
//                                            soundPlayer.playSound(pl, Songs[SongNum[0]]);
//                                        } catch (Exception e) {
//                                            MMDebugLogging.debugS("Exception caught while trying to play sound: " + e.getMessage());
//                                            e.printStackTrace();
//                                        }
//                                    }
//                                });
//
//                                LoopCycle(en, pl, SuccessfulPlay, Songs, SongNum, SongLengths);
//                            } else { // Stop (Queue Only End)
//                                MMDebugLogging.debugS("Entering Stop block");
//                                MMBlockmanStoreSlots.retrieveSlots(en);
//                                MMBlockmanQueueHandler.SwapSlots(en);
//                                MMGlobals.Accessor.setIsQueued(en, false);
//                            }
//                        }
//                    }
        }
    }

    public static List<Object> returnParams() {
        return params;
    }
}