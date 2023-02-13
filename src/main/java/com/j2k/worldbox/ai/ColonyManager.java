package com.j2k.worldbox.ai;

import com.j2k.worldbox.buildings.Building;
import com.j2k.worldbox.entity.custom.CivilianEntity;

import java.util.HashMap;

public class ColonyManager {

    private final HashMap<String, CivilianEntity> colonists;
    private final HashMap<String, Building> buildings;

    public ColonyManager(HashMap<String, CivilianEntity> colonists, HashMap<String, Building> buildings) {
        this.colonists = colonists;
        this.buildings = buildings;
    }

    public HashMap<String, CivilianEntity> getColonists() {
        return new HashMap<>(this.colonists);
    }

    public HashMap<String, Building> getBuildings() {
        return new HashMap<>(this.buildings);
    }
}
