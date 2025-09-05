package hr.goodapp.saljidaljeclient

import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

expect fun createPlatformEngine(): HttpClientEngineFactory<*>

fun provideHttpClient(): HttpClient = HttpClient(createPlatformEngine()) {
    install(ContentNegotiation) {
        json(Json {
            ignoreUnknownKeys = true
            encodeDefaults = true
        })
    }

    // optional defaults
    expectSuccess = true
    // configure timeouts, logging, default request etc. here if desired
}