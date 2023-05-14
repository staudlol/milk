package io.github.staudlol.milk

import com.google.inject.Inject
import com.velocitypowered.api.command.CommandManager
import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.plugin.Plugin
import com.velocitypowered.api.proxy.ProxyServer
import io.github.staudlol.milk.command.AlertCommand
import java.util.logging.Logger

@Plugin(
    id = "milk-proxy",
    name = "milk",
    version = "1.0.0",
    description = "A proxy plugin for Velocity.",
    authors = ["Staud"]
)
class MilkSpigotPlugin @Inject constructor(

    private val server: ProxyServer,
    private val logger: Logger,
    private val commandManager: CommandManager
) {

    @Subscribe
    fun onProxyInitialization()
    {
        logger.info("Milk has been initialized.")

        commandManager.register("alert", AlertCommand(server))
    }
}