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
import net.minecraft.util.math.RotationAxis;
import org.joml.Vector3f;

import static eu.midnightdust.motschen.polymer_rocks.PolymerRocksMain.random;

public class ItemDisplayRockModel extends BlockModel {
    private final ItemDisplayElement main;
    public static ItemStack TINY_ROCK_MODEL;
    public static ItemStack SMALL_ROCK_MODEL;
    public static ItemStack MEDIUM_ROCK_MODEL;
    public static ItemStack LARGE_ROCK_MODEL;
    public static ItemStack TINY_ANDESITE_ROCK_MODEL;
    public static ItemStack SMALL_ANDESITE_ROCK_MODEL;
    public static ItemStack MEDIUM_ANDESITE_ROCK_MODEL;
    public static ItemStack LARGE_ANDESITE_ROCK_MODEL;
    public static ItemStack TINY_GRANITE_ROCK_MODEL;
    public static ItemStack SMALL_GRANITE_ROCK_MODEL;
    public static ItemStack MEDIUM_GRANITE_ROCK_MODEL;
    public static ItemStack LARGE_GRANITE_ROCK_MODEL;
    public static ItemStack TINY_DIORITE_ROCK_MODEL;
    public static ItemStack SMALL_DIORITE_ROCK_MODEL;
    public static ItemStack MEDIUM_DIORITE_ROCK_MODEL;
    public static ItemStack LARGE_DIORITE_ROCK_MODEL;
    public static ItemStack TINY_GRAVEL_ROCK_MODEL;
    public static ItemStack SMALL_GRAVEL_ROCK_MODEL;
    public static ItemStack MEDIUM_GRAVEL_ROCK_MODEL;
    public static ItemStack LARGE_GRAVEL_ROCK_MODEL;
    public static ItemStack TINY_SANDSTONE_ROCK_MODEL;
    public static ItemStack SMALL_SANDSTONE_ROCK_MODEL;
    public static ItemStack MEDIUM_SANDSTONE_ROCK_MODEL;
    public static ItemStack LARGE_SANDSTONE_ROCK_MODEL;
    public static ItemStack TINY_RED_SANDSTONE_ROCK_MODEL;
    public static ItemStack SMALL_RED_SANDSTONE_ROCK_MODEL;
    public static ItemStack MEDIUM_RED_SANDSTONE_ROCK_MODEL;
    public static ItemStack LARGE_RED_SANDSTONE_ROCK_MODEL;
    public static ItemStack TINY_NETHERRACK_ROCK_MODEL;
    public static ItemStack SMALL_NETHERRACK_ROCK_MODEL;
    public static ItemStack MEDIUM_NETHERRACK_ROCK_MODEL;
    public static ItemStack LARGE_NETHERRACK_ROCK_MODEL;
    public static ItemStack TINY_ENDSTONE_ROCK_MODEL;
    public static ItemStack SMALL_ENDSTONE_ROCK_MODEL;
    public static ItemStack MEDIUM_ENDSTONE_ROCK_MODEL;
    public static ItemStack LARGE_ENDSTONE_ROCK_MODEL;


    public static void initModels() {
        TINY_ROCK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/tiny_rock"));
        SMALL_ROCK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/small_rock"));
        MEDIUM_ROCK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/medium_rock"));
        LARGE_ROCK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/large_rock"));

        TINY_ANDESITE_ROCK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/tiny_andesite_rock"));
        SMALL_ANDESITE_ROCK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/small_andesite_rock"));
        MEDIUM_ANDESITE_ROCK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/medium_andesite_rock"));
        LARGE_ANDESITE_ROCK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/large_andesite_rock"));

        TINY_GRANITE_ROCK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/tiny_granite_rock"));
        SMALL_GRANITE_ROCK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/small_granite_rock"));
        MEDIUM_GRANITE_ROCK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/medium_granite_rock"));
        LARGE_GRANITE_ROCK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/large_granite_rock"));

        TINY_DIORITE_ROCK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/tiny_diorite_rock"));
        SMALL_DIORITE_ROCK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/small_diorite_rock"));
        MEDIUM_DIORITE_ROCK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/medium_diorite_rock"));
        LARGE_DIORITE_ROCK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/large_diorite_rock"));

        TINY_GRAVEL_ROCK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/tiny_gravel_rock"));
        SMALL_GRAVEL_ROCK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/small_gravel_rock"));
        MEDIUM_GRAVEL_ROCK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/medium_gravel_rock"));
        LARGE_GRAVEL_ROCK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/large_gravel_rock"));

        TINY_SANDSTONE_ROCK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/tiny_sand_rock"));
        SMALL_SANDSTONE_ROCK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/small_sand_rock"));
        MEDIUM_SANDSTONE_ROCK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/medium_sand_rock"));
        LARGE_SANDSTONE_ROCK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/large_sand_rock"));

        TINY_RED_SANDSTONE_ROCK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/tiny_red_sand_rock"));
        SMALL_RED_SANDSTONE_ROCK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/small_red_sand_rock"));
        MEDIUM_RED_SANDSTONE_ROCK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/medium_red_sand_rock"));
        LARGE_RED_SANDSTONE_ROCK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/large_red_sand_rock"));

        TINY_NETHERRACK_ROCK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/tiny_netherrack_rock"));
        SMALL_NETHERRACK_ROCK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/small_netherrack_rock"));
        MEDIUM_NETHERRACK_ROCK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/medium_netherrack_rock"));
        LARGE_NETHERRACK_ROCK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/large_netherrack_rock"));

        TINY_ENDSTONE_ROCK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/tiny_end_stone_rock"));
        SMALL_ENDSTONE_ROCK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/small_end_stone_rock"));
        MEDIUM_ENDSTONE_ROCK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/medium_end_stone_rock"));
        LARGE_ENDSTONE_ROCK_MODEL = BaseItemProvider.requestModel(RocksMain.id("block/large_end_stone_rock"));
    }

