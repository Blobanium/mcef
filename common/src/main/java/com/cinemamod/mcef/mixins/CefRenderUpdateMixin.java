package com.cinemamod.mcef.mixins;

import com.cinemamod.mcef.MCEF;
import net.minecraft.client.renderer.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class CefRenderUpdateMixin {
    @Inject(at = @At("HEAD"), method = "render")
    public void preRender(float partialTicks, long nanoTime, boolean renderLevel, CallbackInfo ci) {
        if (!MCEF.isInitialized()) return;

        MCEF.getApp().getHandle().N_DoMessageLoopWork();
    }
}
