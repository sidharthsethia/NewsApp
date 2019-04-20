package com.example.newsapp.network

import com.example.newsapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 * Created by sidharthsethia on 2019-04-20.
 */

class RetrofitHelper {
    companion object {
        private const val TIMEOUT = 10L
        private const val API_HEADER_KEY = "X-Api-Key"
        private const val BASE_URL = "https://newsapi.org"

        private var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getHttpClient())
            .build()

        private fun getHttpClient(): OkHttpClient {
            val headersInterceptor = Interceptor { chain ->
                val original = chain.request()
                val builder = original.newBuilder()
                builder.addHeader(API_HEADER_KEY, BuildConfig.API_KEY)
                val request = builder.method(original.method(), original.body()).build()
                chain.proceed(request)
            }
            val normalBuilder = OkHttpClient.Builder()
            normalBuilder.connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            normalBuilder.readTimeout(TIMEOUT, TimeUnit.SECONDS)
            normalBuilder.writeTimeout(TIMEOUT, TimeUnit.SECONDS)
            normalBuilder.addInterceptor(headersInterceptor)
            return normalBuilder.build()
        }

        private fun <S> createService(serviceClass: Class<S>): S {
            return retrofit.create(serviceClass)
        }
    }
}