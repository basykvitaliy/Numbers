package space.basyk.numbers.models.modelroom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "number_table")
class NumModel (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo
    val description: String,

    @ColumnInfo
    val date: String = "",

    @ColumnInfo
    val year: String = "",

    @ColumnInfo
    val number: String


)