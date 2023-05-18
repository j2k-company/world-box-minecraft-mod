package site.j2k.worldbox.ai;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import site.j2k.worldbox.buildings.Building;
import site.j2k.worldbox.entity.custom.CivilianEntity;
import site.j2k.worldbox.util.Log;

import java.util.*;

public class ColonyManager {
    public static final int MINIMAL_COLONY_RADIUS = 10;
    private final List<CivilianEntity> colonists;
    private final HashMap<String, Building> buildings;
    private final Resources resources;

    // TODO: Made distribution villagers
    public ColonyManager(List<CivilianEntity> colonists, HashMap<String, Building> buildings) {
        this.colonists = colonists;
        this.buildings = buildings;
        this.resources = new Resources(null, new ArrayList<ItemStack>());
        for(CivilianEntity colonist : this.colonists) {
            colonist.setFreedom();
            IItemHandler itemHandler = colonist.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).orElse(null);
            itemHandler.insertItem(0, new ItemStack(Items.APPLE), false);
        }
        checkResources();
        Log.getLogger().info("Resources: " + this.resources.getFood());
        Log.getLogger().info("New colony" + this.colonists);
    }

    private void checkResources() {
        for(CivilianEntity colonist : this.colonists) {
            IItemHandler itemHandler = colonist.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).orElse(null);
            List<ItemStack> itemStacks = new ArrayList<>();
            for (int slot = 0; slot < itemHandler.getSlots(); slot++) {
                ItemStack itemStack = itemHandler.getStackInSlot(slot);
                if (!itemStack.isEmpty()) {
                    itemStacks.add(itemStack);
                    Log.getLogger().info(itemStack);
                }
            }
            this.resources.addResources(itemStacks);
        }
    }


    public void update() {

    }
    public List<CivilianEntity> getColonists() {
        return new ArrayList<>(this.colonists);
    }

    public HashMap<String, Building> getBuildings() {
        return new HashMap<>(this.buildings);
    }

    public Resources getResources() {
        return resources;
    }
}
