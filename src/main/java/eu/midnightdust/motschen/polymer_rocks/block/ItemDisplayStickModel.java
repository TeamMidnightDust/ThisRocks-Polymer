package eu.midnightdust.motschen.polymer_rocks.block;

import eu.midnightdust.motschen.rocks.RocksMain;
import eu.pb4.factorytools.api.resourcepack.BaseItemProvider;
import eu.pb4.factorytools.api.virtualentity.BlockModel;
import eu.pb4.factorytools.api.virtualentity.ItemDisplayElementUtil;
import eu.pb4.polymer.virtualentity.api.attachment.BlockAwareAttachment;
import eu.pb4.polymer.virtualentity.api.attachment.HolderAttachment;
import eu.pb4.polymer.virtualentity.api.elements.ItemDisplayElement;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RotationAxis;
import org.joml.Vector3f;

import static eu.midnightdust.motschen.polymer_rocks.PolymerRocksMain.random;

public class ItemDisplayStickModel extends BlockModel {
    private final ItemDisplayElement main;
    public static ItemStack SMALL_OAK_STICK_MODEL;
    public static ItemStack MEDIUM_OAK_STICK_MODEL;
    public static ItemStack LARGE_OAK_STICK_MODEL;
    public static ItemStack SMALL_BIRCH_STICK_MODEL;
    public static ItemStack MEDIUM_BIRCH_STICK_MODEL;
    public static ItemStack LARGE_BIRCH_STICK_MODEL;
    public static ItemStack SMALL_SPRUCE_STICK_MODEL;
    public static ItemStack MEDIUM_SPRUCE_STICK_MODEL;
    public static ItemStack LARGE_SPRUCE_STICK_MODEL;
    public static ItemStack SMALL_DARK_OAK_STICK_MODEL;
    public static ItemStack MEDIUM_DARK_OAK_STICK_MODEL;
    public static ItemStack LARGE_DARK_OAK_STICK_MODEL;
    public static ItemStack SMALL_ACACIA_STICK_MODEL;
    public static ItemStack MEDIUM_ACACIA_STICK_MODEL;
    public static ItemStack LARGE_ACACIA_STICK_MODEL;
    public static ItemStack SMALL_JUNGLE_STICK_MODEL;
    public static ItemStack MEDIUM_JUNGLE_STICK_MODEL;
    public static ItemStack LARGE_JUNGLE_STICK_MODEL;
    public static ItemStack SMALL_BAMBOO_STICK_MODEL;
    public static ItemStack MEDIUM_BAMBOO_STICK_MODEL;
    public static ItemStack LARGE_BAMBOO_STICK_MODEL;
    public static ItemStack SMALL_WARPED_STICK_MODEL;
    public static ItemStack MEDIUM_WARPED_STICK_MODEL;
    public static ItemStack LARGE_WARPED_STICK_MODEL;
    public static ItemStack SMALL_CRIMSON_STICK_MODEL;
    public static ItemStack MEDIUM_CRIMSON_STICK_MODEL;
    public static ItemStack LARGE_CRIMSON_STICK_MODEL;

    public static void initModels() {
        SMALL_OAK_STICK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/small_oak_stick"));
        MEDIUM_OAK_STICK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/medium_oak_stick"));
        LARGE_OAK_STICK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/large_oak_stick"));

        SMALL_BIRCH_STICK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/small_birch_stick"));
        MEDIUM_BIRCH_STICK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/medium_birch_stick"));
        LARGE_BIRCH_STICK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/large_birch_stick"));

        SMALL_SPRUCE_STICK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/small_spruce_stick"));
        MEDIUM_SPRUCE_STICK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/medium_spruce_stick"));
        LARGE_SPRUCE_STICK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/large_spruce_stick"));

        SMALL_DARK_OAK_STICK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/small_dark_oak_stick"));
        MEDIUM_DARK_OAK_STICK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/medium_dark_oak_stick"));
        LARGE_DARK_OAK_STICK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/large_dark_oak_stick"));

        SMALL_ACACIA_STICK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/small_acacia_stick"));
        MEDIUM_ACACIA_STICK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/medium_acacia_stick"));
        LARGE_ACACIA_STICK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/large_acacia_stick"));

        SMALL_JUNGLE_STICK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/small_jungle_stick"));
        MEDIUM_JUNGLE_STICK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/medium_jungle_stick"));
        LARGE_JUNGLE_STICK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/large_jungle_stick"));

        SMALL_BAMBOO_STICK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/small_bamboo_stick"));
        MEDIUM_BAMBOO_STICK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/medium_bamboo_stick"));
        LARGE_BAMBOO_STICK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/large_bamboo_stick"));

        SMALL_WARPED_STICK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/small_warped_stick"));
        MEDIUM_WARPED_STICK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/medium_warped_stick"));
        LARGE_WARPED_STICK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/large_warped_stick"));

        SMALL_CRIMSON_STICK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/small_crimson_stick"));
        MEDIUM_CRIMSON_STICK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/medium_crimson_stick"));
        LARGE_CRIMSON_STICK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/large_crimson_stick"));
    }

