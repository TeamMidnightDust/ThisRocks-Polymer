package eu.midnightdust.motschen.polymer_rocks.item;

import eu.midnightdust.motschen.rocks.RocksMain;
import eu.midnightdust.motschen.rocks.blockstates.StarfishVariation;
import eu.pb4.factorytools.api.item.FactoryBlockItem;
import eu.pb4.polymer.core.api.block.PolymerBlock;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.minecraft.block.Block;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public class StarfishBlockItem extends FactoryBlockItem {
    public <T extends Block & PolymerBlock> StarfishBlockItem(T block, Settings settings, Item item) {
        super(block, settings, item);
    }

    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        var state = itemStack.getComponents().get(DataComponentTypes.BLOCK_STATE);
        if (state != null && !state.isEmpty()) {
            return switch (state.getValue(RocksMain.STARFISH_VARIATION)) {
                case RED -> MODELS.get(StarfishVariation.RED).value();
                case PINK -> MODELS.get(StarfishVariation.PINK).value();
                case ORANGE -> MODELS.get(StarfishVariation.ORANGE).value();
                case null -> MODELS.get(this).value();
            };
        }
        return MODELS.get(this).value();
    }

    @Override
    public void onRegistered(Identifier selfId) {
        var item = Identifier.of(selfId.getNamespace(), "item/" + selfId.getPath());
        MODELS.put(this, PolymerResourcePackUtils.requestModel(this.getPolymerItem(), item));
        MODELS.put(StarfishVariation.RED, PolymerResourcePackUtils.requestModel(this.getPolymerItem(), Identifier.of(selfId.getNamespace(), "item/" + "red_" + selfId.getPath())));
        MODELS.put(StarfishVariation.PINK, PolymerResourcePackUtils.requestModel(this.getPolymerItem(), Identifier.of(selfId.getNamespace(), "item/" + "pink_" + selfId.getPath())));
        MODELS.put(StarfishVariation.ORANGE, PolymerResourcePackUtils.requestModel(this.getPolymerItem(), Identifier.of(selfId.getNamespace(), "item/" + "orange_" + selfId.getPath())));
    }
}
