package com.thegoat.items;

import com.thegoat.TheGoat;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraft.item.Item;

@Mod.EventBusSubscriber(modid = TheGoat.MODID)
public class ModItems {

    // FOOD
    @ObjectHolder(TheGoat.MODID + ":horse_meat")
    public static final HorseMeat horseMeat = null;

    @ObjectHolder(TheGoat.MODID + ":raw_horse_meat")
    public static final RawHorseMeat rawHorseMeat = null;

    @ObjectHolder(TheGoat.MODID + ":cat_heart")
    public static final CatHeart catHeart = null;

    @ObjectHolder(TheGoat.MODID + ":cooked_cat_heart")
    public static final CookedCatHeart cookedCatHeart = null;

    
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
            new HorseMeat(),
            new RawHorseMeat(),
            new CatHeart(),
            new CookedCatHeart()
        );
        System.out.println("Items foram registrados!");
    }
    
}
