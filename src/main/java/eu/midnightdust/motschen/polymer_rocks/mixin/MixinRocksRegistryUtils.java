package eu.midnightdust.motschen.polymer_rocks.mixin;

import eu.midnightdust.motschen.polymer_rocks.item.StarfishBlockItem;
import eu.midnightdust.motschen.rocks.RocksRegistryUtils;
import eu.midnightdust.motschen.rocks.block.Starfish;
import eu.pb4.factorytools.api.item.FactoryBlockItem;
import eu.pb4.polymer.core.api.block.PolymerBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = RocksRegistryUtils.class, remap = false)
public abstract class MixinRocksRegistryUtils {
    @Shadow public static void registerItem(Identifier id, Item item) {}

    @Inject(method = "registerBlockWithItem", at = @At(value = "INVOKE", target = "Leu/midnightdust/motschen/rocks/RocksRegistryUtils;registerItem(Lnet/minecraft/util/Identifier;Lnet/minecraft/item/Item;)V", shift = At.Shift.BEFORE), cancellable = true)
    private static void registerPolymerBlockItem(Identifier id, Block block, CallbackInfo ci) {
        if (block instanceof Starfish) registerItem(id, new StarfishBlockItem((Block & PolymerBlock) block, new Item.Settings(), Items.KELP));
        else registerItem(id, new FactoryBlockItem((Block & PolymerBlock) block, new Item.Settings(), Items.KELP));
        ci.cancel();
    }
}
