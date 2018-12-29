package p455w0rd.ae2wtlib.container.slot;

import appeng.container.slot.AppEngSlot;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.IItemHandler;

public class SlotArmor extends AppEngSlot {

	final EntityEquipmentSlot armorSlot;
	final EntityPlayer player;

	public SlotArmor(EntityPlayer player, IItemHandler inventory, int slot, int x, int y, EntityEquipmentSlot armorSlot) {
		super(inventory, slot, x, y);
		this.player = player;
		this.armorSlot = armorSlot;
	}

	@Override
	public int getSlotStackLimit() {
		return 1;
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		return !stack.isEmpty() && stack.getItem().isValidArmor(stack, EntityEquipmentSlot.values()[armorSlot.ordinal() + 1], player);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public TextureAtlasSprite getBackgroundSprite() {
		String name = ItemArmor.EMPTY_SLOT_NAMES[armorSlot.ordinal() - 1];
		return name == null ? null : getBackgroundMap().getAtlasSprite(name);
	}

}
