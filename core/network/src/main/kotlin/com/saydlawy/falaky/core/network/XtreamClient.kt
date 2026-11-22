package com.saydlawy.falaky.core.network

/** Stage 2 fills this in (Xtream login, categories, streams). UI depends on this interface, not on HTTP. */
interface XtreamClient {
    suspend fun authenticate(server: String, username: String, password: String): Boolean
}
