package site.j2k.worldbox.entity.custom;

import net.minecraft.inventory.IInventory;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import site.j2k.worldbox.ai.ColonyManager;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CivilianEntity extends MobEntity{

    private IItemHandler inventory;
    private final double rating;
    private boolean freedom;
    private static int ticks = 0;

    public CivilianEntity(EntityType<? extends MobEntity> type, World worldIn) {
            super(type, worldIn);
            this.rating = ThreadLocalRandom.current().nextDouble();
            this.freedom = true;
            this.inventory = new ItemStackHandler(9);
    }

    @Override
    @Nonnull
    @ParametersAreNonnullByDefault
    public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction side) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return LazyOptional.of(() -> (T) this.inventory);
        }
        return super.getCapability(capability, side);
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