    public ItemDisplayStickModel(BlockState state) {
        this.main = ItemDisplayElementUtil.createSimple(getModel(state));
        this.main.setDisplaySize(1, 1);
        this.main.setScale(new Vector3f(1));
        this.main.setRightRotation(RotationAxis.POSITIVE_Y.rotationDegrees(random.nextBetween(0, 360)));
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
        var block = state.getBlock();
        if (block == RocksMain.OakStick) {
            return switch (state.get(RocksMain.STICK_VARIATION)) {
                case SMALL -> SMALL_OAK_STICK_MODEL;
                case MEDIUM -> MEDIUM_OAK_STICK_MODEL;
                case LARGE -> LARGE_OAK_STICK_MODEL;
            };
        }
        else if (block == RocksMain.BirchStick) {
            return switch (state.get(RocksMain.STICK_VARIATION)) {
                case SMALL -> SMALL_BIRCH_STICK_MODEL;
                case MEDIUM -> MEDIUM_BIRCH_STICK_MODEL;
                case LARGE -> LARGE_BIRCH_STICK_MODEL;
            };
        }
        else if (block == RocksMain.SpruceStick) {
            return switch (state.get(RocksMain.STICK_VARIATION)) {
                case SMALL -> SMALL_SPRUCE_STICK_MODEL;
                case MEDIUM -> MEDIUM_SPRUCE_STICK_MODEL;
                case LARGE -> LARGE_SPRUCE_STICK_MODEL;
            };
        }
        else if (block == RocksMain.AcaciaStick) {
            return switch (state.get(RocksMain.STICK_VARIATION)) {
                case SMALL -> SMALL_ACACIA_STICK_MODEL;
                case MEDIUM -> MEDIUM_ACACIA_STICK_MODEL;
                case LARGE -> LARGE_ACACIA_STICK_MODEL;
            };
        }
        else if (block == RocksMain.DarkOakStick) {
            return switch (state.get(RocksMain.STICK_VARIATION)) {
                case SMALL -> SMALL_DARK_OAK_STICK_MODEL;
                case MEDIUM -> MEDIUM_DARK_OAK_STICK_MODEL;
                case LARGE -> LARGE_DARK_OAK_STICK_MODEL;
            };
        }
        else if (block == RocksMain.JungleStick) {
            return switch (state.get(RocksMain.STICK_VARIATION)) {
                case SMALL -> SMALL_JUNGLE_STICK_MODEL;
                case MEDIUM -> MEDIUM_JUNGLE_STICK_MODEL;
                case LARGE -> LARGE_JUNGLE_STICK_MODEL;
            };
        }
        else if (block == RocksMain.BambooStick) {
            return switch (state.get(RocksMain.STICK_VARIATION)) {
                case SMALL -> SMALL_BAMBOO_STICK_MODEL;
                case MEDIUM -> MEDIUM_BAMBOO_STICK_MODEL;
                case LARGE -> LARGE_BAMBOO_STICK_MODEL;
            };
        }
        else if (block == RocksMain.WarpedStick) {
            return switch (state.get(RocksMain.STICK_VARIATION)) {
                case SMALL -> SMALL_WARPED_STICK_MODEL;
                case MEDIUM -> MEDIUM_WARPED_STICK_MODEL;
                case LARGE -> LARGE_WARPED_STICK_MODEL;
            };
        }
        else {
            return switch (state.get(RocksMain.STICK_VARIATION)) {
                case SMALL -> SMALL_CRIMSON_STICK_MODEL;
                case MEDIUM -> MEDIUM_CRIMSON_STICK_MODEL;
                case LARGE -> LARGE_CRIMSON_STICK_MODEL;
            };
        }
    }
}
