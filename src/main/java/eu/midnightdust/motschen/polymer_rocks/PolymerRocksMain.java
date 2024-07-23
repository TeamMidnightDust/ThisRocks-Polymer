package eu.midnightdust.motschen.polymer_rocks;

import eu.midnightdust.motschen.polymer_rocks.block.ItemDisplayNetherGeyserModel;
import eu.midnightdust.motschen.polymer_rocks.block.ItemDisplayOverworldGeyserModel;
import eu.midnightdust.motschen.polymer_rocks.block.ItemDisplayPineconeModel;
import eu.midnightdust.motschen.polymer_rocks.block.ItemDisplayRockModel;
import eu.midnightdust.motschen.polymer_rocks.block.ItemDisplaySeashellModel;
import eu.midnightdust.motschen.polymer_rocks.block.ItemDisplayStarfishModel;
import eu.midnightdust.motschen.polymer_rocks.block.ItemDisplayStickModel;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

import static eu.midnightdust.motschen.rocks.RocksMain.MOD_ID;

public class PolymerRocksMain implements ModInitializer {

    public void onInitialize() {
        PolymerResourcePackUtils.addModAssets(MOD_ID);
        PolymerResourcePackUtils.addModAssets("polymer-rocks");

        ItemDisplayNetherGeyserModel.initModels();
        ItemDisplayOverworldGeyserModel.initModels();
        ItemDisplayPineconeModel.initModels();
        ItemDisplayRockModel.initModels();
        ItemDisplaySeashellModel.initModels();
        ItemDisplayStarfishModel.initModels();
        ItemDisplayStickModel.initModels();
    }
    public static Identifier id(String path) {
        return Identifier.of("polymer-rocks", path);
    }
}
