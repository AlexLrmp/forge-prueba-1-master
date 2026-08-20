package net.alex.pruebamod1.items;

import net.alex.pruebamod1.PruebaMOD1;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Moditems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PruebaMOD1.MOD_ID);

    public static final RegistryObject<Item> ZAFIRO = ITEMS.register("zafiro",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PERIDOTITA = ITEMS.register("peridotita",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ZAFIRO_BRUTO = ITEMS.register("zafiro_bruto",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RUBI = ITEMS.register("rubi",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PLATA_BRUTO = ITEMS.register("plata_bruto",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LINGOTE_PLATA = ITEMS.register("lingote_plata",
            () -> new Item(new Item.Properties()));

    public static void  register (IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
