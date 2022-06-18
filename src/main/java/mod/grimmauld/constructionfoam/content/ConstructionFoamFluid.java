package mod.grimmauld.constructionfoam.content;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public abstract class ConstructionFoamFluid extends ForgeFlowingFluid {
	protected ConstructionFoamFluid(Properties properties) {
		super(properties);
	}

	public static class ConstructionFoamFluidAttributes extends FluidAttributes {
		public ConstructionFoamFluidAttributes(Builder builder, Fluid fluid) {
			super(builder, fluid);
		}

		@Override
		public int getColor(BlockAndTintGetter world, BlockPos pos) {
			return 0x00ffffff;
		}

	}

	public static class Source extends ConstructionFoamFluid {
		public Source(Properties properties) {
			super(properties);
		}

		public int getAmount(FluidState fluidState) {
			return 3;
		}

		public boolean isSource(FluidState fluidState) {
			return true;
		}
	}

	public static class Flowing extends ConstructionFoamFluid {

		public Flowing(Properties properties) {
			super(properties);
		}

		@Override
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> stateBuilder) {
			super.createFluidStateDefinition(stateBuilder);
			stateBuilder.add(LEVEL);
		}

		public int getAmount(FluidState pState) {
			return pState.getValue(LEVEL);
		}

		public boolean isSource(FluidState fluidState) {
			return false;
		}
	}
}
