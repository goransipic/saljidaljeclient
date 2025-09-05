package hr.goodapp.saljidaljeclient// jsMain/src/.../network/HttpClientFactoryJs.kt
import io.ktor.client.engine.js.*
import io.ktor.client.engine.*


actual fun createPlatformEngine(): HttpClientEngineFactory<*> = Js