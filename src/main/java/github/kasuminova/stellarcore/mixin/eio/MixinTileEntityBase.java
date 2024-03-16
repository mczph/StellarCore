package github.kasuminova.stellarcore.mixin.eio;

import com.enderio.core.common.TileEntityBase;
import github.kasuminova.stellarcore.common.config.StellarCoreConfig;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(TileEntityBase.class)
public class MixinTileEntityBase extends TileEntity {

    @Redirect(
            method = "update",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/World;getTileEntity(Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/tileentity/TileEntity;"
            ))
    private TileEntity redirectGetTileEntity(final World instance, final BlockPos blockPos) {
        if (!StellarCoreConfig.PERFORMANCE.enderIO.tileEntityBase) {
            return instance.getTileEntity(blockPos);
        }
        return this;
    }

}