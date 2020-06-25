package newt.secmmwl;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import newt.secmmwl.lists.BlockList;
import newt.secmmwl.lists.ItemList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraft.item.Item;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("secmmwl")
public class Main
{
    public static Main instance;
    public static final String modid = "secmmwl";
    private static final Logger logger = LogManager.getLogger();

    /**
     * Constructs the Main class
     */
    public Main() {
        instance = this;
        
        FMLJavaModLoadingContext
                .get()
                .getModEventBus()
                .addListener(this::setup);
        
        FMLJavaModLoadingContext
                .get()
                .getModEventBus()
                .addListener(this::clientRegisteries);

        MinecraftForge.EVENT_BUS.register(this);
    }

    /**
     * Initiates the mod.
     * @param event
     */
    private void setup(final FMLCommonSetupEvent event)
    {
        logger.info("Setup method completed!");
    }

    /**
     * Register the client.
     * @param event
     */
    private void clientRegisteries(final FMLClientSetupEvent event) {
        logger.info("Client registeries method completed!");
    }

    /**
     * Registry events
     */
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        /**
         * Registers all of the mod's items
         */
        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event) {
            event.getRegistry().registerAll
                    (
                            // Rubies
                            ItemList.ruby = new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName(location("ruby")),
                            ItemList.ruby_ore = new BlockItem(BlockList.ruby_ore, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(location("ruby_ore")),
                            ItemList.ruby_block = new BlockItem(BlockList.ruby_block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(location("ruby_block"))
                  );
            logger.info("All items registered!");
        }

        /**
         * Registers all of the mod's blocks
         */
        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event) {
            event.getRegistry().registerAll
                    (
                            // rubies
                            BlockList.ruby_ore = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0f, 15.0f).sound(SoundType.STONE).harvestLevel(3).harvestTool(ToolType.PICKAXE)).setRegistryName(location("ruby_ore")),
                            BlockList.ruby_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 30.0f).sound(SoundType.METAL).harvestLevel(3).harvestTool(ToolType.PICKAXE)).setRegistryName(location("ruby_block"))
                    );
            logger.info("All blocks registered!");
        }

        /**
         * Creates a new ResourceLocation using the mod's ID and the given name
         */
        private static ResourceLocation location(String name) {
            return new ResourceLocation(modid, name);
        }
    }
}
