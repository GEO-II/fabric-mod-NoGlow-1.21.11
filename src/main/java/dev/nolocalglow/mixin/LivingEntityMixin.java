package dev.nolocalglow.mixin;

import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @Inject(method = "isGlowing", at = @At("HEAD"), cancellable = true)
    private void nolocalglow$hideLivingEntityGlow(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }
}
