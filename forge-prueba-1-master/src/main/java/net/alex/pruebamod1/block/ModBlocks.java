package net.alex.pruebamod1.block;

import net.alex.pruebamod1.PruebaMOD1;
import net.alex.pruebamod1.items.Moditems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    //Registro diferido de bloques
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, PruebaMOD1.MOD_ID);

    //registros de los nuevos bloques agregaos
    public static final RegistryObject<Block> BLOQUE_ZAFIRO = registerBlock("bloque_zafiro",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> BLOQUE_RUBI = registerBlock("bloque_rubi",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST_CLUSTER)));

    public static final RegistryObject<Block> BLOQUE_RUBI_CRUDO = registerBlock("bloque_rubi_crudo",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2f).
                    sound(SoundType.CALCITE).requiresCorrectToolForDrops(), UniformInt.of(3,6)));

    public static final RegistryObject<Block> BLOQUE_PLATA_CRUDO = registerBlock("bloque_plata_crudo",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2f).
                    sound(SoundType.NETHER_GOLD_ORE).requiresCorrectToolForDrops(), UniformInt.of(3,6)));

    public static final RegistryObject<Block> BLOQUE_PLATA = registerBlock("bloque_plata",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.COPPER)));

    //métodos para agregar el bloque
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> paraRetornar = BLOCKS.register(name, block);
        registerBlockItem(name, paraRetornar);
        return paraRetornar;
    }

    //método que registra el item en el java class "Moditems"
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return Moditems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    //Lista vacía de bloques que registran los nuevos bloques
    public static void register (IEventBus eventBus) {
        BLOCKS.register (eventBus);
    }
}
