package me.deftware.protocolhack.mixins;

import me.deftware.protocolhack.Constants;
import me.deftware.protocolhack.imp.IMixinGuiScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreen;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiMultiplayer.class)
public abstract class MixinGuiMultiplayer {

    @Shadow
    @Final
    private GuiScreen parentScreen;

    @Inject(method = "createButtons", at = @At("RETURN"))
    public void createButtons(CallbackInfo ci) {
        IMixinGuiScreen screen = (IMixinGuiScreen) (GuiMultiplayer) (Object) this;
        screen.addGuiButtonToList(new GuiButton(200, 5,5, 70, 20, Constants.Support113 ? "1.13.1" : "1.13") {
            public void mouseClicked(double p_mouseClicked_1_, double p_mouseClicked_3_) {
                Constants.Support113 = !Constants.Support113;
                Minecraft.getMinecraft().displayGuiScreen(new GuiMultiplayer(parentScreen));
            }
        });
    }

    @Inject(method = "drawScreen", at = @At("RETURN"))
    public void drawScreen(int p_drawScreen_1_, int p_drawScreen_2_, float p_drawScreen_3_, CallbackInfo ci) {
        Minecraft.getMinecraft().fontRenderer.drawStringWithShadow("<- Change version", 80, 10, 0xFFFFFF);
    }

}
