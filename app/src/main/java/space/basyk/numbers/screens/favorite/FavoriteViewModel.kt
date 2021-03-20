package space.basyk.numbers.screens.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import space.basyk.numbers.models.modelroom.NumModel
import space.basyk.numbers.utils.REPOSITORY_ROOM

class FavoriteViewModel: ViewModel() {
    val getAllNum = REPOSITORY_ROOM.allnumbers

    fun deleteAll(){
        viewModelScope.launch (Dispatchers.IO){
            REPOSITORY_ROOM.deleteAll()
        }
    }
}