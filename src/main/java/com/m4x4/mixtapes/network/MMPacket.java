package com.m4x4.mixtapes.network;

import com.m4x4.mixtapes.functions.blockman.MMBlockmanPlay;
import com.m4x4.mixtapes.maxs_mixtapes;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.PacketDistributor;

import java.util.Objects;
import java.util.function.Supplier;

public class MMPacket {
    private final String data;
    private final int data2;

    public MMPacket(String data, int data2) {
        this.data = data;
        this.data2 = data2;
    }

    public static void encode(MMPacket msg, FriendlyByteBuf buf) {
        buf.writeUtf(msg.data);
        buf.writeInt(msg.data2);
    }

    public static MMPacket decode(FriendlyByteBuf buf) {
        return new MMPacket(buf.readUtf(), buf.readInt());
    }

    public static void handle(MMPacket msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> handlePacket(msg, ctx));
        ctx.get().setPacketHandled(true);
    }

    public static void handlePacket(MMPacket msg, Supplier<NetworkEvent.Context> ctx) {
        if (Objects.equals(msg.data, "loop")) {
            MMDebugLogging.debugS("Copper received");
            maxs_mixtapes.queueServerWork(msg.data2, () -> {
                MMPacketHandler.INSTANCE.send(PacketDistributor.PLAYER.with(() -> ctx.get().getSender()), new MMPacket("loopc", 0));
            });
        } else if (Objects.equals(msg.data, "loopc")) {
            MMBlockmanPlay.Loop();
        }
    }
}
