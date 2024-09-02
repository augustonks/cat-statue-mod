package com.thegoat.events;

import java.util.Random;

import com.thegoat.ai.EntityAvoidCatStatue;
import com.thegoat.items.ModItems;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class EventHandler {

    private static final Random RANDOM = new Random();


    @SubscribeEvent
    public static void onEntityJoinWorld(EntityJoinWorldEvent event) {
        if (event.getEntity() instanceof EntityCreeper) {
            EntityCreeper creeper = (EntityCreeper) event.getEntity();

            creeper.tasks.addTask(1, new EntityAvoidCatStatue(creeper, 6.0F, 1.0D, 1.2D));
            
        }
    }


    @SubscribeEvent
    public static void onLivingDrops(LivingDropsEvent event) {

        if (event.getEntity() instanceof EntityHorse) {
            EntityHorse horse = (EntityHorse) event.getEntity();
            int count = MathHelper.getInt(RANDOM, 1, 2); // Dropa de 1 até 2 carnes

            for (int i = 0; i < count; i++) {
                ItemStack stack = new ItemStack(ModItems.rawHorseMeat);
                EntityItem drop = new EntityItem(horse.getEntityWorld(), horse.posX, horse.posY, horse.posZ, stack);

                event.getDrops().add(drop);
            }
        }

        if (event.getEntity() instanceof EntityOcelot) {
            EntityOcelot cat = (EntityOcelot) event.getEntity();

            if (cat.isTamed()) {
                ItemStack stack = new ItemStack(ModItems.catHeart);
                EntityItem drop = new EntityItem(cat.getEntityWorld(), cat.posX, cat.posY, cat.posZ, stack);

                event.getDrops().add(drop);
            }


        }
    }
}
