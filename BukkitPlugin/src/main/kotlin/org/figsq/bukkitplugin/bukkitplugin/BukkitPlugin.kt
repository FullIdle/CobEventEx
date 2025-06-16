package org.figsq.bukkitplugin.bukkitplugin

import org.bukkit.plugin.java.JavaPlugin

class BukkitPlugin : JavaPlugin() {
    override fun onEnable() {
        KotlinExListener.register()
        JavaExListener.INSTANCE.register()
        logger.info("BukkitPlugin has been enabled!")
    }

    override fun onDisable() {
        logger.info("BukkitPlugin has been disabled!")
    }
}
