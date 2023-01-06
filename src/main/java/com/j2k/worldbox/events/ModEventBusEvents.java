package com.j2k.worldbox.events;

import net.minecraft.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.j2k.worldbox.WorldBoxMod;
import com.j2k.worldbox.entity.ModEntityTypes;
import com.j2k.worldbox.entity.custom.CivilianEntity;
import com.j2k.worldbox.item.custom.ModSpawnEggItem;

@Mod.EventBusSubscriber(modid = WorldBoxMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.CIVILIAN.get(), CivilianEntity.setCustomAttributes().create());
    }

    @SubscribeEvent
    public static void onRegisterEntities(RegistryEvent.Register<EntityType<?>> event) {
        ModSpawnEggItem.initSpawnEggs();
    }
}
