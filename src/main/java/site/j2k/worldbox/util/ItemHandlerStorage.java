package site.j2k.worldbox.util;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

public class ItemHandlerStorage implements Capability.IStorage<IItemHandler> {
    @Nullable
    @Override
    public INBT writeNBT(Capability<IItemHandler> capability, IItemHandler instance, Direction side) {
        if (instance instanceof ItemStackHandler) {
            return ((ItemStackHandler) instance).serializeNBT();
        }
        return null;
    }

    @Override
    public void readNBT(Capability<IItemHandler> capability, IItemHandler instance, Direction side, INBT nbt) {
        if (instance instanceof ItemStackHandler && nbt instanceof CompoundNBT) {
            ((ItemStackHandler) instance).deserializeNBT((CompoundNBT) nbt);
        }
    }
}