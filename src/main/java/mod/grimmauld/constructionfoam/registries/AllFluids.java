package mod.grimmauld.constructionfoam.registries;

import com.tterrag.registrate.util.entry.FluidEntry;
import mod.grimmauld.constructionfoam.BuildConfig;
import mod.grimmauld.constructionfoam.ConstructionFoam;
import mod.grimmauld.constructionfoam.content.ConstructionFoamFluid;
import net.minecraft.tags.FluidTags;
import net.minecraftforge.fluids.ForgeFlowingFluid;

public class AllFluids {
	public static final FluidEntry<? extends ForgeFlowingFluid> CONSTRUCTION_FOAM = ConstructionFoam.registrate().standardFluid("construction_foam", ConstructionFoamFluid.ConstructionFoamFluidAttributes::new, ConstructionFoamFluid.Flowing::new)
			.lang("fluid." + BuildConfig.MODID + ".construction_foam")
			.removeTag(FluidTags.WATER)
			.attributes(b -> b.viscosity(2000).density(1400))
			.properties(p -> p.levelDecreasePerBlock(3)
					.tickRate(50)
					.slopeFindDistance(2)
					.explosionResistance(100f))
			// .source(ConstructionFoamFluid.Source::new)
			// .bucket()
			// .build()
			.register();

	// prevent instantiation
	private AllFluids() {
	}

	// load class
	public static void register() {
	}
}
