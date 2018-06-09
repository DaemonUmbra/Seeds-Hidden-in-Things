package daemonumbra.seedshiddeninthings.init;

import daemonumbra.seedshiddeninthings.util.Constants;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

/**
 * The SHiT creative tab
 */
public class SHiTTab extends CreativeTabs {

    public SHiTTab() {
        super(Constants.MOD_ID);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(SHiTItems.SEEDY_POO);
    }
}
