package org.figsq.cobeventex.cobeventex.mixin;

import com.cobblemon.mod.common.pokemon.Pokemon;
import com.cobblemon.mod.common.trade.TradeManager;
import com.cobblemon.mod.common.trade.TradeParticipant;
import org.figsq.cobeventex.cobeventex.events.CobExEvents;
import org.figsq.cobeventex.cobeventex.events.PreTradeCompleteEvent;
import org.figsq.cobeventex.cobeventex.events.StartTradingEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = TradeManager.class, remap = false)
public class MixinTradeManager {
    @Inject(
            method = "performTrade",
            at = @At("HEAD"),
            cancellable = true,
            remap = false
    )
    private void performTrade(TradeParticipant player1, Pokemon pokemon1, TradeParticipant player2, Pokemon pokemon2, CallbackInfo ci) {
        CobExEvents.cancelablePostThen(ci, CobExEvents.PRE_TRADE_COMPLETE, new PreTradeCompleteEvent(player1, pokemon1, player2, pokemon2));
    }

    @Inject(
            method = "onAccept(Lcom/cobblemon/mod/common/trade/TradeManager$TradeRequest;)V",
            at = @At("HEAD"),
            cancellable = true
    )
    private void onAccept(TradeManager.TradeRequest request, CallbackInfo ci) {
        CobExEvents.cancelablePostThen(ci, CobExEvents.START_TRADING, new StartTradingEvent(request));
    }
}
