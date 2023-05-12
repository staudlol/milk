package io.github.staudlol.milk

import com.google.inject.Inject
import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.plugin.Plugin
import com.velocitypowered.api.proxy.ProxyServer
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
    private val logger: Logger
) {

    @Subscribe
    fun onProxyInitialization() {
        logger.info("Milk has been initialized.")
    }
}