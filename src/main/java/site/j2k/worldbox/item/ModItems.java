package site.j2k.worldbox.item;

import site.j2k.worldbox.WorldBoxMod;
import site.j2k.worldbox.entity.ModEntityTypes;
import site.j2k.worldbox.item.custom.ModSpawnEggItem;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, WorldBoxMod.MOD_ID);

    public static final RegistryObject<ModSpawnEggItem> CIVILIAN_SPAWN_EGG = ITEMS.register("civilian_spawn_egg",
            () -> new ModSpawnEggItem(ModEntityTypes.CIVILIAN, 0xFFC8A8, 0xFF4F00,
                    new Item.Properties().group(ModItemGroup.MAIN_GROUP)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
