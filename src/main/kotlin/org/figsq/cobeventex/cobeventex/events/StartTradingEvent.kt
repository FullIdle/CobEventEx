package org.figsq.cobeventex.cobeventex.events

import com.cobblemon.mod.common.api.events.Cancelable
import com.cobblemon.mod.common.trade.TradeManager

/**
 * 开始(交易/交换)事件
 * [cancel] 取消事件，事件取消后,交易将直接取消
 * @param tradeRequest 交易请求 包含了请求玩家和接收玩家
 */
class StartTradingEvent(
    val tradeRequest: TradeManager.TradeRequest
) : Cancelable()
