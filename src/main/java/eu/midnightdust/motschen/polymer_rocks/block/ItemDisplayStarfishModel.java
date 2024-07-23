package eu.midnightdust.motschen.polymer_rocks.block;

import eu.midnightdust.motschen.polymer_rocks.PolymerRocksMain;
import eu.midnightdust.motschen.rocks.RocksMain;
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

import java.util.HashSet;
import java.util.Set;

public class ItemDisplayStarfishModel extends BlockModel {
    private final Set<ItemDisplayElement> arms = HashSet.newHashSet(5);
    public static ItemStack RED;
    public static ItemStack ORANGE;
    public static ItemStack PINK;

    public static void initModels() {
        RED = BaseItemProvider.requestModel(PolymerRocksMain.id("block/red_starfish_arm"));
        ORANGE = BaseItemProvider.requestModel(PolymerRocksMain.id("block/orange_starfish_arm"));
        PINK = BaseItemProvider.requestModel(PolymerRocksMain.id("block/pink_starfish_arm"));
    }

    public ItemDisplayStarfishModel(BlockState state) {
        ItemStack modelStack = getModel(state);
        for (int i = 0; i < 5; i++) {
            var arm = ItemDisplayElementUtil.createSimple(modelStack);
            arm.setDisplaySize(1, 1);
            arm.setScale(new Vector3f(2));
            arm.setRightRotation(RotationAxis.POSITIVE_Y.rotationDegrees(72.5f * i));
            arms.add(arm);
            this.addElement(arm);
        }
    }

    @Override
    public void notifyUpdate(HolderAttachment.UpdateType updateType) {
        if (updateType == BlockAwareAttachment.BLOCK_STATE_UPDATE) {
            var state = this.blockState();
            ItemStack modelStack = getModel(state);
            this.arms.forEach(arm -> arm.setItem(modelStack));

            this.tick();
        }
    }
    private ItemStack getModel(BlockState state) {
        return switch (state.get(RocksMain.STARFISH_VARIATION)) {
            case RED -> RED;
            case ORANGE -> ORANGE;
            case PINK -> PINK;
        };
    }
}
