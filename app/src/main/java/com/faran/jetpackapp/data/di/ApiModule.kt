package com.faran.jetpackapp.data.di

import android.app.Application
import com.faran.jetpackapp.BuildConfig
import com.faran.jetpackapp.data.api.UsersApi
import com.faran.jetpackapp.data.services.UserService
import com.faran.jetpackapp.data.services.UserServiceImpl
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    @Named("BaseUrl")
    fun provideBaseUrl() = BuildConfig.BASE_URL

    @Provides
    @Singleton
    fun provideHttpCache(application: Application): Cache =
        Cache(application.cacheDir, 10 * 1024 * 1024)

    @Provides
    fun provideApiHttp(
        cache: Cache
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .cache(cache)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG)
                    HttpLoggingInterceptor.Level.BASIC
                else
                    HttpLoggingInterceptor.Level.NONE
            })
            .callTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)

        return builder.build()
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi =
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

      private fun makeStandardApi(
        builder: Retrofit.Builder,
        okHttpClient: OkHttpClient,
        moshi: Moshi
    ) = builder
          .client(okHttpClient)
          .addConverterFactory(MoshiConverterFactory.create(moshi))

    @Provides
    fun providerUserApi(
        @Named("BaseUrl") baseUrl: String,
        okHttpClient: OkHttpClient,
        moshi: Moshi
    ): UsersApi =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .let { makeStandardApi(it, okHttpClient, moshi) }
            .build()
            .create(UsersApi::class.java)

/*    @Provides
    fun provideApiHttp(
        @Named("NoInterceptor") okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .baseUrl(baseUrl)
            .build()
    }

    @Provides
    fun provideOkHttpClient(prefs: SharedPreferences): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .addInterceptor {
                val original = it.request()
                val newRequestBuilder = original.newBuilder()
                newRequestBuilder.addHeader("Content-Type", "application/json")
                newRequestBuilder.addHeader("Accept", "application/json")
                prefs.getString(TOKEN_KEY, null)?.let { token ->
                    newRequestBuilder.addHeader("Authorization", "Bearer $token")
                }
                it.proceed(newRequestBuilder.build())
            }
            .addInterceptor {
                val original = it.request()
                val newUrl = original.url
                    .newBuilder()
                    .addQueryParameter("apiKey", BuildConfig.API_KEY)
                    .build()
                val newRequest = original
                    .newBuilder()
                    .url(newUrl)
                    .build()

                it.proceed(newRequest)
            }
            .callTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
            .build()
    }*/

    @Provides
    fun provideUserService(api: UsersApi): UserService =
        UserServiceImpl(api)
}