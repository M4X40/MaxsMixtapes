package com.m4x4.mixtapes.Base;

import com.m4x4.mixtapes.maxs_mixtapes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public record ArmorMaterials(String name, int durability, int[] prot, int ench, SoundEvent sound, float tough, float kbres, Supplier<Ingredient> repairMat) implements ArmorMaterial {
    private static final int[] durability_per_slot = new int[] {13, 15, 16, 11};
    @Override
    public int getDurabilityForSlot(EquipmentSlot slot) {
        return durability_per_slot[slot.getIndex()] * this.durability;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot slot) {
        return this.prot[slot.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.ench;
    }

    @Override
    public @NotNull SoundEvent getEquipSound() {
        return this.sound;
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
        return this.repairMat.get();
    }

    @Override
    public @NotNull String getName() {
        return maxs_mixtapes.MODID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.tough;
    }

    @Override
    public float getKnockbackResistance() {
        return this.kbres;
    }
}
