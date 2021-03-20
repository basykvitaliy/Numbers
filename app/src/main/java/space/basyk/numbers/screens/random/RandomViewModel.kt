package space.basyk.numbers.screens.random

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import space.basyk.numbers.data.database.NumRoomDatabase
import space.basyk.numbers.data.roomrepository.RoomRepository
import space.basyk.numbers.models.modelroom.NumModel
import space.basyk.numbers.models.randomdate.RandomDate
import space.basyk.numbers.models.randommath.RandomMath
import space.basyk.numbers.models.randomtrivia.RandomTrivia
import space.basyk.numbers.models.randomyear.RandYear
import space.basyk.numbers.utils.APP_ACTIVITY

import space.basyk.numbers.utils.REPOSITORY
import space.basyk.numbers.utils.REPOSITORY_ROOM

class RandomViewModel: ViewModel() {
    val myRandYear: MutableLiveData<RandYear> = MutableLiveData()
    val myRandMath: MutableLiveData<RandomMath> = MutableLiveData()
    val myRandDate: MutableLiveData<RandomDate> = MutableLiveData()
    val myRandTrivia: MutableLiveData<RandomTrivia> = MutableLiveData()

    fun getRandomYear(){
        viewModelScope.launch {
            myRandYear.value = REPOSITORY.getRandomYear().body()
        }
    }
    fun getRandomMath(){
        viewModelScope.launch {
            myRandMath.value = REPOSITORY.getRandomMath().body()
        }
    }
    fun getRandomDate(){
        viewModelScope.launch {
            myRandDate.value = REPOSITORY.getRandomDate().body()
        }
    }
    fun getRandomTrivia(){
        viewModelScope.launch {
            myRandTrivia.value = REPOSITORY.getRandomTrivia().body()
        }
    }

    fun initDatabase(onSuccess: () -> Unit){
        val daoNum = NumRoomDatabase.getInstance(APP_ACTIVITY).getDao()
        REPOSITORY_ROOM = RoomRepository(daoNum)
        onSuccess()
    }

    fun insert(numModel: NumModel, onSuccess: () -> Unit)=
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY_ROOM.insert(numModel){
                onSuccess()
            }
        }
}