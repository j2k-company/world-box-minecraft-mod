package site.j2k.worldbox.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup MAIN_GROUP = new ItemGroup("worldBoxTab") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.CIVILIAN_SPAWN_EGG.get());
        }
    };
}
