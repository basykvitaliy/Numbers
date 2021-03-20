package space.basyk.numbers.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import space.basyk.numbers.models.modelroom.NumModel

@Dao
interface NumberDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(numModel: NumModel)

    @Delete
    suspend fun delete(numModel: NumModel)

    @Query("SELECT * from number_table")
    fun getAllNum(): LiveData<List<NumModel>>

    @Query("DELETE from number_table")
    fun deleteAllItems()

}