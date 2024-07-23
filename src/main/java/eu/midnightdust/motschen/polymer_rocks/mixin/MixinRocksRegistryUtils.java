package eu.midnightdust.motschen.polymer_rocks.mixin;

import eu.midnightdust.motschen.rocks.RocksMain;
import eu.midnightdust.motschen.rocks.RocksRegistryUtils;
import eu.pb4.factorytools.api.item.FactoryBlockItem;
import eu.pb4.polymer.core.api.block.PolymerBlock;
import eu.pb4.polymer.core.api.item.PolymerBlockItem;
import eu.pb4.polymer.core.api.item.SimplePolymerItem;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = RocksRegistryUtils.class, remap = false)
public abstract class MixinRocksRegistryUtils {
    @Inject(method = "registerItem", at = @At("HEAD"), cancellable = true)
    private static void registerItemAsPolymer(Identifier id, Item item, CallbackInfo ci) {
        if (item instanceof BlockItem blockItem) {
            Registry.register(Registries.ITEM, id, new FactoryBlockItem((Block & PolymerBlock) blockItem.getBlock(), new Item.Settings(), Items.LILY_PAD));
            ci.cancel();
            System.out.println(id);
        }
        else if (item instanceof Item) {
            Registry.register(Registries.ITEM, id, new SimplePolymerItem(new Item.Settings(), Items.LILY_PAD));
            //ci.cancel();
        }
        else System.out.println(id);
        ItemStack itemStack = new ItemStack(item);
        RocksMain.groupItems.add(itemStack);
    }
}
