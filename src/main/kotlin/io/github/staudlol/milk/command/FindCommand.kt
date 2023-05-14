package io.github.staudlol.milk.command

import com.velocitypowered.api.command.CommandSource
import com.velocitypowered.api.command.SimpleCommand
import com.velocitypowered.api.proxy.Player
import com.velocitypowered.api.proxy.ProxyServer
import io.github.staudlol.milk.util.CC
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import java.util.*

class FindCommand(private val server: ProxyServer) : SimpleCommand
{
    override fun execute(invocation: SimpleCommand.Invocation?)
    {
        val source: CommandSource = invocation!!.source()

        if (invocation.arguments().isEmpty())
        {
            source.sendMessage(
                Component.text("Usage: /find <player>")
                    .color(NamedTextColor.RED));
            return
        }

        val player: Optional<Player>? = server.getPlayer(invocation.arguments()[0])

        if (!player!!.isPresent)
        {
            source.sendMessage(
                Component.text("Player not found.")
                    .color(NamedTextColor.RED));
            return
        }

        source.sendMessage(CC.translate("&b${player.get().username} &fis on &a${player.get().currentServer.get().serverInfo.name}"))
    }

    override fun hasPermission(invocation: SimpleCommand.Invocation?): Boolean {
        return invocation!!.source().hasPermission("milk.command.find")
    }
}