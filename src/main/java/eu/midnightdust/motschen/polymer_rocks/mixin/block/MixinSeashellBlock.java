package eu.midnightdust.motschen.polymer_rocks.mixin.block;

import eu.midnightdust.motschen.polymer_rocks.block.ItemDisplaySeashellModel;
import eu.midnightdust.motschen.rocks.block.Seashell;
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

@Mixin(value = Seashell.class, remap = false)
public class MixinSeashellBlock implements FactoryBlock {
    @Shadow @Final public static BooleanProperty WATERLOGGED;

    @Override
    public BlockState getPolymerBlockState(BlockState state) {
        if (state.get(WATERLOGGED)) return Blocks.BARRIER.getDefaultState().with(WATERLOGGED, true);
        else return Blocks.STRUCTURE_VOID.getDefaultState();
    }

    @Override
    public BlockState getPolymerBreakEventBlockState(BlockState state, ServerPlayerEntity player) {
        return Blocks.WHITE_CANDLE.getDefaultState();
    }

    @Override
    public @Nullable ElementHolder createElementHolder(ServerWorld world, BlockPos pos, BlockState initialBlockState) {
        return new ItemDisplaySeashellModel(initialBlockState);
    }
}
