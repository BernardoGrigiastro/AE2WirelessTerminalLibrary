package p455w0rd.ae2wtlib.api.container.slot;

import appeng.container.slot.AppEngSlot;
import net.minecraftforge.items.IItemHandler;

public class SlotTrash extends AppEngSlot {

	public SlotTrash(IItemHandler inv, int xPos, int yPos) {
		super(inv, 0, xPos, yPos);
	}

}