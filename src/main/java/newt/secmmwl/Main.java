package newt.secmmwl;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import newt.secmmwl.lists.ArmourMaterialList;
import newt.secmmwl.lists.BlockList;
import newt.secmmwl.lists.ItemList;
import newt.secmmwl.lists.ToolMaterialList;
import newt.secmmwl.world.OreGeneration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
                .addListener(this::clientRegistries);

        MinecraftForge.EVENT_BUS.register(this);
    }

    /**
     * Initiates the mod.
     * @param event
     */
    private void setup(final FMLCommonSetupEvent event)
    {
        OreGeneration.generateOre();
        logger.info("Setup method completed!");
    }

    /**
     * Register the client.
     * @param event
     */
    private void clientRegistries(final FMLClientSetupEvent event) {
        logger.info("Client registries method completed!");
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
                            /* Materials */
                            ItemList.ruby = new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName(location("ruby")),
                            ItemList.tin_ingot = new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName(location("tin_ingot")),
                            ItemList.copper_ingot = new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName(location("copper_ingot")),

                            /* Block Items */

                            // Ruby
                            ItemList.ruby_ore = new BlockItem(BlockList.ruby_ore, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(location("ruby_ore")),
                            ItemList.ruby_block = new BlockItem(BlockList.ruby_block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(location("ruby_block")),

                            // Tin
                            ItemList.tin_ore = new BlockItem(BlockList.tin_ore, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(location("tin_ore")),

                            // Copper
                            ItemList.copper_ore = new BlockItem(BlockList.copper_ore, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(location("copper_ore")),

                            /* Armour */

                            // Ruby
                            ItemList.ruby_helmet = new ArmorItem(ArmourMaterialList.ruby, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(location("ruby_helmet")),
                            ItemList.ruby_chestplate = new ArmorItem(ArmourMaterialList.ruby, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(location("ruby_chestplate")),
                            ItemList.ruby_leggings = new ArmorItem(ArmourMaterialList.ruby, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(location("ruby_leggings")),
                            ItemList.ruby_boots = new ArmorItem(ArmourMaterialList.ruby, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(location("ruby_boots")),

                            // Emerald
                            ItemList.emerald_helmet = new ArmorItem(ArmourMaterialList.emerald, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(location("emerald_helmet")),
                            ItemList.emerald_chestplate = new ArmorItem(ArmourMaterialList.emerald, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(location("emerald_chestplate")),
                            ItemList.emerald_leggings = new ArmorItem(ArmourMaterialList.emerald, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(location("emerald_leggings")),
                            ItemList.emerald_boots = new ArmorItem(ArmourMaterialList.emerald, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(location("emerald_boots")),

                            /* Tools */

                            // Ruby
                            ItemList.ruby_sword = new SwordItem(ToolMaterialList.ruby, -1, -2.4f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("ruby_sword")),
                            ItemList.ruby_pickaxe = new PickaxeItem(ToolMaterialList.ruby, -3, -2.8f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("ruby_pickaxe")),
                            ItemList.ruby_shovel = new ShovelItem(ToolMaterialList.ruby, -2.5f, -3.0f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("ruby_shovel")),
                            ItemList.ruby_axe = new AxeItem(ToolMaterialList.ruby, 1, -3.0f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("ruby_axe")),
                            ItemList.ruby_hoe = new HoeItem(ToolMaterialList.ruby, 5, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("ruby_hoe")),

                            // Emerald
                            ItemList.emerald_sword = new SwordItem(ToolMaterialList.emerald, -1, -2.4f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("emerald_sword")),
                            ItemList.emerald_pickaxe = new PickaxeItem(ToolMaterialList.emerald, -3, -2.8f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("emerald_pickaxe")),
                            ItemList.emerald_shovel = new ShovelItem(ToolMaterialList.emerald, -2.5f, -3.0f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("emerald_shovel")),
                            ItemList.emerald_axe = new AxeItem(ToolMaterialList.emerald, 1, -3.0f, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("emerald_axe")),
                            ItemList.emerald_hoe = new HoeItem(ToolMaterialList.emerald, 5, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("emerald_hoe"))
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
                            BlockList.ruby_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 30.0f).sound(SoundType.METAL).harvestLevel(3).harvestTool(ToolType.PICKAXE)).setRegistryName(location("ruby_block")),

                            // tin
                            BlockList.tin_ore = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0f, 15.0f).sound(SoundType.STONE).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName(location("tin_ore")),

                            // copper
                            BlockList.copper_ore = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0f, 15.0f).sound(SoundType.STONE).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName(location("copper_ore"))
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
