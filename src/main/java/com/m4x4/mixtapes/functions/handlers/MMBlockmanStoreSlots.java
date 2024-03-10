package com.m4x4.mixtapes.functions.handlers;

import com.m4x4.mixtapes.item.MMCassetteItem;
import com.m4x4.mixtapes.item.MMItems;
import com.m4x4.mixtapes.maxs_mixtapes;
import com.m4x4.mixtapes.network.MMGlobals;
import com.m4x4.mixtapes.sound.MMSongs;
import com.m4x4.mixtapes.world.inventory.MMBlockmanMenu;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.RecordItem;

import java.util.Map;
import java.util.function.Supplier;

public class MMBlockmanStoreSlots {
    private static ItemStack S0;
    private static ItemStack S1;
    private static ItemStack S2;
    private static ItemStack S3;
    private static ItemStack S4;
    private static ItemStack S5;
    private static ItemStack S6;
    private static ItemStack S7;
    private static ItemStack S8;
    private static ItemStack S9;
    private static SoundEvent[] Songs = {null, null, null, null, null, null, null, null, null, null};
    private static int[] SongLengths = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static void retrieveSlots(Entity en) {
        S0 = en instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY;
        S1 = en instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY;
        S2 = en instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY;
        S3 = en instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY;
        S4 = en instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY;
        S5 = en instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(5)).getItem() : ItemStack.EMPTY;
        S6 = en instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(6)).getItem() : ItemStack.EMPTY;
        S7 = en instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(7)).getItem() : ItemStack.EMPTY;
        S8 = en instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(8)).getItem() : ItemStack.EMPTY;
        S9 = en instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(9)).getItem() : ItemStack.EMPTY;
    }

    public static Item getSlot(int Slot) {
        return switch (Slot) {
            default -> S0.getItem();
            case 1 -> S1.getItem();
            case 2 -> S2.getItem();
            case 3 -> S3.getItem();
            case 4 -> S4.getItem();
            case 5 -> S5.getItem();
            case 6 -> S6.getItem();
            case 7 -> S7.getItem();
            case 8 -> S8.getItem();
            case 9 -> S9.getItem();
        };
    }
    public static ItemStack getSlotStack(int Slot) {
        return switch (Slot) {
            default -> S0;
            case 1 -> S1;
            case 2 -> S2;
            case 3 -> S3;
            case 4 -> S4;
            case 5 -> S5;
            case 6 -> S6;
            case 7 -> S7;
            case 8 -> S8;
            case 9 -> S9;
        };
    }

    public static void setSlot(Entity en, int Slot, ItemStack item) {
        if (en instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
            ItemStack _setstack = item;
            _setstack.setCount(1);
            ((Slot) _slots.get(Slot)).set(_setstack);
            _player.containerMenu.broadcastChanges();
        }
    }

    public static void retrieveSongs(Entity en, Player pl) {
        if (en instanceof Player _plr && _plr.containerMenu instanceof MMBlockmanMenu) {
            retrieveSlots(en);
        }
        for (int i = 0; i < 10; i++) {
            Item Cassette = MMBlockmanStoreSlots.getSlot(i);
            MMBlockmanErroring.CheckForErrors(Cassette, pl, en, false, false);
            Songs[i] = MMBlockmanErroring.returnSong();
            if (MMBlockmanErroring.returnSong() != null) {
                if (Cassette.getClass() == Item.class) {
                    if (Cassette.toString().equals("bread")) {
                        SongLengths[i] = 220;
                    } else if (Cassette == MMItems.handsome_devil.get()) {
                        SongLengths[i] = 380;
                    }
                } else {
                    SongLengths[i] = ((RecordItem) Cassette).getLengthInTicks();
                }
            } else {
                SongLengths[i] = 0;
            }
        }
    }

    public static SoundEvent[] getSongs(Entity en, Player pl) {
        retrieveSongs(en, pl);
        return Songs;
    }
    public static SoundEvent[] getSongsNR(Entity en, Player pl) {
        return Songs;
    }

    public static String[] getSongNames(Entity en, Player pl) {
        String[] returnString = {"","","","","","","","","",""};
        for (int i = 0; i < Songs.length; i++) {
            returnString[i] = String.valueOf(Songs[i].getLocation());
        }
        return returnString;
    }
    public static int[] getSongLengths(Entity en, Player pl) {
        retrieveSongs(en, pl);
        return SongLengths;
    }
}






















