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

public class ItemDisplaySeashellModel extends BlockModel {
    private final ItemDisplayElement main;
    public static ItemStack PINK;
    public static ItemStack WHITE;
    public static ItemStack YELLOW;

    public static void initModels() {
        PINK = BaseItemProvider.requestModel(RocksMain.id("block/seashell_pink"));
        WHITE = BaseItemProvider.requestModel(RocksMain.id("block/seashell_white"));
        YELLOW = BaseItemProvider.requestModel(RocksMain.id("block/seashell_yellow"));
    }

    public ItemDisplaySeashellModel(BlockState state) {
        this.main = ItemDisplayElementUtil.createSimple(getModel(state));
        this.main.setDisplaySize(1, 1);
        this.main.setScale(new Vector3f(2));
        this.addElement(this.main);
    }

    @Override
    public void notifyUpdate(HolderAttachment.UpdateType updateType) {
        if (updateType == BlockAwareAttachment.BLOCK_STATE_UPDATE) {
            var state = this.blockState();
            this.main.setItem(getModel(state));

            this.tick();
        }
    }
    private ItemStack getModel(BlockState state) {
        return switch (state.get(RocksMain.SEASHELL_VARIATION)) {
            case PINK -> PINK;
            case WHITE -> WHITE;
            case YELLOW -> YELLOW;
        };
    }
}
