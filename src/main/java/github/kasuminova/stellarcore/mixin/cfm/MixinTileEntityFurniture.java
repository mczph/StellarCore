package github.kasuminova.stellarcore.mixin.cfm;

import com.mrcrayfish.furniture.tileentity.TileEntityFurniture;
import github.kasuminova.stellarcore.common.config.StellarCoreConfig;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import javax.annotation.Nonnull;

@Mixin(TileEntityFurniture.class)
public class MixinTileEntityFurniture extends TileEntity {

    @Unique
    @Override
    public boolean shouldRefresh(@Nonnull final World world,
                                 @Nonnull final BlockPos pos,
                                 @Nonnull final IBlockState oldState,
                                 @Nonnull final IBlockState newSate)
    {
        if (!StellarCoreConfig.BUG_FIXES.mrCrayfishFurniture.tileEntityFurniture) {
            return super.shouldRefresh(world, pos, oldState, newSate);
        }
        return oldState.getBlock() != newSate.getBlock();
    }

}
