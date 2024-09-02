package com.thegoat.blocks;

import com.thegoat.TheGoat;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CatStatue extends Block{

    public static final PropertyDirection FACING = BlockHorizontal.FACING;

    public CatStatue() {
        super(Material.ROCK);
        setRegistryName("cat_statue");
        setTranslationKey(TheGoat.MODID + ".cat_statue");
        setCreativeTab(TheGoat.modCreativeTab);
    }

    @SuppressWarnings("null")
    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        if (worldIn == null || pos == null || state == null || placer == null) {
            System.out.println("Tentou colocar bloco com parâmetros nulos");
        }
        EnumFacing facing = placer.getHorizontalFacing().getOpposite();
        worldIn.setBlockState(pos, state.withProperty(FACING, facing));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.byHorizontalIndex(meta & 3));
    }

    @SuppressWarnings("null")
    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getHorizontalIndex();
    }



}
