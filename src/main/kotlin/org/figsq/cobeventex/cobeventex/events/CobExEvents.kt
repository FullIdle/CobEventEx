package org.figsq.cobeventex.cobeventex.events

import com.cobblemon.mod.common.api.events.Cancelable
import com.cobblemon.mod.common.api.reactive.CancelableObservable
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo

object CobExEvents {
    /**
     * 完成交易前事件
     */
    @JvmField
    val PRE_TRADE_COMPLETE = CancelableObservable<PreTradeCompleteEvent>()

    /**
     * 开始交易前事件
     */
    @JvmField
    val START_TRADING = CancelableObservable<StartTradingEvent>()

    /**
     * 对战指令实现 (比如选择技能等大部分指令)
     */
    @JvmField
    val BATTLE_INSTRUCTION = CancelableObservable<BattleInstructionEvent>()


    /**
     * 分辨mixin中触发可取消事件
     */
    @JvmStatic
    fun <T : Cancelable> cancelablePostThen(ci: CallbackInfo, co: CancelableObservable<T>, event: T) {
        co.postThen(event, { ci.cancel() }, {})
    }
}