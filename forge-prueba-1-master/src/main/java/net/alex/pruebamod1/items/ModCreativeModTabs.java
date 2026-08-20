package net.alex.pruebamod1.items;

import net.alex.pruebamod1.PruebaMOD1;
import net.alex.pruebamod1.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PruebaMOD1.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MINERALES_TAB = CREATIVE_MODE_TABS.register("mineral_tab",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(Moditems.ZAFIRO.get()))
                    .title(Component.translatable("creativetab.mineral_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(Moditems.ZAFIRO.get());
                        pOutput.accept(Moditems.PERIDOTITA.get());
                        pOutput.accept(Moditems.ZAFIRO_BRUTO.get());
                        pOutput.accept(Moditems.RUBI.get());
                        pOutput.accept(Moditems.PLATA_BRUTO.get());
                        pOutput.accept(Moditems.LINGOTE_PLATA.get());

                        pOutput.accept(Items.DIAMOND);

                        pOutput.accept(ModBlocks.BLOQUE_ZAFIRO.get());
                        pOutput.accept((ModBlocks.BLOQUE_RUBI.get()));
                        pOutput.accept((ModBlocks.BLOQUE_RUBI_CRUDO.get()));
                        pOutput.accept(ModBlocks.BLOQUE_PLATA_CRUDO.get());
                        pOutput.accept(ModBlocks.BLOQUE_PLATA.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
