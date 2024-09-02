package com.thegoat.blocks;

import com.thegoat.TheGoat;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;


@Mod.EventBusSubscriber(modid = TheGoat.MODID)
public class ModBlocks {

        @ObjectHolder(TheGoat.MODID + ":coolblock")
        public static final CoolBlock coolBlock = null;

        @ObjectHolder(TheGoat.MODID + ":cat_statue")
        public static final CatStatue catStatue = null;


        @SubscribeEvent
        public static void registerBlock(RegistryEvent.Register<Block> event) {
                event.getRegistry().register(new CoolBlock());
                event.getRegistry().register(new CatStatue());
        }


        @SubscribeEvent
        public static void registerItemBlock(RegistryEvent.Register<Item> event) {
                event.getRegistry().register(new ItemBlock(ModBlocks.coolBlock).setRegistryName(ModBlocks.coolBlock.getRegistryName()));
                event.getRegistry().register(new ItemBlock(ModBlocks.catStatue).setRegistryName(ModBlocks.catStatue.getRegistryName()));
        }
}
