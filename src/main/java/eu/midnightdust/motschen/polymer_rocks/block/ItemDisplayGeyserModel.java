package eu.midnightdust.motschen.polymer_rocks.block;

import eu.midnightdust.motschen.rocks.RocksMain;
import eu.midnightdust.motschen.rocks.block.OverworldGeyser;
import eu.pb4.factorytools.api.resourcepack.BaseItemProvider;
import eu.pb4.factorytools.api.virtualentity.BlockModel;
import eu.pb4.factorytools.api.virtualentity.ItemDisplayElementUtil;
import eu.pb4.polymer.virtualentity.api.attachment.BlockAwareAttachment;
import eu.pb4.polymer.virtualentity.api.attachment.HolderAttachment;
import eu.pb4.polymer.virtualentity.api.elements.ItemDisplayElement;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Vec3d;
import org.joml.Vector3f;

import static eu.midnightdust.motschen.polymer_rocks.PolymerRocksMain.id;
import static eu.midnightdust.motschen.polymer_rocks.PolymerRocksMain.rocks;

public class ItemDisplayGeyserModel extends BlockModel {
    private final ItemDisplayElement main;
    public static final BooleanProperty ACTIVE = BooleanProperty.of("active");
    public static final ItemStack OVERWORLD_OFF = BaseItemProvider.requestModel(id("block/geyser_off"));
    public static final ItemStack OVERWORLD_ON = BaseItemProvider.requestModel(id("block/geyser_on"));
    public static final ItemStack NETHER_OFF = BaseItemProvider.requestModel(id("block/nether_geyser_off"));
    public static final ItemStack NETHER_ON = BaseItemProvider.requestModel(id("block/nether_geyser_off"));

    public ItemDisplayGeyserModel(BlockState state) {
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
            if (state.contains(Properties.SNOWY) && state.get(Properties.SNOWY)) this.main.setOverridePos(new Vec3d(0d, 0.125d, 0d));
            else this.main.setOverridePos(new Vec3d(0, 0, 0));

            this.tick();
        }
    }
    private ItemStack getStack(BlockState state) {
        return BaseItemProvider.requestModel(rocks("block/" + state.getBlock().toString() + (state.get(ACTIVE) ? "_on" : "_off")));
    }
}
