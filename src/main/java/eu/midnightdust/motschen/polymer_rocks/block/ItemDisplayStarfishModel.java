package eu.midnightdust.motschen.polymer_rocks.block;

import eu.midnightdust.motschen.polymer_rocks.PolymerRocksConfig;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.joml.Vector3f;

import java.util.HashSet;
import java.util.Set;

public class ItemDisplayStarfishModel extends BlockModel {
    private final Set<ItemDisplayElement> arms = HashSet.newHashSet(5);
    public static ItemStack RED;
    public static ItemStack ORANGE;
    public static ItemStack PINK;
    public static ItemStack RED_FIRST;
    public static ItemStack ORANGE_FIRST;
    public static ItemStack PINK_FIRST;

    public static void initModels() {
        RED = BaseItemProvider.requestModel(PolymerRocksMain.id("block/starfish_red_arm"));
        ORANGE = BaseItemProvider.requestModel(PolymerRocksMain.id("block/starfish_orange_arm"));
        PINK = BaseItemProvider.requestModel(PolymerRocksMain.id("block/starfish_pink_arm"));
        RED_FIRST = BaseItemProvider.requestModel(PolymerRocksMain.id("block/starfish_red_first_arm"));
        ORANGE_FIRST = BaseItemProvider.requestModel(PolymerRocksMain.id("block/starfish_orange_first_arm"));
        PINK_FIRST = BaseItemProvider.requestModel(PolymerRocksMain.id("block/starfish_pink_first_arm"));
    }

    public ItemDisplayStarfishModel(BlockState state, BlockPos pos) {
        ItemStack modelStack = getModel(state);
        int baseRotation = pos.hashCode() % 360;
        double xOffset = ((pos.hashCode() + pos.getX()) % 250 - 125) / 1000f;
        double zOffset = ((pos.hashCode() + pos.getZ()) % 250 - 125) / 1000f;
        for (int i = 0; i < 5; i++) {
            var arm = ItemDisplayElementUtil.createSimple(i != 0 ? modelStack : getFirstModel(state));
            arm.setDisplaySize(1, 1);
            arm.setScale(new Vector3f(1));
            arm.setRightRotation(RotationAxis.POSITIVE_Y.rotationDegrees(baseRotation + 72.5f * i));
            arm.setOffset(new Vec3d(xOffset, 0, zOffset));
            arm.setViewRange(0.4f * (PolymerRocksConfig.viewDistance / 100f));
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
            this.arms.stream().findFirst().get().setItem(getFirstModel(state));

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
    private ItemStack getFirstModel(BlockState state) {
        return switch (state.get(RocksMain.STARFISH_VARIATION)) {
            case RED -> RED_FIRST;
            case ORANGE -> ORANGE_FIRST;
            case PINK -> PINK_FIRST;
        };
    }
}
