package space.basyk.numbers.data.roomrepository

import androidx.lifecycle.LiveData
import space.basyk.numbers.data.dao.NumberDao
import space.basyk.numbers.models.modelroom.NumModel

class RoomRepository(private val numberDao: NumberDao): NumDatabaseRepository {
    override val allnumbers: LiveData<List<NumModel>>
        get() = numberDao.getAllNum()

    override suspend fun insert(numModel: NumModel, onSuccess: () -> Unit) {
        numberDao.insert(numModel)
        onSuccess()
    }

    override suspend fun delete(numModel: NumModel, onSuccess: () -> Unit) {
        numberDao.delete(numModel)
        onSuccess()
    }

    override suspend fun deleteAll() {
        numberDao.deleteAllItems()
    }
}