package io.github.staudlol.milk.command

import com.velocitypowered.api.command.CommandSource
import com.velocitypowered.api.command.SimpleCommand
import com.velocitypowered.api.proxy.ProxyServer
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer

class AlertCommand(private val server: ProxyServer) : SimpleCommand
{
    override fun execute(invocation: SimpleCommand.Invocation?)
    {
        val source: CommandSource = invocation!!.source()

        if (invocation.arguments().isEmpty())
        {
            source.sendMessage(
                Component.text("Usage: /alert <message>")
                    .color(NamedTextColor.RED));
            return
        }

        val message: String = invocation.arguments().joinToString(" ")
        val textComponent: Component = LegacyComponentSerializer
            .legacyAmpersand()
            .deserialize("&8[&4Alert&8] &r$message")

        server.sendMessage(textComponent)
    }

    override fun hasPermission(invocation: SimpleCommand.Invocation?): Boolean {
        return invocation!!.source().hasPermission("milk.command.alert")
    }
}