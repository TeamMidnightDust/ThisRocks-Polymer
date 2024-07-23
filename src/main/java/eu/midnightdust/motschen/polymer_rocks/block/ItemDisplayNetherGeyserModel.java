package eu.midnightdust.motschen.polymer_rocks.block;

import eu.midnightdust.motschen.polymer_rocks.PolymerRocksConfig;
import eu.midnightdust.motschen.rocks.RocksMain;
import eu.midnightdust.motschen.rocks.block.NetherGeyser;
import eu.pb4.factorytools.api.resourcepack.BaseItemProvider;
import eu.pb4.factorytools.api.virtualentity.BlockModel;
import eu.pb4.factorytools.api.virtualentity.ItemDisplayElementUtil;
import eu.pb4.polymer.virtualentity.api.attachment.BlockAwareAttachment;
import eu.pb4.polymer.virtualentity.api.attachment.HolderAttachment;
import eu.pb4.polymer.virtualentity.api.elements.ItemDisplayElement;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RotationAxis;
import org.joml.Vector3f;

import static eu.midnightdust.motschen.polymer_rocks.PolymerRocksMain.random;

public class ItemDisplayNetherGeyserModel extends BlockModel {
    private final ItemDisplayElement main;;
    public static ItemStack NETHER_OFF;
    public static ItemStack NETHER_ON;

    public static void initModels() {
        NETHER_OFF = BaseItemProvider.requestModel(RocksMain.id("block/nether_geyser_off"));
        NETHER_ON = BaseItemProvider.requestModel(RocksMain.id("block/nether_geyser_on"));
    }

    public ItemDisplayNetherGeyserModel(BlockState state) {
        this.main = ItemDisplayElementUtil.createSimple(getModel(state));
        this.main.setDisplaySize(1, 1);
        this.main.setScale(new Vector3f(2));
        this.main.setRightRotation(RotationAxis.POSITIVE_Y.rotationDegrees(random.nextBetween(0, 360)));
        this.main.setViewRange(0.75f * (PolymerRocksConfig.viewDistance / 100f));
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
        return state.get(NetherGeyser.ACTIVE) ? NETHER_ON : NETHER_OFF;
    }
}
