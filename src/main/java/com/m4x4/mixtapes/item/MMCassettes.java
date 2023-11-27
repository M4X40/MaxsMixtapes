package com.m4x4.mixtapes.item;

import com.m4x4.mixtapes.maxs_mixtapes;
import com.m4x4.mixtapes.sound.MMSongs;
import com.m4x4.mixtapes.tabs.MMDiscTab;
import com.m4x4.mixtapes.tabs.MMItemTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MMCassettes {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, maxs_mixtapes.MODID);

    public static final RegistryObject<Item> Blockman = ITEMS.register("blockman", () -> new MMBlockmanUsage(new Item.Properties().tab(MMItemTab.instance)));

    public static final RegistryObject<Item> TestCassette = ITEMS.register("testcassette", () -> new RecordItem(8, MMSongs.TEST_SOUND, new Item.Properties().tab(MMDiscTab.instance), 3060));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
