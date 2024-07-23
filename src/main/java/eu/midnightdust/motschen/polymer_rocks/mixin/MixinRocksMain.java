package eu.midnightdust.motschen.polymer_rocks.mixin;

import eu.midnightdust.motschen.rocks.RocksMain;
import eu.midnightdust.motschen.rocks.block.blockentity.BlockEntityInit;
import eu.midnightdust.motschen.rocks.world.FeatureInjector;
import eu.midnightdust.motschen.rocks.world.FeatureRegistry;
import eu.pb4.polymer.core.api.item.PolymerItemGroupUtils;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

import static eu.midnightdust.motschen.rocks.RocksMain.Rock;

@Mixin(value = RocksMain.class, remap = false)
public class MixinRocksMain {

    @Shadow public static ItemGroup RocksGroup;
    @Shadow public static List<ItemStack> groupItems;

    @Inject(method = "onInitialize", at = @At(value = "INVOKE", target = "Lnet/fabricmc/fabric/api/itemgroup/v1/FabricItemGroup;builder()Lnet/minecraft/item/ItemGroup$Builder;"), cancellable = true)
    private void shit(CallbackInfo ci) {
        RocksGroup = PolymerItemGroupUtils.builder().displayName(Text.translatable("itemGroup.rocks.rocks")).icon(() -> new ItemStack(Rock)).entries((displayContext, entries) -> {
            entries.addAll(groupItems);
        }).build();
        PolymerItemGroupUtils.registerPolymerItemGroup(Identifier.of("rocks", "rocks"), RocksGroup);
        new FeatureRegistry();
        FeatureInjector.init();
        BlockEntityInit.init();
        ci.cancel();
    }
}
