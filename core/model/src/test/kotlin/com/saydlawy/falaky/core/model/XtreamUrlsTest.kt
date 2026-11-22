package com.saydlawy.falaky.core.model

import org.junit.Assert.assertEquals
import org.junit.Test

class XtreamUrlsTest {
    @Test
    fun normalizeAddsSchemeAndStripsSlash() {
        assertEquals("http://example.com:8080", XtreamUrls.normalizeBase(" example.com:8080/ "))
        assertEquals("https://example.com", XtreamUrls.normalizeBase("https://example.com/"))
    }

    @Test
    fun playerApiWithAndWithoutAction() {
        assertEquals("http://h/player_api.php?username=u&password=p", XtreamUrls.playerApi("h", "u", "p"))
        assertEquals(
            "http://h/player_api.php?username=u&password=p&action=get_live_streams",
            XtreamUrls.playerApi("h", "u", "p", "get_live_streams"),
        )
    }

    @Test
    fun liveStreamUrl() {
        assertEquals("http://h/live/u/p/42.m3u8", XtreamUrls.liveStream("h", "u", "p", 42))
    }
}
