package eu.midnightdust.motschen.polymer_rocks.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import eu.midnightdust.motschen.rocks.RocksMain;
import eu.pb4.factorytools.api.item.ModeledItem;
import eu.pb4.polymer.core.api.item.PolymerItemGroupUtils;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

import static eu.midnightdust.motschen.rocks.RocksMain.Rock;

@Mixin(value = RocksMain.class, remap = false)
public class MixinRocksMain {

    @Shadow public static ItemGroup RocksGroup;
    @Shadow public static List<ItemStack> groupItems;

    @WrapMethod(method = "simpleItem")
    private static Item simplePolymerItem(Operation<Item> original) {
        return new ModeledItem(Items.FLINT, new Item.Settings());
    }

    @Inject(method = "registerItemGroup", at = @At("HEAD"), cancellable = true)
    private static void registerPolymerGroup(CallbackInfo ci) {
        RocksGroup = PolymerItemGroupUtils.builder().displayName(Text.translatable("itemGroup.rocks.rocks")).icon(() -> new ItemStack(Rock)).entries((displayContext, entries) -> entries.addAll(groupItems)).build();
        PolymerItemGroupUtils.registerPolymerItemGroup(Identifier.of("rocks", "rocks"), RocksGroup);
        ci.cancel();
    }
}
