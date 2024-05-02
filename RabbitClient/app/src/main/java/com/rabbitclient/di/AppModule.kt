package com.rabbitclient.di

import com.rabbitclient.data.RabbitApi
import com.rabbitclient.data.RabbitApi.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

	@Provides
	@Singleton
	fun provideRabbitApi(): RabbitApi {
		return Retrofit
			.Builder()
			.addConverterFactory(GsonConverterFactory.create())
			.baseUrl(BASE_URL)
			.build()
			.create(RabbitApi::class.java)
	}
}