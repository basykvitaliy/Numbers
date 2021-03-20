package space.basyk.numbers.utils

import space.basyk.numbers.MainActivity
import space.basyk.numbers.data.roomrepository.NumDatabaseRepository
import space.basyk.numbers.repositories.RpositoryRetrofit

lateinit var APP_ACTIVITY: MainActivity
lateinit var REPOSITORY: RpositoryRetrofit
lateinit var REPOSITORY_ROOM: NumDatabaseRepository
const val BASE_URL = "http://numbersapi.com"

