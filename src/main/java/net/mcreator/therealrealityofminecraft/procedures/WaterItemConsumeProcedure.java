package net.mcreator.therealrealityofminecraft.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import net.mcreator.therealrealityofminecraft.item.CleanWaterItem;
import net.mcreator.therealrealityofminecraft.TheRealRealityOfMinecraftModElements;
import net.mcreator.therealrealityofminecraft.TheRealRealityOfMinecraftMod;

import java.util.Map;
import java.util.HashMap;

@TheRealRealityOfMinecraftModElements.ModElement.Tag
public class WaterItemConsumeProcedure extends TheRealRealityOfMinecraftModElements.ModElement {
	public WaterItemConsumeProcedure(TheRealRealityOfMinecraftModElements instance) {
		super(instance, 75);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheRealRealityOfMinecraftMod.LOGGER.warn("Failed to load dependency entity for procedure WaterItemConsume!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				TheRealRealityOfMinecraftMod.LOGGER.warn("Failed to load dependency itemstack for procedure WaterItemConsume!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (((itemstack).getItem() == new ItemStack(CleanWaterItem.block, (int) (1)).getItem())) {
			entity.getPersistentData().putDouble("waterLevel", ((entity.getPersistentData().getDouble("waterLevel")) + 10));
			if (((entity.getPersistentData().getDouble("waterLevel")) > 100)) {
				entity.getPersistentData().putDouble("waterLevel", 100);
			}
		}
	}

	@SubscribeEvent
	public void onUseItemStart(LivingEntityUseItemEvent.Finish event) {
		if (event != null && event.getEntity() != null) {
			Entity entity = event.getEntity();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			double duration = event.getDuration();
			ItemStack itemstack = event.getItem();
			World world = entity.world;
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("itemstack", itemstack);
			dependencies.put("duration", duration);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
