package com.m4x4.mixtapes.sound;

import com.m4x4.mixtapes.maxs_mixtapes;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MMSongs {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, maxs_mixtapes.MODID);

    public static final RegistryObject<SoundEvent> TEST_SOUND = registerSoundEvent("test_sound");

    // public static final ForgeSoundType MaxsMixtapesSongs = new ForgeSoundType(1f, 1f, MMSongs.TEST_SOUND, MMSongs.TEST_SOUND, MMSongs.TEST_SOUND, MMSongs.TEST_SOUND, MMSongs.TEST_SOUND);
    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = new ResourceLocation(maxs_mixtapes.MODID, name);
        return SOUND_EVENTS.register(name, () -> new SoundEvent(id));
    }
    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register((eventBus));
    }
}
