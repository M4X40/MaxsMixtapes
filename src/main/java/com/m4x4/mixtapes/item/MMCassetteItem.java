package com.m4x4.mixtapes.item;

import com.m4x4.mixtapes.sound.MMSongs;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MMCassetteItem extends RecordItem {

    String Description;
    SoundEvent Song;
    public MMCassetteItem(int RedstoneLevel, RegistryObject<SoundEvent> se, Properties Props, int Length, String Desc) {
        super(RedstoneLevel, se, Props, Length);
        Song = se.get();
        Description = Desc;
    }

    public void appendHoverText(@NotNull ItemStack itemstack, Level world, @NotNull List<Component> list, @NotNull TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        list.add(Component.literal(Description));
    }

    public SoundEvent getMMSong() {
        return this.Song;
    }
}
