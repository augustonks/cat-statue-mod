package com.thegoat.recipes;

import com.thegoat.items.ModItems;
import net.minecraft.item.ItemStack;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
    public static void init() {
        GameRegistry.addSmelting(new ItemStack(ModItems.rawHorseMeat), new ItemStack(ModItems.horseMeat), 100);
        GameRegistry.addSmelting(new ItemStack(ModItems.catHeart), new ItemStack(ModItems.cookedCatHeart), 100);
    }

}
