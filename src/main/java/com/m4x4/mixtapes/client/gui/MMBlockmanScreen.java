package com.m4x4.mixtapes.client.gui;

import com.m4x4.mixtapes.maxs_mixtapes;
import com.m4x4.mixtapes.network.MMBlockmanMessage;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

import com.m4x4.mixtapes.world.inventory.MMBlockmanMenu;
import org.jetbrains.annotations.NotNull;

public class MMBlockmanScreen extends AbstractContainerScreen<MMBlockmanMenu> {
	private final static HashMap<String, Object> guistate = MMBlockmanMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_new_play_button;
	ImageButton imagebutton_new_stop;
	ImageButton imagebutton_loop_neutral;
	ImageButton imagebutton_queue_neutral;

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

	private static final ResourceLocation texture = new ResourceLocation("maxs_mixtapes:textures/screens/mm_blockman_menu.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("maxs_mixtapes:textures/screens/temp_walkman_2_gui.png"));
		blit(ms, this.leftPos + -2, this.topPos + 18, 0, 0, 64, 64, 64, 64);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
            assert this.minecraft != null;
            assert this.minecraft.player != null;
            this.minecraft.player.closeContainer();
			return true;
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
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
        assert this.minecraft != null;
        this.minecraft.keyboardHandler.setSendRepeatsToGui(true);

		imagebutton_new_play_button = new ImageButton(this.leftPos + 115, this.topPos + 27, 16, 16, 0, 0, 16, new ResourceLocation("maxs_mixtapes:textures/screens/atlas/imagebutton_new_play_button.png"), 16, 32, e -> {
			maxs_mixtapes.PACKET_HANDLER.sendToServer(new MMBlockmanMessage(0, x, y, z));
            try {
                MMBlockmanMessage.handleButtonAction(entity, 0, x, y, z);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });
		guistate.put("button:imagebutton_new_play_button", imagebutton_new_play_button);
		this.addRenderableWidget(imagebutton_new_play_button);

		imagebutton_new_stop = new ImageButton(this.leftPos + 133, this.topPos + 27, 16, 16, 0, 0, 16, new ResourceLocation("maxs_mixtapes:textures/screens/atlas/imagebutton_new_stop.png"), 16, 32, e -> {
            maxs_mixtapes.PACKET_HANDLER.sendToServer(new MMBlockmanMessage(1, x, y, z));
            try {
                MMBlockmanMessage.handleButtonAction(entity, 1, x, y, z);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });
		guistate.put("button:imagebutton_new_stop", imagebutton_new_stop);
		this.addRenderableWidget(imagebutton_new_stop);

		imagebutton_loop_neutral = new ImageButton(this.leftPos + 115, this.topPos + 45, 16, 16, 0, 0, 16, new ResourceLocation("maxs_mixtapes:textures/screens/atlas/imagebutton_loop_neutral.png"), 16, 32, e -> {
            maxs_mixtapes.PACKET_HANDLER.sendToServer(new MMBlockmanMessage(2, x, y, z));
            try {
                MMBlockmanMessage.handleButtonAction(entity, 2, x, y, z);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });
		guistate.put("button:imagebutton_loop_neutral", imagebutton_loop_neutral);
		this.addRenderableWidget(imagebutton_loop_neutral);
		
		imagebutton_queue_neutral = new ImageButton(this.leftPos + 133, this.topPos + 45, 16, 16, 0, 0, 16, new ResourceLocation("maxs_mixtapes:textures/screens/atlas/imagebutton_queue_neutral.png"), 16, 32, e -> {
            maxs_mixtapes.PACKET_HANDLER.sendToServer(new MMBlockmanMessage(3, x, y, z));
            try {
                MMBlockmanMessage.handleButtonAction(entity, 3, x, y, z);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });
		guistate.put("button:imagebutton_queue_neutral", imagebutton_queue_neutral);
		this.addRenderableWidget(imagebutton_queue_neutral);
	}
}
