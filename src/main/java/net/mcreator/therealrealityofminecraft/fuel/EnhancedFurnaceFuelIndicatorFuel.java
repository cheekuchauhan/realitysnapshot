
package net.mcreator.therealrealityofminecraft.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.therealrealityofminecraft.block.EnhancedFurnaceFuelBlock;
import net.mcreator.therealrealityofminecraft.TheRealRealityOfMinecraftModElements;

@TheRealRealityOfMinecraftModElements.ModElement.Tag
public class EnhancedFurnaceFuelIndicatorFuel extends TheRealRealityOfMinecraftModElements.ModElement {
	public EnhancedFurnaceFuelIndicatorFuel(TheRealRealityOfMinecraftModElements instance) {
		super(instance, 34);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(EnhancedFurnaceFuelBlock.block, (int) (1)).getItem())
			event.setBurnTime(1000);
	}
}
