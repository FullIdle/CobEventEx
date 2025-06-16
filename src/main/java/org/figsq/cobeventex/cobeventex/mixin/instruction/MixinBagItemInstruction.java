package org.figsq.cobeventex.cobeventex.mixin.instruction;

import com.cobblemon.mod.common.api.battles.model.PokemonBattle;
import com.cobblemon.mod.common.battles.interpreter.instructions.BagItemInstruction;
import org.figsq.cobeventex.cobeventex.api.bridge.IInstructionBridge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = BagItemInstruction.class, remap = false)
public abstract class MixinBagItemInstruction implements IInstructionBridge {
    @Inject(
            method = "invoke",
            at = @At("HEAD"),
            cancellable = true
    )
    public void invoke(PokemonBattle battle, CallbackInfo ci) {
        call(ci, battle);
    }
}
