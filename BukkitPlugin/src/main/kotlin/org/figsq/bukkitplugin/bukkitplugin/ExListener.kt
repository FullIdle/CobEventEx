package org.figsq.bukkitplugin.bukkitplugin

/**
 * 不一定得用这个接口，这只是一个实例
 */
interface ExListener {
    /**
     * 注册监听器 找个合适的位置注册 推荐 [org.bukkit.plugin.java.JavaPlugin.onEnable]
     */
    fun register()
    /**
     * 注销监听器 用在 [org.bukkit.plugin.java.JavaPlugin.onDisable]
     */
    fun unregister()
}
