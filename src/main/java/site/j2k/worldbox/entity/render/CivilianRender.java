package site.j2k.worldbox.entity.render;

import site.j2k.worldbox.WorldBoxMod;
import site.j2k.worldbox.entity.custom.CivilianEntity;
import site.j2k.worldbox.entity.model.CivilianModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class CivilianRender extends MobRenderer<CivilianEntity, CivilianModel<CivilianEntity>> {
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(WorldBoxMod.MOD_ID, "textures/entity/civilian.png");

    public CivilianRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new CivilianModel<>(1F), 0.7F);
    }
    @Override
    public ResourceLocation getEntityTexture(CivilianEntity entity) {
        return TEXTURE;
    }
}
