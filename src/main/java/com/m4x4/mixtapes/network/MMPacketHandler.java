package com.m4x4.mixtapes.network;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

import com.m4x4.mixtapes.maxs_mixtapes;

public class MMPacketHandler {
        private static final String PROTOCOL_VERSION = "1";
        public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
                new ResourceLocation(maxs_mixtapes.MODID, "main"),
                () -> PROTOCOL_VERSION,
                PROTOCOL_VERSION::equals,
                PROTOCOL_VERSION::equals
        );

        public static void register() {
                int id = 0;
                INSTANCE.registerMessage(id++, MMPacket.class, MMPacket::encode, MMPacket::decode, MMPacket::handle);
        }

}
