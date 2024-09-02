package com.thegoat.proxy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.thegoat.TheGoat;


import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@EventBusSubscriber(modid = TheGoat.MODID)
public class CommonProxy {

    public static final Logger LOGGER = LogManager.getLogger(TheGoat.MODID);


    public void preInit(FMLPreInitializationEvent event) {
        
    }

    public void init(FMLInitializationEvent event) {
        
    }

    public void postInit(FMLPostInitializationEvent event) {
        
    }
}
