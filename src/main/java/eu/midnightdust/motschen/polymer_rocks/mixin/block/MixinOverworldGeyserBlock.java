package eu.midnightdust.motschen.polymer_rocks.mixin.block;

import eu.midnightdust.motschen.polymer_rocks.block.ItemDisplayOverworldGeyserModel;
import eu.midnightdust.motschen.rocks.block.OverworldGeyser;
import eu.pb4.factorytools.api.block.FactoryBlock;
import eu.pb4.polymer.virtualentity.api.ElementHolder;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = OverworldGeyser.class, remap = false)
public class MixinOverworldGeyserBlock implements FactoryBlock {
    @Shadow @Final public static BooleanProperty SNOWY;

    @Override
    public BlockState getPolymerBlockState(BlockState state) {
        return state.get(SNOWY) ? Blocks.SNOW.getDefaultState() : Blocks.STRUCTURE_VOID.getDefaultState();
    }

    @Override
    public BlockState getPolymerBreakEventBlockState(BlockState state, ServerPlayerEntity player) {
        return Blocks.SNOW.getDefaultState();
    }

    @Override
    public @Nullable ElementHolder createElementHolder(ServerWorld world, BlockPos pos, BlockState initialBlockState) {
        return new ItemDisplayOverworldGeyserModel(initialBlockState);
    }
}
