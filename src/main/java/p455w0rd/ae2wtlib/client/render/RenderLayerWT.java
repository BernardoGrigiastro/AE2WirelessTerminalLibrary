package p455w0rd.ae2wtlib.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import p455w0rd.ae2wtlib.api.IBaubleRender;
import p455w0rd.ae2wtlib.init.LibIntegration.Mods;

/**
 * Credit to EnderIO
 *
 */
@SideOnly(Side.CLIENT)
public class RenderLayerWT implements IBaubleRender {

	private static final RenderLayerWT INSTANCE = new RenderLayerWT();

	private RenderLayerWT() {
	}

	// see LayerCustomHead

	@Override
	public void doRenderLayer(RenderPlayer renderPlayer, ItemStack piece, AbstractClientPlayer entitylivingbaseIn, float p_177141_2_, float p_177141_3_, float partialTicks, float p_177141_5_, float p_177141_6_, float p_177141_7_, float scale) {
		if (!Mods.BAUBLES.isLoaded()) {
			return;
		}
		GlStateManager.pushMatrix();

		if (entitylivingbaseIn.isSneaking()) {
			GlStateManager.translate(0.0F, 0.2F, 0.0F);
		}

		renderPlayer.getMainModel().bipedHead.postRender(0.0625F);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

		GlStateManager.rotate(90.0F, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
		GlStateManager.translate(0.0F, 7.0F * 0.0625F, 4.0F * 0.0625F);
		GlStateManager.scale(0.5F, 0.5F, 0.75F);

		float pbx = OpenGlHelper.lastBrightnessX;
		float pby = OpenGlHelper.lastBrightnessY;
		if (piece.getItem().hasEffect(piece)) {
			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240F, 240F);
		}
		Minecraft.getMinecraft().getItemRenderer().renderItem(entitylivingbaseIn, piece, TransformType.NONE);
		if (piece.getItem().hasEffect(piece)) {
			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, pbx, pby);
		}
		GlStateManager.popMatrix();
	}

	public static RenderLayerWT getInstance() {
		return INSTANCE;
	}

}