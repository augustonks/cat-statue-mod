package com.thegoat.items;

import com.thegoat.TheGoat;

import net.minecraft.item.ItemFood;

public class RawHorseMeat extends ItemFood {

    public RawHorseMeat() {
        super(6, .6F, true);
        setRegistryName("raw_horse_meat");
        setTranslationKey(TheGoat.MODID + ".raw_horse_meat");
        setCreativeTab(TheGoat.modCreativeTab);
    }
    
}
