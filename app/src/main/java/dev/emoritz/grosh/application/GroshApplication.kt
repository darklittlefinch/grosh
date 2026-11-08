package dev.emoritz.grosh.application

import android.app.Application
import dev.emoritz.grosh.di.apiServiceModule
import dev.emoritz.grosh.di.modelsModule
import dev.emoritz.grosh.di.repositoriesModule
import dev.emoritz.grosh.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Initializes the application dependency container.
 */
class GroshApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initializeKoin()
    }

    private fun initializeKoin() {
        startKoin {
            androidContext(this@GroshApplication)
            modules(repositoriesModule, modelsModule, viewModelsModule, apiServiceModule)
        }
    }
}
