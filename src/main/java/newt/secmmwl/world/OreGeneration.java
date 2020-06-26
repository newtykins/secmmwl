package newt.secmmwl.world;

import newt.secmmwl.lists.BlockList;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGeneration {
    public static void generateOre() {
        for (Biome biome : ForgeRegistries.BIOMES) {
            boolean mountains = biome == Biomes.MOUNTAINS || biome == Biomes.SNOWY_MOUNTAINS || biome == Biomes.MOUNTAIN_EDGE || biome == Biomes.GRAVELLY_MOUNTAINS || biome == Biomes.MODIFIED_GRAVELLY_MOUNTAINS || biome == Biomes.SNOWY_TAIGA_MOUNTAINS || biome == Biomes.TAIGA_MOUNTAINS || biome == Biomes.WOODED_MOUNTAINS

            if (mountains) {
                ConfiguredPlacement customConfig = Placement.COUNT_RANGE
                        // Chunk Count, MinHeight, MaxHeightBase, MaxHeight
                        .configure(new CountRangeConfig(5, 2, 5, 10));
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
                        .withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockList.ruby_ore.getDefaultState(), 4))
                        .withPlacement(customConfig));
            }
        }
    }
}