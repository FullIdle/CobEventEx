package org.figsq.cobeventex.cobeventex.api.bridge;

import com.cobblemon.mod.common.api.battles.model.PokemonBattle;
import com.cobblemon.mod.common.battles.dispatch.InterpreterInstruction;
import org.figsq.cobeventex.cobeventex.events.BattleInstructionEvent;
import org.figsq.cobeventex.cobeventex.events.CobExEvents;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public interface IInstructionBridge extends InterpreterInstruction {
    default void call(CallbackInfo ci, PokemonBattle battle) {
        CobExEvents.cancelablePostThen(ci, CobExEvents.BATTLE_INSTRUCTION, new BattleInstructionEvent(battle, this));
    }
}
