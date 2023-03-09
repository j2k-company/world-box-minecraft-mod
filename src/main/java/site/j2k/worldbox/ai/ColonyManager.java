package site.j2k.worldbox.ai;

import site.j2k.worldbox.buildings.Building;
import site.j2k.worldbox.entity.custom.CivilianEntity;
import site.j2k.worldbox.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ColonyManager {
    public static final int MINIMAL_COLONY_RADIUS = 10;
    private final List<CivilianEntity> colonists;
    private final HashMap<String, Building> buildings;

    // TODO: Change parameters to List and made distribution villagers
    public ColonyManager(List<CivilianEntity> colonists, HashMap<String, Building> buildings) {
        this.colonists = colonists;
        this.buildings = buildings;
        for(CivilianEntity colonist : this.colonists) {
            colonist.setFreedom();
        }
        Log.getLogger().info("New colony" + this.colonists);
    }

    public List<CivilianEntity> getColonists() {
        return new ArrayList<>(this.colonists);
    }

    public HashMap<String, Building> getBuildings() {
        return new HashMap<>(this.buildings);
    }
}
