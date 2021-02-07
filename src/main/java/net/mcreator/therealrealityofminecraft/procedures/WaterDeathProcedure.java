package net.mcreator.therealrealityofminecraft.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.therealrealityofminecraft.TheRealRealityOfMinecraftModElements;
import net.mcreator.therealrealityofminecraft.TheRealRealityOfMinecraftMod;

import java.util.Map;
import java.util.HashMap;

@TheRealRealityOfMinecraftModElements.ModElement.Tag
public class WaterDeathProcedure extends TheRealRealityOfMinecraftModElements.ModElement {
	public WaterDeathProcedure(TheRealRealityOfMinecraftModElements instance) {
		super(instance, 76);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheRealRealityOfMinecraftMod.LOGGER.warn("Failed to load dependency entity for procedure WaterDeath!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		while (((entity.getPersistentData().getDouble("waterLevel")) <= 0)) {
			if (((entity.getPersistentData().getDouble("waterLevel")) < 0)) {
				entity.getPersistentData().putDouble("waterLevel", 0);
			}
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 20, (int) 2));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WEAKNESS, (int) 20, (int) 2));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, (int) 20, (int) 2));
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
