package org.figsq.cobeventex.cobeventex.events

import com.cobblemon.mod.common.api.events.Cancelable
import com.cobblemon.mod.common.pokemon.Pokemon
import com.cobblemon.mod.common.trade.TradeParticipant

/**
 * 该事件交易前触发
 * [cancel] 取消该事件则会交易失败，但交易界面的动画还是会播放完
 * 可以在取消事件后关闭容器，来中断动画 [net.minecraft.world.entity.player.Player.closeContainer]
 * @param tradeParticipant1 交易方1
 * @param tradeParticipant1Pokemon 交易方1选择宝可梦
 * @param tradeParticipant2 交易方2
 * @param tradeParticipant2Pokemon 交易方2选择宝可梦
 */
class PreTradeCompleteEvent(
    val tradeParticipant1: TradeParticipant,
    val tradeParticipant1Pokemon: Pokemon,
    val tradeParticipant2: TradeParticipant,
    val tradeParticipant2Pokemon: Pokemon
) : Cancelable()