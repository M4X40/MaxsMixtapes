package com.m4x4.mixtapes.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

import com.m4x4.mixtapes.maxs_mixtapes;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MMGlobals {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		maxs_mixtapes.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.isLooped = original.isLooped;
			clone.isQueued = original.isQueued;
			clone.stopCounter = original.stopCounter;
			clone.swapOnOpen = original.swapOnOpen;
			clone.swapAmount = original.swapAmount;
			if (!event.isWasDeath()) {
			}
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("maxs_mixtapes", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public boolean isLooped = false;
		public boolean isQueued = false;
		public int stopCounter = 0;
		public boolean swapOnOpen = false;
		public int swapAmount = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				maxs_mixtapes.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putBoolean("isLooped", isLooped);
			nbt.putBoolean("isQueued", isQueued);
			nbt.putInt("stopCounter", stopCounter);
			nbt.putBoolean("swapOnOpen", swapOnOpen);
			nbt.putInt("swapAmount", swapAmount);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			isLooped = nbt.getBoolean("isLooped");
			isQueued = nbt.getBoolean("isQueued");
			stopCounter = nbt.getInt("stopCounter");
			swapOnOpen = nbt.getBoolean("swapOnOpen");
			swapAmount = nbt.getInt("swapAmount");
		}
	}

	public static class PlayerVariablesSyncMessage {
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.isLooped = message.data.isLooped;
					variables.isQueued = message.data.isQueued;
					variables.stopCounter = message.data.stopCounter;
					variables.swapOnOpen = message.data.swapOnOpen;
					variables.swapAmount = message.data.swapAmount;
				}
			});
			context.setPacketHandled(true);
		}
	}

	public static class Accessor {
		public static Boolean getIsLooped(Entity entity) {
			return (entity.getCapability(MMGlobals.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MMGlobals.PlayerVariables())).isLooped;
		}
		public static void setIsLooped(Entity entity, Boolean value) {
			entity.getCapability(MMGlobals.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.isLooped = value;
				capability.syncPlayerVariables(entity);
			});
		}

		public static Boolean getIsQueued(Entity entity) {
			return (entity.getCapability(MMGlobals.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MMGlobals.PlayerVariables())).isQueued;
		}
		public static void setIsQueued(Entity entity, Boolean value) {
			entity.getCapability(MMGlobals.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.isQueued = value;
				capability.syncPlayerVariables(entity);
			});
		}

		public static int getstopCounter(Entity entity) {
			return (entity.getCapability(MMGlobals.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).stopCounter;
		}
		public static void setstopCounter(Entity entity, int value) {
			entity.getCapability(MMGlobals.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.stopCounter = value;
				capability.syncPlayerVariables(entity);
			});
		}

		public static Boolean getswapOnOpen(Entity entity) {
			return (entity.getCapability(MMGlobals.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).swapOnOpen;
		}
		public static void setswapOnOpen(Entity entity, Boolean value) {
			entity.getCapability(MMGlobals.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.swapOnOpen = value;
				capability.syncPlayerVariables(entity);
			});
		}

		public static int getswapAmount(Entity entity) {
			return (entity.getCapability(MMGlobals.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).swapAmount;
		}
		public static void setswapAmount(Entity entity, int value) {
			entity.getCapability(MMGlobals.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.swapAmount = value;
				capability.syncPlayerVariables(entity);
			});
		}
	}

}
