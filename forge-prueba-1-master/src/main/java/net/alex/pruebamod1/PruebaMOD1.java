package net.alex.pruebamod1;

import com.mojang.logging.LogUtils;
import net.alex.pruebamod1.block.ModBlocks;
import net.alex.pruebamod1.items.ModCreativeModTabs;
import net.alex.pruebamod1.items.Moditems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(PruebaMOD1.MOD_ID)
public class PruebaMOD1
{
    public static final String MOD_ID = "pruebamod1";
    private static final Logger LOGGER = LogUtils.getLogger();

    public PruebaMOD1(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        //para la creación de la pestaña del modo crativo
        ModCreativeModTabs.register(modEventBus);

        //para registrar todos los items que se vayan agregando al juego
        Moditems.register(modEventBus);

        //para registrar todos los bloques que se vayan creando dentro de MODBLOCKS
        ModBlocks.register((modEventBus));


        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(Moditems.ZAFIRO);
            event.accept(Moditems.PERIDOTITA);
            event.accept(Moditems.ZAFIRO_BRUTO);
            event.accept(Moditems.RUBI);
            event.accept(Moditems.LINGOTE_PLATA);
            event.accept(Moditems.PLATA_BRUTO);
        }

        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept((ModBlocks.BLOQUE_RUBI));
            event.accept(ModBlocks.BLOQUE_ZAFIRO);
            event.accept(ModBlocks.BLOQUE_RUBI_CRUDO);
            event.accept(ModBlocks.BLOQUE_PLATA_CRUDO);
            event.accept(ModBlocks.BLOQUE_PLATA);
            event.accept(ModBlocks.BLOQUE_PLATA_CRUDO);
        }
    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}