    public ItemDisplayRockModel(BlockState state) {
        this.main = ItemDisplayElementUtil.createSimple(getModel(state));
        this.main.setDisplaySize(1, 1);
        this.main.setScale(new Vector3f(2));
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
        if (state.getBlock() == RocksMain.Rock) {
            return switch (state.get(RocksMain.ROCK_VARIATION)) {
                case TINY -> TINY_ROCK_MODEL;
                case SMALL -> SMALL_ROCK_MODEL;
                case MEDIUM -> MEDIUM_ROCK_MODEL;
                case LARGE -> LARGE_ROCK_MODEL;
            };
        }
        else if (state.getBlock() == RocksMain.AndesiteRock) {
            return switch (state.get(RocksMain.ROCK_VARIATION)) {
                case TINY -> TINY_ANDESITE_ROCK_MODEL;
                case SMALL -> SMALL_ANDESITE_ROCK_MODEL;
                case MEDIUM -> MEDIUM_ANDESITE_ROCK_MODEL;
                case LARGE -> LARGE_ANDESITE_ROCK_MODEL;
            };
        }
        else if (state.getBlock() == RocksMain.GraniteRock) {
            return switch (state.get(RocksMain.ROCK_VARIATION)) {
                case TINY -> TINY_GRANITE_ROCK_MODEL;
                case SMALL -> SMALL_GRANITE_ROCK_MODEL;
                case MEDIUM -> MEDIUM_GRANITE_ROCK_MODEL;
                case LARGE -> LARGE_GRANITE_ROCK_MODEL;
            };
        }
        else if (state.getBlock() == RocksMain.DioriteRock) {
            return switch (state.get(RocksMain.ROCK_VARIATION)) {
                case TINY -> TINY_DIORITE_ROCK_MODEL;
                case SMALL -> SMALL_DIORITE_ROCK_MODEL;
                case MEDIUM -> MEDIUM_DIORITE_ROCK_MODEL;
                case LARGE -> LARGE_DIORITE_ROCK_MODEL;
            };
        }
        else if (state.getBlock() == RocksMain.GravelRock) {
            return switch (state.get(RocksMain.ROCK_VARIATION)) {
                case TINY -> TINY_GRAVEL_ROCK_MODEL;
                case SMALL -> SMALL_GRAVEL_ROCK_MODEL;
                case MEDIUM -> MEDIUM_GRAVEL_ROCK_MODEL;
                case LARGE -> LARGE_GRAVEL_ROCK_MODEL;
            };
        }
        else if (state.getBlock() == RocksMain.SandRock) {
            return switch (state.get(RocksMain.ROCK_VARIATION)) {
                case TINY -> TINY_SANDSTONE_ROCK_MODEL;
                case SMALL -> SMALL_SANDSTONE_ROCK_MODEL;
                case MEDIUM -> MEDIUM_SANDSTONE_ROCK_MODEL;
                case LARGE -> LARGE_SANDSTONE_ROCK_MODEL;
            };
        }
        else if (state.getBlock() == RocksMain.RedSandRock) {
            return switch (state.get(RocksMain.ROCK_VARIATION)) {
                case TINY -> TINY_RED_SANDSTONE_ROCK_MODEL;
                case SMALL -> SMALL_RED_SANDSTONE_ROCK_MODEL;
                case MEDIUM -> MEDIUM_RED_SANDSTONE_ROCK_MODEL;
                case LARGE -> LARGE_RED_SANDSTONE_ROCK_MODEL;
            };
        }
        else if (state.getBlock() == RocksMain.NetherrackRock) {
            return switch (state.get(RocksMain.ROCK_VARIATION)) {
                case TINY -> TINY_NETHERRACK_ROCK_MODEL;
                case SMALL -> SMALL_NETHERRACK_ROCK_MODEL;
                case MEDIUM -> MEDIUM_NETHERRACK_ROCK_MODEL;
                case LARGE -> LARGE_NETHERRACK_ROCK_MODEL;
            };
        }
        else  {
            return switch (state.get(RocksMain.ROCK_VARIATION)) {
                case TINY -> TINY_ENDSTONE_ROCK_MODEL;
                case SMALL -> SMALL_ENDSTONE_ROCK_MODEL;
                case MEDIUM -> MEDIUM_ENDSTONE_ROCK_MODEL;
                case LARGE -> LARGE_ENDSTONE_ROCK_MODEL;
            };
        }
    }
}
