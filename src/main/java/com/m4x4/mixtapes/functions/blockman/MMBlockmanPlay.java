package com.m4x4.mixtapes.functions.blockman;

import com.m4x4.mixtapes.item.MMCassetteItem;
import com.m4x4.mixtapes.sound.MMSongs;
import com.m4x4.mixtapes.sound.soundPlayer;
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

public class MMBlockmanPlay {
    public static void ButtonPressed (Entity en, Player pl) {
        ItemStack CassetteStack = en instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY;
        Item Cassette = CassetteStack.getItem();
        if (Cassette.getClass() == MMCassetteItem.class) {
            SoundEvent song = ((MMCassetteItem) Cassette).getMMSong();
            soundPlayer.playSound(pl, song);
        } else if (Cassette.getClass() == RecordItem.class) {
            SoundEvent song = ((RecordItem) Cassette).getSound();
            soundPlayer.playSound(pl, song);
        } else {
            Random rand = new Random();
            int randnum = rand.nextInt(10);

            String ErrorMessage = getString(randnum);

            if (en instanceof Player _player && !_player.level.isClientSide())
                _player.displayClientMessage(Component.literal(ErrorMessage), false);
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
