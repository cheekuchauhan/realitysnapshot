package net.mcreator.therealrealityofminecraft.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.therealrealityofminecraft.TheRealRealityOfMinecraftModVariables;
import net.mcreator.therealrealityofminecraft.TheRealRealityOfMinecraftModElements;
import net.mcreator.therealrealityofminecraft.TheRealRealityOfMinecraftMod;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

@TheRealRealityOfMinecraftModElements.ModElement.Tag
public class AlloyfurnacelogiccheckProcedure extends TheRealRealityOfMinecraftModElements.ModElement {
	public AlloyfurnacelogiccheckProcedure(TheRealRealityOfMinecraftModElements instance) {
		super(instance, 89);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheRealRealityOfMinecraftMod.LOGGER.warn("Failed to load dependency entity for procedure Alloyfurnacelogiccheck!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TheRealRealityOfMinecraftMod.LOGGER.warn("Failed to load dependency world for procedure Alloyfurnacelogiccheck!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (((new Object() {
			public int getAmount(int sltid) {
				if (entity instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
							if (stack != null)
								return stack.getCount();
						}
					}
				}
				return 0;
			}
		}.getAmount((int) (0))) > 0)) {
			TheRealRealityOfMinecraftModVariables.WorldVariables.get(world).alloyfurnacelogic = (boolean) (true);
			TheRealRealityOfMinecraftModVariables.WorldVariables.get(world).syncData(world);
		} else {
			TheRealRealityOfMinecraftModVariables.WorldVariables.get(world).alloyfurnacelogic = (boolean) (false);
			TheRealRealityOfMinecraftModVariables.WorldVariables.get(world).syncData(world);
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
