package com.j2k.worldbox.entity;

import com.j2k.worldbox.WorldBoxMod;
import com.j2k.worldbox.entity.custom.CivilianEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES
            = DeferredRegister.create(ForgeRegistries.ENTITIES, WorldBoxMod.MOD_ID);

    public static final RegistryObject<EntityType<CivilianEntity>> CIVILIAN =
            ENTITY_TYPES.register("civilian", () -> EntityType.Builder.create(CivilianEntity::new,
                            EntityClassification.CREATURE).size(0.6F, 2F)
                    .build(new ResourceLocation(WorldBoxMod.MOD_ID, "civilian").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
