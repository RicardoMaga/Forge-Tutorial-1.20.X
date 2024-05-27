package net.ricardo.tutorialmod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ricardo.tutorialmod.TutorialMod;
import net.ricardo.tutorialmod.item.custom.Fuelitem;
import net.ricardo.tutorialmod.item.custom.MetalDetectorItem;


// Registar um novo item
public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_SAPPHIRE = ITEMS.register("raw_sapphire",
            () -> new Item(new Item.Properties()));


    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100)));


    //Comida
    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry",
            () -> new Item(new Item.Properties().food(ModFoods.STRAWBERRY)));


    //Combustivel / Fornalha
    public static final RegistryObject<Item> PINE_CONE = ITEMS.register("pine_cone",
            () -> new Fuelitem(new Item.Properties(),400));


    public static void register(IEventBus eventBus) {ITEMS.register(eventBus);

    }
}
