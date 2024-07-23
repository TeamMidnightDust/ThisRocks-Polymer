package eu.midnightdust.motschen.polymer_rocks.mixin;

import eu.midnightdust.motschen.rocks.block.blockentity.BlockEntityInit;
import eu.midnightdust.motschen.rocks.block.blockentity.NetherGeyserBlockEntity;
import eu.midnightdust.motschen.rocks.block.blockentity.OverworldGeyserBlockEntity;
import eu.pb4.polymer.core.api.block.PolymerBlockUtils;
import net.minecraft.block.entity.BlockEntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = BlockEntityInit.class, remap = false)
public class MixinBlockEntityInit {
    @Shadow public static BlockEntityType<OverworldGeyserBlockEntity> OVERWORLD_GEYSER_BE;
    @Shadow public static BlockEntityType<NetherGeyserBlockEntity> NETHER_GEYSER_BE;

    @Inject(method = "init", at = @At("TAIL"))
    private static void onInit(CallbackInfo ci) {
        PolymerBlockUtils.registerBlockEntity(OVERWORLD_GEYSER_BE, NETHER_GEYSER_BE);
    }
}
