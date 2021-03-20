package space.basyk.numbers.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import space.basyk.numbers.utils.BASE_URL

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ApiServices by lazy {
        retrofit.create(ApiServices::class.java)
    }
}