
package net.mcreator.therealrealityofminecraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.therealrealityofminecraft.TheRealRealityOfMinecraftModElements;

@TheRealRealityOfMinecraftModElements.ModElement.Tag
public class SilverIngotItem extends TheRealRealityOfMinecraftModElements.ModElement {
	@ObjectHolder("the_real_reality_of_minecraft_:silver_ingot")
	public static final Item block = null;
	public SilverIngotItem(TheRealRealityOfMinecraftModElements instance) {
		super(instance, 53);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("silver_ingot");
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
