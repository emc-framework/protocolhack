package me.deftware.protocolhack.mixins;

import me.deftware.protocolhack.imp.IMixinGuiScreen;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(GuiScreen.class)
public abstract class MixinGuiScreen implements IMixinGuiScreen {

    @Shadow
    protected abstract <T extends GuiButton> T addButton(T p_addButton_1_);

    @Override
    public void addGuiButtonToList(GuiButton button) {
        addButton(button);
    }

}
