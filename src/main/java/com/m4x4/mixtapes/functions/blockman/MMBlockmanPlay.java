package com.m4x4.mixtapes.functions.blockman;

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
        Boolean SuccessfulPlay = false;
        ItemStack CassetteStack = en instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY;
        Item Cassette = CassetteStack.getItem();
        SoundEvent song;
        if (Cassette.getClass() == MMCassetteItem.class) {
            song = ((MMCassetteItem) Cassette).getMMSong();
            soundPlayer.playSound(pl, song);
            SuccessfulPlay = true;
        } else if (Cassette.getClass() == RecordItem.class) {
            song = ((RecordItem) Cassette).getSound();
            soundPlayer.playSound(pl, song);
            SuccessfulPlay = true;
        } else if (Cassette.toString() == "bread") {
            song = MMSongs.DANBREAD.get();
            soundPlayer.playSound(pl, song);
            SuccessfulPlay = true;
        } else if (Cassette == MMItems.airpod.get()) {
            song = MMSongs.THEBEAST.get();
            soundPlayer.playSound(pl, song);
            SuccessfulPlay = true;
        } else if (Cassette == MMItems.handsome_devil.get()) {
            song = MMSongs.ROME_REACTION.get();
            soundPlayer.playSound(pl, song);
            SuccessfulPlay = true;
        } else {
            song = null;
            if (showerrors) {
                Random rand = new Random();
                int randnum = rand.nextInt(10);

                String ErrorMessage = getString(randnum);

                if (en instanceof Player _player && !_player.level.isClientSide())
                    _player.displayClientMessage(Component.literal(ErrorMessage), false);
                SuccessfulPlay = false;
                return;
            }
            SuccessfulPlay = false;
        }

        Boolean LoopCheck = MMGlobals.Accessor.getIsLooped(pl);
        Boolean QueueCheck = MMGlobals.Accessor.getIsQueued(pl);
        maxs_mixtapes.LOGGER.debug(String.valueOf(LoopCheck) + " loop");
        maxs_mixtapes.LOGGER.debug(String.valueOf(QueueCheck) + " queue");
        maxs_mixtapes.LOGGER.debug(String.valueOf(SuccessfulPlay) + " success");
        maxs_mixtapes.LOGGER.debug(String.valueOf((SuccessfulPlay && (LoopCheck || QueueCheck))) + " if check");
        if (SuccessfulPlay && (LoopCheck || QueueCheck)) {
            maxs_mixtapes.LOGGER.debug("successful play");
            int length = ((RecordItem) Cassette).getLengthInTicks();
            maxs_mixtapes.queueServerWork(length, () -> {
                maxs_mixtapes.LOGGER.debug("waited time");
                if (!QueueCheck && LoopCheck) { // Loop 1
                    maxs_mixtapes.LOGGER.debug("started l1");
                    if (en instanceof Player _plr ? _plr.containerMenu instanceof MMBlockmanMenu : false) {
                        try {
                            ButtonPressed(en, pl, true);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        maxs_mixtapes.LOGGER.debug("tried press again");
                    } else {
                        soundPlayer.playSound(pl, song);
                        maxs_mixtapes.LOGGER.debug("tried play direct again");
                    }

                } else if (QueueCheck && LoopCheck) { // Loop all
                    maxs_mixtapes.LOGGER.debug("tried loop all fsr?");
                } else { // Queue only
                    //To be implemented
                    maxs_mixtapes.LOGGER.debug("you're a dumbass");
                }
            });
        }

    }

    @NotNull
    private static String getString(int randnum) {
        String ErrorMessage = "";

        switch (randnum) {
            case 0:
                ErrorMessage = "<Blockman Speaker> Yo tf you think you're doing";
                break;
            case 1:
                ErrorMessage = "<Blockman Speaker> That item isn't compatible dud.";
                break;
            case 2:
                ErrorMessage = "<Blockman Speaker> Thats not a compatible music format.";
                break;
            case 3:
                ErrorMessage = "<Blockman Speaker> Please enter a real cassette or disc, not this garbage.";
                break;
            case 4:
                ErrorMessage = "<Blockman Speaker> I really hope this is to test my limits and not because you think it actually has sounds.";
                break;
            case 5:
                ErrorMessage = "<Blockman Speaker> Chill out, thats not a cassette or disc.";
                break;
            case 6:
                ErrorMessage = "<Blockman Speaker> Do that again and I'll explode. Just kidding, I can't.";
                break;
            case 7:
                ErrorMessage = "<Blockman Speaker> teehee oopsie woopsie that no workie :3c";
                break;
            case 8:
                ErrorMessage = "<Blockman Speaker> I swear to god if you put a piece of bread in here again I'll personally break your pigstep disc.";
                break;
            case 9:
                ErrorMessage = "<Blockman Speaker> Wow this is a secret, good job.";
                break;

        }
        return ErrorMessage;
    }

}
