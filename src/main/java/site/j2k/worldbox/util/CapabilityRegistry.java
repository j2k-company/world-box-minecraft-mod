package site.j2k.worldbox.util;

import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.items.IItemHandler;

public class CapabilityRegistry {
    public static void registerCapabilities(IItemHandler inventory) {
        CapabilityManager.INSTANCE.register(IItemHandler.class, new ItemHandlerStorage(), () -> inventory);
    }
}