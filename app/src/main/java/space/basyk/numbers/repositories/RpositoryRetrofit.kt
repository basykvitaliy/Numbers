package space.basyk.numbers.repositories

import retrofit2.Response
import space.basyk.numbers.api.RetrofitInstance
import space.basyk.numbers.models.nummodel.NumberModel
import space.basyk.numbers.models.randomdate.RandomDate
import space.basyk.numbers.models.randommath.RandomMath
import space.basyk.numbers.models.randomtrivia.RandomTrivia
import space.basyk.numbers.models.randomyear.RandYear

class RpositoryRetrofit {
    suspend fun getNumResult(number: Int): Response<NumberModel>{
        return RetrofitInstance.api.getNumber(number)
    }

    suspend fun getRandomYear():Response<RandYear>{
        return RetrofitInstance.api.getRandomYear()
    }
    suspend fun getRandomMath():Response<RandomMath>{
        return RetrofitInstance.api.getRandomMath()
    }
    suspend fun getRandomDate():Response<RandomDate>{
        return RetrofitInstance.api.getRandomDate()
    }
    suspend fun getRandomTrivia():Response<RandomTrivia>{
        return RetrofitInstance.api.getRandomTrivia()
    }
}