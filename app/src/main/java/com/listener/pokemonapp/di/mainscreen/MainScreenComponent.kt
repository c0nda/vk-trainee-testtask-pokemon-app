package com.listener.pokemonapp.di.mainscreen

import com.listener.pokemonapp.DI
import com.listener.pokemonapp.di.app.NetworkModule
import com.listener.pokemonapp.di.app.RepositoryModule
import com.listener.pokemonapp.di.app.UseCaseModule
import com.listener.pokemonapp.presentation.BaseViewModelFactory
import dagger.Component

@Component(
    modules = [
        MainScreenModule::class,
        UseCaseModule::class,
        NetworkModule::class,
        RepositoryModule::class]
)
@ScreenScope
interface MainScreenComponent {

    fun viewModelFactory(): BaseViewModelFactory

    @Component.Builder
    interface Builder {

        fun build(): MainScreenComponent

    }

    companion object {
        fun create() = with(DI.appComponent) {
            DaggerMainScreenComponent.builder()
                .build()
        }
    }
}