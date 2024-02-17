package com.m4x4.mixtapes.network;

import com.m4x4.mixtapes.maxs_mixtapes;

public class MMDebugLogging {
    public static void debugS(String msg) {
        if (maxs_mixtapes.DebugMode) {
            maxs_mixtapes.LOGGER.debug(msg);
        }
    }
    public void debugNS(String msg) {
        if (maxs_mixtapes.DebugMode) {
            maxs_mixtapes.LOGGER.debug(msg);
        }
    }
}
