package mod.grimmauld.constructionfoam.registries;

import com.tterrag.registrate.AbstractRegistrate;
import com.tterrag.registrate.builders.FluidBuilder;
import com.tterrag.registrate.util.nullness.NonNullBiFunction;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import mod.grimmauld.constructionfoam.BuildConfig;
import mod.grimmauld.constructionfoam.ConstructionFoam;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ConstructionFoamRegistrate extends AbstractRegistrate<ConstructionFoamRegistrate> {

	/**
	 * Construct a new Registrate for the given mod ID.
	 *
	 * @param modid The mod ID for which objects will be registered
	 */
	protected ConstructionFoamRegistrate(String modid) {
		super(modid);

		// if modid is not equal to build config modid, log a warning
		if (!modid.equals(BuildConfig.MODID)) {
			ConstructionFoam.LOGGER.warn("ConstructionFoamRegistrate modid {} does not match build config modid {}. If you are an addon dev, watch out. This might have weird effects.", modid, BuildConfig.MODID);
		}
	}

	public static NonNullSupplier<ConstructionFoamRegistrate> lazy() {
		return NonNullSupplier.lazy(() -> new ConstructionFoamRegistrate(BuildConfig.MODID).registerEventListeners(FMLJavaModLoadingContext.get().getModEventBus()));
	}

	public <T extends ForgeFlowingFluid> FluidBuilder<T, ConstructionFoamRegistrate> standardFluid(String name, NonNullBiFunction<FluidAttributes.Builder, Fluid, FluidAttributes> attributesFactory, NonNullFunction<ForgeFlowingFluid.Properties, T> factory) {
		return entry(name, c -> FluidBuilder.create(this, this, name, c, ConstructionFoam.asResource("fluid/" + name + "_still"), ConstructionFoam.asResource("fluid/" + name + "_flow"), attributesFactory, factory));
	}
}
