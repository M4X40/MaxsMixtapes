package com.m4x4.mixtapes.init;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import com.m4x4.mixtapes.world.inventory.MMBlockmanMenu;
import com.m4x4.mixtapes.maxs_mixtapes;

public class MMMenus {

	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, maxs_mixtapes.MODID);
	public static RegistryObject<MenuType<MMBlockmanMenu>> MM_blockman_MENU = REGISTRY.register("mm_blockman_menu", () -> IForgeMenuType.create(MMBlockmanMenu::new));
}
