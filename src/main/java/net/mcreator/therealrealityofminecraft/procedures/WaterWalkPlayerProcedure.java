package net.mcreator.therealrealityofminecraft.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import net.mcreator.therealrealityofminecraft.TheRealRealityOfMinecraftModElements;
import net.mcreator.therealrealityofminecraft.TheRealRealityOfMinecraftMod;

import java.util.Map;
import java.util.HashMap;

@TheRealRealityOfMinecraftModElements.ModElement.Tag
public class WaterWalkPlayerProcedure extends TheRealRealityOfMinecraftModElements.ModElement {
	public WaterWalkPlayerProcedure(TheRealRealityOfMinecraftModElements instance) {
		super(instance, 88);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheRealRealityOfMinecraftMod.LOGGER.warn("Failed to load dependency entity for procedure WaterWalkPlayer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.isBurning())) {
			entity.getPersistentData().putDouble("waterLevel", ((entity.getPersistentData().getDouble("waterLevel")) - 0.01));
		}
		if ((entity.isSneaking())) {
			entity.getPersistentData().putDouble("waterLevel", ((entity.getPersistentData().getDouble("waterLevel")) - 0.03));
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
