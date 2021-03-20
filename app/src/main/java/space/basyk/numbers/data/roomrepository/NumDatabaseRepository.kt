package space.basyk.numbers.data.roomrepository

import androidx.lifecycle.LiveData
import space.basyk.numbers.models.modelroom.NumModel

interface NumDatabaseRepository {
    val allnumbers: LiveData<List<NumModel>>
    suspend fun insert(numModel: NumModel, onSuccess:() -> Unit)
    suspend fun delete(numModel: NumModel, onSuccess:() -> Unit)
    suspend fun deleteAll()
}