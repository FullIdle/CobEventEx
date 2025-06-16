package org.figsq.bukkitplugin.bukkitplugin

import com.cobblemon.mod.common.api.reactive.ObservableSubscription
import org.figsq.cobeventex.cobeventex.events.CobExEvents


/**
 * kotlin实例
 */
object KotlinExListener: ExListener {
    @JvmStatic
    private val registered = mutableListOf<ObservableSubscription<*>>()

    override fun register() {
        CobExEvents.START_TRADING.subscribe {
            println("[Kotlin]: Trading started!")
        }
        CobExEvents.PRE_TRADE_COMPLETE.subscribe {
            println("[Kotlin]: Trade complete! (Triggered before the transaction is completed!)")
        }
        CobExEvents.BATTLE_INSTRUCTION.subscribe {
            println("[Kotlin]: Battle instruction received! type>> ${it.interpreterInstruction.javaClass}")
        }
    }

    override fun unregister() {
        registered.forEach { it.unsubscribe() }
        registered.clear()
    }
}
