package net.mcreator.therealrealityofminecraft.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.therealrealityofminecraft.TheRealRealityOfMinecraftModElements;
import net.mcreator.therealrealityofminecraft.TheRealRealityOfMinecraftMod;

import java.util.Map;

@TheRealRealityOfMinecraftModElements.ModElement.Tag
public class CleanWaterFoodEatenProcedure extends TheRealRealityOfMinecraftModElements.ModElement {
	public CleanWaterFoodEatenProcedure(TheRealRealityOfMinecraftModElements instance) {
		super(instance, 78);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheRealRealityOfMinecraftMod.LOGGER.warn("Failed to load dependency entity for procedure CleanWaterFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putDouble("waterLevel", ((entity.getPersistentData().getDouble("waterLevel")) + 10));
	}
}
