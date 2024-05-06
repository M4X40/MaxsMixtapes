package com.m4x4.mixtapes.client.gui;

import com.m4x4.mixtapes.functions.blockman.MMBlockmanPlay;
import com.m4x4.mixtapes.functions.blockman.MMBlockmanStop;
import com.m4x4.mixtapes.functions.handlers.MMBlockmanStoreSlots;
import com.m4x4.mixtapes.network.MMGlobals;
import com.m4x4.mixtapes.world.inventory.MMBlockmanMenu;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class MMBlockmanScreen extends AbstractContainerScreen<MMBlockmanMenu> {
	private final static HashMap<String, Object> guistate = MMBlockmanMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_new_play_button;
	ImageButton imagebutton_new_stop;
	ImageButton imagebutton_loop_off;
	//ImageButton imagebutton_queue_off;
	ImageButton imagebutton_loop_on;
	//ImageButton imagebutton_queue_on;

	public MMBlockmanScreen(MMBlockmanMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 234;
	}

	private static final ResourceLocation texture = new ResourceLocation("maxs_mixtapes:textures/screens/mm_blockman_menu_light.png");

	@Override
	public void render(@NotNull PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(@NotNull PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.setShaderTexture(0, new ResourceLocation("maxs_mixtapes:textures/screens/blockman.png"));
		blit(ms, this.leftPos + 3, this.topPos + 20, 0, 0, 64, 64, 64, 64);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
            assert this.minecraft != null;
            assert this.minecraft.player != null;
			MMBlockmanStoreSlots.retrieveSlots(this.minecraft.player);
            this.minecraft.player.closeContainer();
			return true;
		} else if (key == 80) {
            try {
                MMBlockmanPlay.ButtonPressed(this.entity, this.entity, true, 0);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else if (key == 83) {
			MMBlockmanStop.ButtonPressed(this.entity);
		} else if (key == 76) {
			if (MMGlobals.Accessor.getIsLooped(entity)) {
				MMGlobals.Accessor.setIsLooped(entity, false);
				imagebutton_loop_off.setPosition(this.leftPos + 1124, imagebutton_loop_off.y);
				imagebutton_loop_on.setPosition(this.leftPos + 124, imagebutton_loop_on.y);
			} else {
				MMGlobals.Accessor.setIsLooped(entity, true);
				imagebutton_loop_off.setPosition(this.leftPos + 124, imagebutton_loop_off.y);
				imagebutton_loop_on.setPosition(this.leftPos + 1124, imagebutton_loop_on.y);
			}
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(@NotNull PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, Component.translatable("gui.mm.blockman_label"), 7, 9, -12829636);
	}

	@Override
	public void onClose() {
        assert this.minecraft != null;
        MMBlockmanStoreSlots.retrieveSlots(this.minecraft.player);
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
        assert this.minecraft != null;
        this.minecraft.keyboardHandler.setSendRepeatsToGui(true);

		imagebutton_new_play_button = new ImageButton(this.leftPos + 115, this.topPos + 27, 16, 16, 0, 0, 16, new ResourceLocation("maxs_mixtapes:textures/screens/atlas/imagebutton_new_play_button.png"), 16, 32, e -> {
            try {
                MMBlockmanPlay.ButtonPressed(entity, entity, true, 0);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });
		guistate.put("button:imagebutton_new_play_button", imagebutton_new_play_button);
		this.addRenderableWidget(imagebutton_new_play_button);

		imagebutton_new_stop = new ImageButton(this.leftPos + 133, this.topPos + 27, 16, 16, 0, 0, 16, new ResourceLocation("maxs_mixtapes:textures/screens/atlas/imagebutton_new_stop.png"), 16, 32, e -> {
			MMBlockmanStop.ButtonPressed(entity);
        });
		guistate.put("button:imagebutton_new_stop", imagebutton_new_stop);
		this.addRenderableWidget(imagebutton_new_stop);
		// loop pos w/queue is 115/1115
		imagebutton_loop_off = new ImageButton(this.leftPos + 124, this.topPos + 45, 16, 16, 0, 0, 16, new ResourceLocation("maxs_mixtapes:textures/screens/atlas/imagebutton_loop_inactive.png"), 16, 32, e -> {
			MMGlobals.Accessor.setIsLooped(entity, true);
			imagebutton_loop_off.setPosition(this.leftPos + 1124, imagebutton_loop_off.y);
			imagebutton_loop_on.setPosition(this.leftPos + 124, imagebutton_loop_on.y);
        });
		guistate.put("button:imagebutton_loop_off", imagebutton_loop_off);
		this.addRenderableWidget(imagebutton_loop_off);
		
//		imagebutton_queue_off = new ImageButton(this.leftPos + 133, this.topPos + 45, 16, 16, 0, 0, 16, new ResourceLocation("maxs_mixtapes:textures/screens/atlas/imagebutton_queue_inactive.png"), 16, 32, e -> {
//          MMBlockmanQueue.ButtonPressed(entity, entity);
//			imagebutton_queue_off.setPosition(this.leftPos + 1133, imagebutton_queue_off.y);
//			imagebutton_queue_on.setPosition(this.leftPos + 133, imagebutton_queue_on.y);
//        });
//		guistate.put("button:imagebutton_queue_off", imagebutton_queue_off);
//		this.addRenderableWidget(imagebutton_queue_off);

		imagebutton_loop_on = new ImageButton(this.leftPos + 1124, this.topPos + 45, 16, 16, 0, 0, 16, new ResourceLocation("maxs_mixtapes:textures/screens/atlas/imagebutton_loop_active.png"), 16, 32, e -> {
			MMGlobals.Accessor.setIsLooped(entity, false);
			imagebutton_loop_off.setPosition(this.leftPos + 124, imagebutton_loop_off.y);
			imagebutton_loop_on.setPosition(this.leftPos + 1124, imagebutton_loop_on.y);
		});
		guistate.put("button:imagebutton_loop_on", imagebutton_loop_on);
		this.addRenderableWidget(imagebutton_loop_on);

//		imagebutton_queue_on = new ImageButton(this.leftPos + 1133, this.topPos + 45, 16, 16, 0, 0, 16, new ResourceLocation("maxs_mixtapes:textures/screens/atlas/imagebutton_queue_active.png"), 16, 32, e -> {
//			MMBlockmanQueue.ButtonPressed(entity, entity);
//			imagebutton_queue_off.setPosition(this.leftPos + 133, imagebutton_queue_off.y);
//			imagebutton_queue_on.setPosition(this.leftPos + 1133, imagebutton_queue_on.y);
//		});
//		guistate.put("button:imagebutton_queue_on", imagebutton_queue_on);
//		this.addRenderableWidget(imagebutton_queue_on);

		if (MMGlobals.Accessor.getIsLooped(entity)) {
			imagebutton_loop_off.setPosition(this.leftPos + 1124, imagebutton_loop_off.y);
			imagebutton_loop_on.setPosition(this.leftPos + 124, imagebutton_loop_on.y);
		} else {
			imagebutton_loop_off.setPosition(this.leftPos + 124, imagebutton_loop_off.y);
			imagebutton_loop_on.setPosition(this.leftPos + 1124, imagebutton_loop_on.y);
		}

//		if (MMGlobals.Accessor.getIsQueued(entity)) {
//			imagebutton_queue_off.setPosition(this.leftPos + 1133, imagebutton_queue_off.y);
//			imagebutton_queue_on.setPosition(this.leftPos + 133, imagebutton_queue_on.y);
//		} else {
//			imagebutton_queue_off.setPosition(this.leftPos + 133, imagebutton_queue_off.y);
//			imagebutton_queue_on.setPosition(this.leftPos + 1133, imagebutton_queue_on.y);
//		}
	}



}
