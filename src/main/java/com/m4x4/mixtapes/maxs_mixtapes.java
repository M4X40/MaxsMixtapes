package com.m4x4.mixtapes;

import com.m4x4.mixtapes.item.MMItems;
import com.m4x4.mixtapes.sound.MMSongs;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(maxs_mixtapes.MODID)
public class maxs_mixtapes {
    public static final String MODID = "maxs_mixtapes";
    private static final Logger LOGGER = LogUtils.getLogger();

    public maxs_mixtapes()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MMSongs.register(modEventBus);
        MMItems.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("Max's Mixtapes Loaded! User >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
