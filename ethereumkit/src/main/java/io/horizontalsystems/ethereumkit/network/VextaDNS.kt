package io.horizontalsystems.ethereumkit.network

import okhttp3.Cache
import okhttp3.Dns
import okhttp3.OkHttpClient
import java.io.File
import java.net.InetAddress
import java.net.UnknownHostException
import java.util.concurrent.TimeUnit

class VextaDNS : Dns {
    override fun lookup(hostname: String): List<InetAddress> {
        try {
            val appCache = Cache(File("cacheDir", "okhttpcache"), 10 * 1024 * 1024)
            val bootstrapClient = OkHttpClient.Builder()
                .cache(appCache)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .dohCloudflare()
                .dohAdGuard()
                .dohGoogle()
                .build()
            return bootstrapClient.dns.lookup(hostname)
        } catch (e: NullPointerException) {
            throw UnknownHostException("Broken system behaviour for dns lookup of $hostname").apply {
                initCause(e)
            }
        }
    }
}