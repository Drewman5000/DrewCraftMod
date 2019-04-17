package linadan03.drewcraftmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import linadan03.drewcraftmod.lists.ItemList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("drewcraftmod")
public class DrewCraftMod {
	public static DrewCraftMod instance;
	public static final String modid = "drewcraftmod";
	private static final Logger LOGGER = LogManager.getLogger(modid);
	
	public DrewCraftMod () {
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event) {
		//pre-init stuff
		LOGGER.info("Setup method registered.");
	}
	
	private void clientRegistries(final FMLClientSetupEvent event) {
		//client-side setup
		LOGGER.info("clientRegistries method registered.");
	}
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents{
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			event.getRegistry().registerAll(
			ItemList.tutorial_item = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("tutorial_item")),
			ItemList.item_two = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("item_two"))
			);
			
			LOGGER.info("Items registered.");
		}
		private static ResourceLocation location(String name) {
			return new ResourceLocation(modid, name);
		}
	}

}
