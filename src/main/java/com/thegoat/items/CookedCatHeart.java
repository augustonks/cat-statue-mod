package com.thegoat.items;

import com.thegoat.TheGoat;

import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.PotionEffect;

public class CookedCatHeart extends ItemFood {
    public CookedCatHeart() {
        super(2, .2F, true);
        setRegistryName(TheGoat.MODID, "cooked_cat_heart");
        setTranslationKey(TheGoat.MODID + ".cooked_cat_heart");
        setCreativeTab(TheGoat.modCreativeTab);
        setPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 300, 0), 0.9F);
    }
}
