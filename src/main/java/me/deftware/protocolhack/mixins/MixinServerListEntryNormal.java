package me.deftware.protocolhack.mixins;

import me.deftware.protocolhack.Constants;
import net.minecraft.client.gui.ServerListEntryNormal;
import net.minecraft.client.multiplayer.ServerData;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import static org.spongepowered.asm.lib.Opcodes.GETFIELD;

@Mixin(ServerListEntryNormal.class)
public class MixinServerListEntryNormal {

    @Shadow
    @Final
    private ServerData server;

    @Redirect(method = "func_194999_a", at = @At(value =  "FIELD", target = "Lnet/minecraft/client/multiplayer/ServerData;version:I", opcode = GETFIELD))
    public int getProtocolVersion(ServerData self) {
        int version = server.version;
        if (version == Constants.ProtocolVersion && Constants.Support113) {
            version = 393;
        }
        return version;
    }

}
