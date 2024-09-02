package com.thegoat.proxy;

import com.thegoat.TheGoat;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

import com.thegoat.blocks.ModBlocks;
import com.thegoat.items.ModItems;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;


@EventBusSubscriber(modid = TheGoat.MODID, value = Side.CLIENT)
public class ClientProxy extends CommonProxy{

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
    }

    // Todos os modelos dos items são registrados aqui (função não chamada em nenhum outro lugar)
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        System.out.println("Registrando modelos...");
        registerModel(Item.getItemFromBlock(ModBlocks.coolBlock), 0);
        registerModel(Item.getItemFromBlock(ModBlocks.catStatue), 0);

        registerModel(ModItems.horseMeat, 0);
        registerModel(ModItems.rawHorseMeat, 0);
        registerModel(ModItems.catHeart, 0);
        registerModel(ModItems.cookedCatHeart, 0);
    }
        
    private static void registerModel(Item item, int meta) {
        // Esse cheque serve para garantir que o registry name nunca seja nulo
        if (item == null) {
            System.out.println("Tentou registrar item nulo");
            return;
        }

            ResourceLocation registryName = item.getRegistryName();

            if (registryName != null) 
            {
                System.out.println("Tentando registar: " + registryName.toString());
                ModelLoader.setCustomModelResourceLocation(item, meta,
                new ModelResourceLocation(registryName, "inventory"));

                String formatted = String.format("Modelo do item '%s' foi registrado com sucesso!", registryName);
                System.out.println(formatted);
            } else {
                System.out.println("Erro: item.registryName() retornou null.");
            }

    }}
