package com.thegoat;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.thegoat.proxy.CommonProxy;
import com.thegoat.recipes.ModRecipes;


@Mod(
	modid = TheGoat.MODID,
	name = TheGoat.NAME,
	version = TheGoat.VERSION
)
public class TheGoat {

	public static final String MODID = "thegoat";
	public static final String NAME = "This mod... is THE GOAT";
	public static final String VERSION = "0.0.1";

	@SidedProxy(clientSide = "com.thegoat.proxy.ClientProxy", serverSide = "com.thegoat.proxy.ServerProxy")
	public static CommonProxy proxy;

	public static final ModCreativeTab modCreativeTab = new ModCreativeTab();
	
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	

	@Mod.EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		LOGGER.info("DONT WORRY! THE GOAT MOD IS HERE TO SAVE YOU!");
		proxy.preInit(event);
	}
	

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
		ModRecipes.init();

	}


	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);

	}
}
