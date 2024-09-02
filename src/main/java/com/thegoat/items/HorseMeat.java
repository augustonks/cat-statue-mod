package com.thegoat.items;

import com.thegoat.TheGoat;

import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.PotionEffect;

public class HorseMeat extends ItemFood {

    public HorseMeat() {
        super(6, .6F, true);
        setAlwaysEdible();
        setRegistryName(TheGoat.MODID, "horse_meat");
        setTranslationKey(TheGoat.MODID + ".horse_meat");
        setCreativeTab(TheGoat.modCreativeTab);
        setPotionEffect(new PotionEffect(MobEffects.SPEED, 300, 0), 1.0F);
    }
    
}
