package mod.grimmauld.constructionfoam;

import com.tterrag.registrate.util.nullness.NonNullSupplier;
import mod.grimmauld.constructionfoam.registries.AllBlocks;
import mod.grimmauld.constructionfoam.registries.AllFluids;
import mod.grimmauld.constructionfoam.registries.ConstructionFoamRegistrate;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("constructionfoam")
public class ConstructionFoam {
	public static final Logger LOGGER = LogManager.getLogger(BuildConfig.MODID);
	public static final NonNullSupplier<ConstructionFoamRegistrate> REGISTRATE = ConstructionFoamRegistrate.lazy();

	public ConstructionFoam() {
		AllBlocks.register();
		AllFluids.register();
	}

	public static ConstructionFoamRegistrate registrate() {
		return REGISTRATE.get();
	}

	public static ResourceLocation asResource(String path) {
		return new ResourceLocation(BuildConfig.MODID, path);
	}
}
