package eu.midnightdust.motschen.polymer_rocks.block;

import eu.midnightdust.motschen.rocks.RocksMain;
import eu.pb4.factorytools.api.resourcepack.BaseItemProvider;
import eu.pb4.factorytools.api.virtualentity.BlockModel;
import eu.pb4.factorytools.api.virtualentity.ItemDisplayElementUtil;
import eu.pb4.polymer.virtualentity.api.attachment.BlockAwareAttachment;
import eu.pb4.polymer.virtualentity.api.attachment.HolderAttachment;
import eu.pb4.polymer.virtualentity.api.elements.ItemDisplayElement;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import org.joml.Vector3f;

import static eu.midnightdust.motschen.polymer_rocks.PolymerRocksMain.rocks;

public class ItemDisplayRockModel extends BlockModel {
    private final ItemDisplayElement main;

    public ItemDisplayRockModel(BlockState state) {
        this.main = ItemDisplayElementUtil.createSimple(getStack(state));
        this.main.setDisplaySize(1, 1);
        this.main.setScale(new Vector3f(2));
        this.addElement(this.main);
    }

    @Override
    public void notifyUpdate(HolderAttachment.UpdateType updateType) {
        if (updateType == BlockAwareAttachment.BLOCK_STATE_UPDATE) {
            var state = this.blockState();
            this.main.setItem(getStack(state));

            this.tick();
        }
    }
    private ItemStack getStack(BlockState state) {
        return BaseItemProvider.requestModel(rocks("block/" + state.get(RocksMain.ROCK_VARIATION).name() + "_" + state.getBlock().toString()));
    }
}
