
package net.mcreator.therealrealityofminecraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.therealrealityofminecraft.TheRealRealityOfMinecraftModElements;

@TheRealRealityOfMinecraftModElements.ModElement.Tag
public class TungstenItem extends TheRealRealityOfMinecraftModElements.ModElement {
	@ObjectHolder("the_real_reality_of_minecraft_:tungsten")
	public static final Item block = null;
	public TungstenItem(TheRealRealityOfMinecraftModElements instance) {
		super(instance, 63);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("tungsten");
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
