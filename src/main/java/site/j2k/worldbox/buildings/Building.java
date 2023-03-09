package site.j2k.worldbox.buildings;

import site.j2k.worldbox.entity.custom.CivilianEntity;
import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;

public abstract class Building {
    private final BlockPos position;
    private int state;
    private ArrayList<CivilianEntity> builders;
    private ArrayList<CivilianEntity> using;

    protected Building(BlockPos position, ArrayList<CivilianEntity> builders) {
        this.position = position;
        this.builders = builders;
    }

    public ArrayList<CivilianEntity> getBuilders() {
        return new ArrayList<>(this.builders);
    }

    public void addBuilders(CivilianEntity newBuilder) {
        this.builders.add(newBuilder);
    }

    public void removeBuilders() {
        this.builders.clear();
    }
}
