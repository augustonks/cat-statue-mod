package com.thegoat.blocks;

import net.minecraft.block.material.Material;
import com.thegoat.TheGoat;

import net.minecraft.block.Block;

public class CoolBlock extends Block {

    public CoolBlock() {
        super(Material.ROCK);
        setRegistryName("coolblock");
        setTranslationKey(TheGoat.MODID + ".coolblock");
        setCreativeTab(TheGoat.modCreativeTab);
    }
}