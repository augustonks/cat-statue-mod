package com.thegoat.items;

import com.thegoat.TheGoat;

import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.PotionEffect;

public class CatHeart extends ItemFood {

    public CatHeart() {
        super(1, .05F, true);
        setRegistryName(TheGoat.MODID, "cat_heart");
        setTranslationKey(TheGoat.MODID + ".cat_heart");
        setCreativeTab(TheGoat.modCreativeTab);
        setPotionEffect(new PotionEffect(MobEffects.HUNGER, 300, 0), 0.9F);
    }
}
