package site.j2k.worldbox.ai;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public class Resources {
    private List<Item> buildMaterials;
    private List<ItemStack> food;

    //TODO: Make resource allocation by category
    public Resources(List<Item> buildMaterials, List<ItemStack> food) {
        this.buildMaterials = buildMaterials;
        this.food = food;
    }

    public void addResources(List<ItemStack> itemStacks) {
        this.food.addAll(itemStacks);
    }

    public List<Item> getBuildMaterials() {
        return buildMaterials;
    }

    public void setBuildMaterials(List<Item> buildMaterials) {
        this.buildMaterials = buildMaterials;
    }

    public List<ItemStack> getFood() {
        return food;
    }

    public void setFood(List<ItemStack> food) {
        this.food = food;
    }
}
