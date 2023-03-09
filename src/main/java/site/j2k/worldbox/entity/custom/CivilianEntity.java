package site.j2k.worldbox.entity.custom;

import site.j2k.worldbox.ai.ColonyManager;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CivilianEntity extends MobEntity {

    private final double rating;
    private boolean freedom;
    private static int ticks = 0;

    public CivilianEntity(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
        this.rating = ThreadLocalRandom.current().nextDouble();
        this.freedom = true;
    }

    // FIXME: Remove hardcoded number
    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 20);
    }

    private List<CivilianEntity> getVillagersAround(int radius) {
        final double x = this.getPosX();
        final double y = this.getPosY();
        final double z = this.getPosZ();
        return this.world
                .getEntitiesWithinAABB(CivilianEntity.class,
                        new AxisAlignedBB(x - radius, y - radius, z - radius,
                                x + radius, y + radius, z + radius));

    }

    private List<CivilianEntity> getFreedomVillagersAround(int radius) {
        List<CivilianEntity> villagers = getVillagersAround(radius);
        villagers.removeIf(s -> !s.isFreedom());
        return villagers;
    }

    @Override
    public void tick() {
        super.tick();
        ticks++;
        if (ticks > 99) {
            if (this.getRating() > 0.1 && this.isFreedom()) {
                List<CivilianEntity> freedomVillagersAround =
                        getFreedomVillagersAround(ColonyManager.MINIMAL_COLONY_RADIUS);
                new ColonyManager(freedomVillagersAround, null);
            }
            ticks = 0;
        }
    }

    public double getRating() {
        return rating;
    }

    public boolean isFreedom() {
        return freedom;
    }

    public void setFreedom() {
        this.freedom = !this.freedom;
    }
}
