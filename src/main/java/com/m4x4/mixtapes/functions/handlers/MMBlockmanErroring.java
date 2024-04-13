package com.m4x4.mixtapes.functions.handlers;

import com.m4x4.mixtapes.item.MMCassetteItem;
import com.m4x4.mixtapes.item.MMItems;
import com.m4x4.mixtapes.maxs_mixtapes;
import com.m4x4.mixtapes.network.MMDebugLogging;
import com.m4x4.mixtapes.network.MMGlobals;
import com.m4x4.mixtapes.sound.MMSongs;
import com.m4x4.mixtapes.sound.soundPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.RecordItem;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Random;

public class MMBlockmanErroring {
    static SoundEvent song;
    static Boolean SuccessfulPlay = false;

    public static void CheckForErrors(Item Cassette, Player pl, Entity en, Boolean showerrors, boolean playAudio) {
        if (Cassette.getClass() == MMCassetteItem.class) {
            song = ((MMCassetteItem) Cassette).getMMSong();
            SuccessfulPlay = true;
        } else if (Cassette.getClass() == RecordItem.class) {
            song = ((RecordItem) Cassette).getSound();
            SuccessfulPlay = true;
        } else if (Cassette.toString().equals("bread")) {
            song = MMSongs.DANBREAD.get();
            SuccessfulPlay = true;
        } else if (Cassette == MMItems.handsome_devil.get()) {
            song = MMSongs.ROME_REACTION.get();
            SuccessfulPlay = true;
        } else {
            MMDebugLogging.debugS("Error. Printing Now");
            song = null;
            if (showerrors) {
                String name = String.valueOf(pl.getName());
                SuccessfulPlay = false;
                String ErrorMessage;
                if (maxs_mixtapes.DebugMode) {
                    ErrorMessage = getString(10);
                } else if (!MMGlobals.Accessor.gethasFound(en) && (name == "R0M7" || name == "TizNixon" || name == "baligaman" || name == "ZweiForgot")) {
                    ErrorMessage = getString(11);
                } else {
                    Random rand = new Random();
                    int randnum = rand.nextInt(10);

                    ErrorMessage = getString(randnum);
                }
                pl.sendSystemMessage(Component.literal(ErrorMessage));
                MMDebugLogging.debugS("Sent: " + ErrorMessage);
            }
        }
        if (playAudio && SuccessfulPlay) {
            soundPlayer.playSound(pl, song);
        }
    }

    public static SoundEvent returnSong() {
        return song;
    }

    public static Boolean returnSuccess() {
        return SuccessfulPlay;
    }

    @NotNull
    private static String getString(int randnum) {

        Item DebugSlot = MMBlockmanStoreSlots.getSlot(0);

        return switch (randnum) {
            case 0 -> "<Blockman Speaker> Yo tf you think you're doing";
            case 1 -> "<Blockman Speaker> That item isn't compatible dud.";
            case 2 -> "<Blockman Speaker> Thats not a compatible music format.";
            case 3 -> "<Blockman Speaker> Please enter a real cassette or disc.";
            case 4 -> "<Blockman Speaker> I really hope this is to test my limits and not because you think it actually has sounds.";
            case 5 -> "<Blockman Speaker> Chill out, thats not a cassette or disc.";
            case 6 -> "<Blockman Speaker> Do that again and I'll explode. Just kidding, I can't.";
            case 7 -> "<Blockman Speaker> teehee oopsie woopsie that no workie :3c";
            case 8 -> "<Blockman Speaker> I swear to god if you put a piece of bread in here I'll personally break your pigstep disc.";
            case 9 -> "<Blockman Speaker> Wow this is a secret, good job.";
            case 10 -> "<Blockman Speaker> " + String.valueOf(DebugSlot) + " | " + String.valueOf(MMBlockmanStoreSlots.getSlot(0));
            case 11 -> "<Blockman Speaker> https://www.youtube.com/watch?v=xvFZjo5PgG0";
            default -> "<Blockman Speaker> This should literally be impossible to see, the mod is broken somehow, report this to M4X4. [ERR CODE: " + randnum + "]";
        };
    }
}
