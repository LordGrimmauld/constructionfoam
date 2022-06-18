package mod.grimmauld.constructionfoam.registries;

import com.tterrag.registrate.util.entry.RegistryEntry;
import mod.grimmauld.constructionfoam.ConstructionFoam;
import net.minecraft.world.level.block.Block;

@SuppressWarnings("unused")
public class AllBlocks {
	public static final RegistryEntry<Block> CONSTRUCTION_FOAM = ConstructionFoam.registrate().block("solid_construction_foam", Block::new)
			.defaultBlockstate()
			.defaultLang()
			.register();

	// no instance
	private AllBlocks() {
	}

	// load class
	public static void register() {
		// do nothing
	}
}
