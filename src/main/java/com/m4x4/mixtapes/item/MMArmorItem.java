package com.m4x4.mixtapes.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MMArmorItem extends ArmorItem {
    String Description;

    public MMArmorItem(ArmorMaterial p_40386_, EquipmentSlot p_40387_, Properties p_40388_, String Desc) {
        super(p_40386_, p_40387_, p_40388_);
        Description = Desc;
    }


    public void appendHoverText(@NotNull ItemStack itemstack, Level world, @NotNull List<Component> list, @NotNull TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        list.add(Component.literal(Description));
    }
}
