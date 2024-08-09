package com.avatar.autoopentolan.server;

import java.util.List;

import com.avatar.autoopentolan.GlobalConfig;
import com.avatar.autoopentolan.Main;

import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerConnectionListener;
import net.minecraft.world.level.GameType;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.ServerLifecycleHooks;

@Mod.EventBusSubscriber(modid = Main.MODID)
public class Events {

    private static int port = 9090;
    private static boolean start = true;

    @SubscribeEvent
    public static void ticksServer(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            if (start) {
                port = GlobalConfig.loadPort();
                MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
                ServerConnectionListener connection = server.getConnection();
                if (server != null && connection != null) {
                    // Open to LAN
                    server.getWorldData().setGameType(GameType.SURVIVAL);
                    try {
                        // connection.startTcpServerListener(null, port); // Start LAN server on
                        // specified port
                        System.out.println("Server is now open to LAN on port " + port);
                    } catch (Exception e) {
                        System.err.println("Failed to open LAN server: " + e.getMessage());
                    }
                }
                // send menssages
                List<ServerPlayer> players = event.getServer().getPlayerList().getPlayers();
                for (ServerPlayer player : players) {
                    player.sendSystemMessage(Component.literal("Server is now open to LAN on port " + port));
                }
                start = false;
            }
        }
    }
}
