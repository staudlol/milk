package io.github.staudlol.milk.util

import net.kyori.adventure.text.TextComponent
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer

object CC {

    /**
     * Translate a {@link String} to a {@link TextComponent}.
     *
     * @param string the string to translate.
     * @return the translated string.
     */

    fun translate(string: String): TextComponent {
        return LegacyComponentSerializer.legacyAmpersand().deserialize(string)
    }
}