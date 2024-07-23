package eu.midnightdust.motschen.polymer_rocks;

import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

import static eu.midnightdust.motschen.rocks.RocksMain.MOD_ID;

public class PolymerRocksMain implements ModInitializer {
    public void onInitialize() {
        PolymerResourcePackUtils.addModAssets(MOD_ID);
        PolymerResourcePackUtils.addModAssets("polymer-rocks");
    }
    public static Identifier rocks(String path) {
        return Identifier.of(MOD_ID, path);
    }
    public static Identifier id(String path) {
        return Identifier.of("polymer-rocks", path);
    }
}
