package com.saydlawy.falaky.core.model

/** Builds Xtream Codes URLs. Pure Kotlin so it is unit tested on the JVM. */
object XtreamUrls {
    fun normalizeBase(server: String): String {
        val trimmed = server.trim().trimEnd('/')
        return if (trimmed.startsWith("http://") || trimmed.startsWith("https://")) trimmed else "http://$trimmed"
    }

    fun playerApi(server: String, username: String, password: String, action: String? = null): String {
        val base = normalizeBase(server)
        val query = buildString {
            append("username=").append(username)
            append("&password=").append(password)
            if (action != null) append("&action=").append(action)
        }
        return "$base/player_api.php?$query"
    }

    fun liveStream(server: String, username: String, password: String, streamId: Long, ext: String = "m3u8"): String =
        "${normalizeBase(server)}/live/$username/$password/$streamId.$ext"
}
