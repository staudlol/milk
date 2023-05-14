package io.github.staudlol.milk.command.staffchat

import com.velocitypowered.api.command.SimpleCommand
import com.velocitypowered.api.proxy.Player
import com.velocitypowered.api.proxy.ProxyServer
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer

class StaffChatCommand(private val server: ProxyServer) : SimpleCommand
{
    override fun execute(invocation: SimpleCommand.Invocation?)
    {
        val source = invocation!!.source()

        if (invocation.arguments().isEmpty())
        {
            source.sendMessage(
                Component.text("Usage: /staffchat <message>")
                    .color(NamedTextColor.RED));
            return
        }

        val playerName: String = if (source is Player) source.username else "Console"

        val message = invocation.arguments().joinToString(" ")
        val textComponent: Component = LegacyComponentSerializer
            .legacyAmpersand()
            .deserialize("&3[Staff] &e${playerName} &8» &f$message")

        server.sendMessage(textComponent)
    }

    override fun hasPermission(invocation: SimpleCommand.Invocation?): Boolean {
        return invocation!!.source().hasPermission("milk.command.staffchat")
    }
}