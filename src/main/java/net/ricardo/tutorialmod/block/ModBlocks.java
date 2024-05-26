package net.ricardo.tutorialmod.block;


import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ricardo.tutorialmod.TutorialMod;
import net.ricardo.tutorialmod.item.ModItems;

import javax.swing.plaf.PanelUI;
import java.util.function.Supplier;


//registar um bloco novo
public class ModBlocks {
       public static final DeferredRegister<Block> BLOCKS =
               DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

       public static final RegistryObject<Block> SAPPHIRE_ORE = registerBlock("sapphire_ore",
             () -> new DropExperienceBlock( BlockBehaviour.Properties.copy(Blocks.STONE)
                       .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(10,11)));
       public static final RegistryObject<Block> DEEPSLATE_SAPPHIRE_ORE = registerBlock("deepslate_sapphire_ore",
            () -> new DropExperienceBlock( BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(10,11)));
       public static final RegistryObject<Block> NETHER_SAPPHIRE_ORE = registerBlock("nether_sapphire_ore",
            () -> new DropExperienceBlock( BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(10,11)));
       public static final RegistryObject<Block> END_STONE_SAPPHIRE_ORE = registerBlock("end_stone_sapphire_ore",
            () -> new DropExperienceBlock( BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(10000,11000)));

       //copiar codigo e mudar os campos
       public static final  RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block",
               () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

       public static final RegistryObject<Block> RAW_SAPPHIRE_BLOCK = registerBlock("raw_sapphire_block",
               () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK).sound(SoundType.AMETHYST)));

       private  static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
           RegistryObject<T> toReturn = BLOCKS.register(name, block);
           registerBlockItem(name, toReturn);
           return toReturn;
       }

       private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
           return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
       }

       public static void register(IEventBus eventBus) {
           BLOCKS.register(eventBus);
       }

}

