package org.figsq.cobeventex.cobeventex.mixin;

import com.cobblemon.mod.common.api.battles.model.PokemonBattle;
import com.cobblemon.mod.common.battles.dispatch.InterpreterInstruction;
import com.cobblemon.mod.common.battles.interpreter.instructions.*;
import org.figsq.cobeventex.cobeventex.events.BattleInstructionEvent;
import org.figsq.cobeventex.cobeventex.events.CobExEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = {
        AbilityInstruction.class,
        ActivateInstruction.class,
        BagItemInstruction.class,
        BlockInstruction.class,
        BoostInstruction.class,
        CantInstruction.class,
        CenterInstruction.class,
        ClearAllBoostInstruction.class,
        ClearBoostInstruction.class,
        ClearNegativeBoostInstruction.class,
        CopyBoostInstruction.class,
        CritInstruction.class,
        CureStatusInstruction.class,
        DamageInstruction.class,
        DragInstruction.class,
        EndAbilityInstruction.class,
        EndInstruction.class,
        EndItemInstruction.class,
        ErrorInstruction.class,
        FailInstruction.class,
        FaintInstruction.class,
        FieldActivateInstruction.class,
        FieldEndInstruction.class,
        FieldStartInstruction.class,
        FormeChangeInstruction.class,
        HealInstruction.class,
        HitCountInstruction.class,
        IgnoredInstruction.class,
        ImmuneInstruction.class,
        InitializeInstruction.class,
        InvertBoostInstruction.class,
        ItemInstruction.class,
        MegaInstruction.class,
        MissInstruction.class,
        MoveInstruction.class,
        NothingInstruction.class,
        PpUpdateInstruction.class,
        PrepareInstruction.class,
        RechargeInstruction.class,
        ReplaceInstruction.class,
        RequestInstruction.class,
        ResistedInstruction.class,
        SetBoostInstruction.class,
        SetHpInstruction.class,
        SideEndInstruction.class,
        SideStartInstruction.class,
        SingleMoveInstruction.class,
        SingleTurnInstruction.class,
        StartInstruction.class,
        StatusInstruction.class,
        SuperEffectiveInstruction.class,
        SwapBoostInstruction.class,
        SwapInstruction.class,
        SwapSideConditionsInstruction.class,
        SwitchInstruction.class,
        TerastallizeInstruction.class,
        TransformInstruction.class,
        TurnInstruction.class,
        UnknownInstruction.class,
        UpkeepInstruction.class,
        WeatherInstruction.class,
        WinInstruction.class,
        ZBrokenInstruction.class,
        ZPowerInstruction.class,
}, remap = false)
public abstract class MixinInstruction implements InterpreterInstruction {
    @Inject(
            method = "invoke",
            at = @At("HEAD"),
            cancellable = true
    )
    public void invoke(PokemonBattle battle, CallbackInfo ci) {
        CobExEvents.cancelablePostThen(ci, CobExEvents.BATTLE_INSTRUCTION, new BattleInstructionEvent(battle, this));
    }
}
