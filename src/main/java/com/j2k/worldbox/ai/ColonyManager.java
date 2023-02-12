package com.j2k.worldbox.ai;

import com.j2k.worldbox.entity.custom.CivilianEntity;

import java.util.ArrayList;
import java.util.List;

public class ColonyManager {

    private final ArrayList<CivilianEntity> colonists;

    public ColonyManager(ArrayList<CivilianEntity> colonists) {
        this.colonists = colonists;
    }

    public List<CivilianEntity> getColonists() {
        return new ArrayList<>(this.colonists);
    }
}
