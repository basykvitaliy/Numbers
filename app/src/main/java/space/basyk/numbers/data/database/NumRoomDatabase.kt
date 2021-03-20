package space.basyk.numbers.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import space.basyk.numbers.data.dao.NumberDao
import space.basyk.numbers.models.modelroom.NumModel

@Database(entities = [NumModel::class], version = 2)
abstract class NumRoomDatabase: RoomDatabase() {

    abstract fun getDao(): NumberDao

    companion object{
        @Volatile
        private var database: NumRoomDatabase ?= null

        @Synchronized
        fun getInstance(context: Context): NumRoomDatabase{
            return if (database == null){
                database = Room.databaseBuilder(context, NumRoomDatabase::class.java, "db").fallbackToDestructiveMigration().build()
                database as NumRoomDatabase
            }else{
                database as NumRoomDatabase
            }
        }
    }

}