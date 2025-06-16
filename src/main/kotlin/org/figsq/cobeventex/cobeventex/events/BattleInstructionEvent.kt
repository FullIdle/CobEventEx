package org.figsq.cobeventex.cobeventex.events

import com.cobblemon.mod.common.api.battles.model.PokemonBattle
import com.cobblemon.mod.common.api.events.Cancelable
import com.cobblemon.mod.common.battles.dispatch.InterpreterInstruction

/**
 * 对战指令事件
 * ```
 * //判断是什么指令
 * interpreterInstruction is MoveInstruction
 * ```
 * 可触发的事件的指令请移至参考包内的mixin类
 * 每个指令的意思请更具 `cobblemon` 的注释来理解
 * 每种动作的取消效果请自行测试
 * @param battle 目标对局
 * @param interpreterInstruction 指令
 * @see [org.figsq.cobeventex.cobeventex.mixin.instruction]
 */
class BattleInstructionEvent(
    val battle: PokemonBattle,
    val interpreterInstruction: InterpreterInstruction
) : Cancelable()
