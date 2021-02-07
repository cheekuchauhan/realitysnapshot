package net.mcreator.therealrealityofminecraft.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.entity.Entity;

import net.mcreator.therealrealityofminecraft.TheRealRealityOfMinecraftModElements;
import net.mcreator.therealrealityofminecraft.TheRealRealityOfMinecraftMod;

import java.util.Map;
import java.util.HashMap;

@TheRealRealityOfMinecraftModElements.ModElement.Tag
public class WaterMiningProcedure extends TheRealRealityOfMinecraftModElements.ModElement {
	public WaterMiningProcedure(TheRealRealityOfMinecraftModElements instance) {
		super(instance, 73);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheRealRealityOfMinecraftMod.LOGGER.warn("Failed to load dependency entity for procedure WaterMining!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putDouble("waterLevel", ((entity.getPersistentData().getDouble("waterLevel")) - 0.1));
	}

	@SubscribeEvent
	public void onBlockBreak(BlockEvent.BreakEvent event) {
		Entity entity = event.getPlayer();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("xpAmount", event.getExpToDrop());
		dependencies.put("x", event.getPos().getX());
		dependencies.put("y", event.getPos().getY());
		dependencies.put("z", event.getPos().getZ());
		dependencies.put("px", entity.getPosX());
		dependencies.put("py", entity.getPosY());
		dependencies.put("pz", entity.getPosZ());
		dependencies.put("world", event.getWorld().getWorld());
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
