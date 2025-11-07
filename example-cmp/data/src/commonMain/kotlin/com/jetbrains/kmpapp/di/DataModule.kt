package com.jetbrains.kmpapp.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan("com.jetbrains.kmpapp.data")
//TODO use @Configuration once KSP is fixed - else use KSP 2.1.20 - 1.0.28
class DataModule {

    @Single
    fun json() = Json { ignoreUnknownKeys = true }

    @Single
    fun httpClient(json: Json) = HttpClient {
        install(ContentNegotiation) {
            json(json, contentType = ContentType.Any)
        }
    }
}