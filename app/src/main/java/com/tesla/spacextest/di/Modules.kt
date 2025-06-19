package com.tesla.spacextest.di

import androidx.room.Room
import com.tesla.spacextest.SpaceXApp
import com.tesla.spacextest.common.dispatchers.AppDispatchers
import com.tesla.spacextest.data.local.database.SpaceXDatabase
import com.tesla.spacextest.data.local.repository.DefaultFavoriteLaunchesRepository
import com.tesla.spacextest.data.remote.RocketLaunchApi
import com.tesla.spacextest.data.remote.repository.DefaultRocketLaunchRepository
import com.tesla.spacextest.domain.repository.FavoriteLaunchesRepository
import com.tesla.spacextest.domain.repository.RocketLaunchRepository
import com.tesla.spacextest.presentation.viewmodel.RocketLaunchesViewModel
import kotlinx.coroutines.Dispatchers
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

private const val BASE_URL = "https://api.spacexdata.com/v5/"

val appModule = module {
    single<RocketLaunchApi> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
            .create()
    }
    viewModel {
        RocketLaunchesViewModel(get())
    }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            })
            .build()
    }
    single { BASE_URL.toHttpUrlOrNull() }
}

val repositoryModule = module {
    single<RocketLaunchRepository> {
        DefaultRocketLaunchRepository(get(named(AppDispatchers.IO)), get())
    }
}

val dispatchersModule = module {
    single(named(AppDispatchers.IO)) {
        Dispatchers.IO
    }
    single(named(AppDispatchers.Default)) {
        Dispatchers.Default
    }
    single(named(AppDispatchers.Main)) {
        Dispatchers.Main
    }
}

val roomModule = module {
    single {
        Room.databaseBuilder(
            get<SpaceXApp>(),
            SpaceXDatabase::class.java, "spacex_database"
        ).build()
    }

    single { get<SpaceXDatabase>().favoritesLaunchDao() }
    single { get<SpaceXDatabase>().favoriteLaunchDetailsDao() }

    single<FavoriteLaunchesRepository> { DefaultFavoriteLaunchesRepository() }
}