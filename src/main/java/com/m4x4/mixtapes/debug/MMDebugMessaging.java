package com.m4x4.mixtapes.debug;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class MMDebugMessaging {
    public static void DebugPrint(Entity en, String msg) {
//        if (en instanceof Player _player && !_player.level.isClientSide())
//            _player.displayClientMessage(Component.literal(msg), false);
        System.out.println(msg);
    }

    public void DebugPrintNS(Entity en, String msg) {
        if (en instanceof Player _player && !_player.level.isClientSide())
            _player.displayClientMessage(Component.literal(msg), false);
        System.out.println(msg);
    }
}
