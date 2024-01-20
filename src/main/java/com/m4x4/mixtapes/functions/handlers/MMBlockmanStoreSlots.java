package com.m4x4.mixtapes.functions.handlers;

import com.m4x4.mixtapes.maxs_mixtapes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

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
}






















