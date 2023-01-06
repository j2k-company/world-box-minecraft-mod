package com.j2k.worldbox.entity.model;

import com.j2k.worldbox.entity.custom.CivilianEntity;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class CivilianModel<T extends CivilianEntity> extends BipedModel<T> {
	// BUG: Breaking texture
	protected CivilianModel(float modelSize, float yOffsetIn, int textureWidthIn, int textureHeightIn) {
		super(modelSize, yOffsetIn, textureWidthIn, textureHeightIn);

		bipedHead = new ModelRenderer(this);
		bipedHead.setRotationPoint(0.0F, 24.0F, 0.0F);
		bipedHead.setTextureOffset(0, 0).addBox(-4.0F, -32.0F, -3.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		bipedBody = new ModelRenderer(this);
		bipedBody.setRotationPoint(0.0F, 24.0F, 0.0F);
		bipedBody.setTextureOffset(16, 16).addBox(-4.0F, -24.0F, -1.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);

		bipedRightArm = new ModelRenderer(this);
		bipedRightArm.setRotationPoint(0.0F, 24.0F, 0.0F);
		bipedRightArm.setTextureOffset(32, 32).addBox(-8.0F, -24.0F, -1.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		bipedLeftArm = new ModelRenderer(this);
		bipedLeftArm.setRotationPoint(0.0F, 24.0F, 0.0F);
		bipedLeftArm.setTextureOffset(16, 32).addBox(4.0F, -24.0F, -1.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		bipedRightLeg = new ModelRenderer(this);
		bipedRightLeg.setRotationPoint(0.0F, 24.0F, 0.0F);
		bipedRightLeg.setTextureOffset(0, 16).addBox(-4.0F, -12.0F, -1.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		bipedLeftLeg = new ModelRenderer(this);
		bipedLeftLeg.setRotationPoint(0.0F, 24.0F, 0.0F);
		bipedLeftLeg.setTextureOffset(0, 32).addBox(0.0F, -12.0F, -1.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
	}

	public CivilianModel(float modelSize) {
		this(modelSize, 0.0F, 48, 48);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		super.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
	}

	/*
	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		leftArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		rightArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		leftLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		rightLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}
	*/

}
