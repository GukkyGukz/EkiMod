package chaos.mod.objects.block.base;

import chaos.mod.Eki;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockLights extends BlockHasFace{
	private final boolean passable;
	private final boolean transluent;
	
	public BlockLights(String name, Float light, boolean passable, boolean transluent) {
		super(name, Eki.MISC, false);
		setLightLevel(light);
		this.passable = passable;
		this.transluent = transluent;
	}
	
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}
    
    @Override
	public BlockRenderLayer getBlockLayer() {
    	return transluent ? BlockRenderLayer.TRANSLUCENT : BlockRenderLayer.SOLID;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return passable ? NULL_AABB : FULL_BLOCK_AABB;
	}
}
