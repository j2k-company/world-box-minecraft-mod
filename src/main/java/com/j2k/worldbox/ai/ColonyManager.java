package com.j2k.worldbox.ai;

import com.j2k.worldbox.buildings.Building;
import com.j2k.worldbox.entity.custom.CivilianEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ColonyManager {
    public static final int MINIMAL_COLONY_RADIUS = 10;
    private final HashMap<String, ArrayList<CivilianEntity>> colonists;
    private final HashMap<String, Building> buildings;

    // TODO: Change parameters to List and made distribution villagers
    public ColonyManager(HashMap<String, ArrayList<CivilianEntity>> colonists, HashMap<String, Building> buildings) {
        this.colonists = colonists;
        this.buildings = buildings;
    }

    public HashMap<String, List<CivilianEntity>> getColonists() {
        return new HashMap<>(this.colonists);
    }

    public HashMap<String, Building> getBuildings() {
        return new HashMap<>(this.buildings);
    }
}
