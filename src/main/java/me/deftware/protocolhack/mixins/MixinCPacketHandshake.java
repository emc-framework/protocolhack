package me.deftware.protocolhack.mixins;

import me.deftware.protocolhack.Constants;
import net.minecraft.network.handshake.client.CPacketHandshake;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CPacketHandshake.class)
public class MixinCPacketHandshake {

    @Shadow
    private int protocolVersion;

    @Inject(method = "<init>*", at = @At("RETURN"))
    private void onConstructed(CallbackInfo ci) {
        if (Constants.Support113) {
            protocolVersion = Constants.ProtocolVersion;
        }
    }

    @Overwrite
    public int getProtocolVersion() {
        if (protocolVersion == Constants.ProtocolVersion && Constants.Support113) {
            return 393;
        }
        return protocolVersion;
    }

}
