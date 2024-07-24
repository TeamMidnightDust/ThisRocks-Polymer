package eu.midnightdust.motschen.polymer_rocks.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import eu.midnightdust.motschen.polymer_rocks.item.StarfishBlockItem;
import eu.midnightdust.motschen.rocks.block.Starfish;
import eu.midnightdust.motschen.rocks.util.RegistryUtil;
import eu.pb4.factorytools.api.item.FactoryBlockItem;
import eu.pb4.polymer.core.api.block.PolymerBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = RegistryUtil.class, remap = false)
public abstract class MixinRegistryUtil {
    @WrapMethod(method = "blockItem")
    private static Item simplePolymerItem(Block block, Operation<Item> original) {
        if (block instanceof Starfish) return new StarfishBlockItem((Block & PolymerBlock) block, new Item.Settings(), Items.KELP);
        else return new FactoryBlockItem((Block & PolymerBlock) block, new Item.Settings(), Items.KELP);
    }
}
