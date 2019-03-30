package me.deftware.protocolhack.mixins;

import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraft {

    @Inject(method = "init", at = @At("RETURN"))
    private void init(CallbackInfo callbackInfo) {
        System.out.println("Minecraft 1.13 protocolhack to 1.13.1 now running");
    }

}
