
package net.mcreator.therealrealityofminecraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.therealrealityofminecraft.TheRealRealityOfMinecraftModElements;

@TheRealRealityOfMinecraftModElements.ModElement.Tag
public class PlutoniumCoreItem extends TheRealRealityOfMinecraftModElements.ModElement {
	@ObjectHolder("the_real_reality_of_minecraft_:plutonium_core")
	public static final Item block = null;
	public PlutoniumCoreItem(TheRealRealityOfMinecraftModElements instance) {
		super(instance, 62);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("plutonium_core");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
