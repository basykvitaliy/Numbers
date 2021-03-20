package space.basyk.numbers.screens.first

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import space.basyk.numbers.data.database.NumRoomDatabase
import space.basyk.numbers.data.roomrepository.RoomRepository
import space.basyk.numbers.models.modelroom.NumModel
import space.basyk.numbers.models.nummodel.NumberModel
import space.basyk.numbers.utils.APP_ACTIVITY
import space.basyk.numbers.utils.REPOSITORY
import space.basyk.numbers.utils.REPOSITORY_ROOM


class FirstViewModel:ViewModel() {

    val myNumber: MutableLiveData<NumberModel> = MutableLiveData()


     fun getNumber(number: Int){
        viewModelScope.launch {
          myNumber.value = REPOSITORY.getNumResult(number).body()
        }
    }

     fun insert(numModel: NumModel, onSuccess:() -> Unit)=
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY_ROOM.insert(numModel){
                onSuccess()
            }
        }


}