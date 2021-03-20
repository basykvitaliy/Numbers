package space.basyk.numbers.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import space.basyk.numbers.models.nummodel.NumberModel
import space.basyk.numbers.models.randomdate.RandomDate
import space.basyk.numbers.models.randommath.RandomMath
import space.basyk.numbers.models.randomtrivia.RandomTrivia
import space.basyk.numbers.models.randomyear.RandYear

interface ApiServices {

    @Headers("Content-Type: application/json")
    @GET("/random/date")
    suspend fun getRandomDate(): Response<RandomDate>

    @Headers("Content-Type: application/json")
    @GET("/random/year")
    suspend fun getRandomYear(): Response<RandYear>

    @Headers("Content-Type: application/json")
    @GET("/random/math")
    suspend fun getRandomMath(): Response<RandomMath>

    @Headers("Content-Type: application/json")
    @GET("/random/trivia")
    suspend fun getRandomTrivia(): Response<RandomTrivia>



    @Headers("Content-Type: application/json")
    @GET("/{number}")
    suspend fun getNumber(@Path("number") number: Int): Response<NumberModel>

}