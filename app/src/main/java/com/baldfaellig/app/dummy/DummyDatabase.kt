package com.baldfaellig.app.dummy

import androidx.room3.ColumnInfo
import androidx.room3.Dao
import androidx.room3.Database
import androidx.room3.Entity
import androidx.room3.Insert
import androidx.room3.OnConflictStrategy
import androidx.room3.PrimaryKey
import androidx.room3.Query
import androidx.room3.RoomDatabase

@Entity
data class DummyItem(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "name") val name: String
)

@Dao
interface DummyDao {
    @Insert(
        onConflict = OnConflictStrategy.REPLACE
    )
    suspend fun insertAll(vararg items: DummyItem)

    @Query("SELECT * FROM DummyItem")
    suspend fun getAll(): List<DummyItem>
}

@Database(entities = [DummyItem::class], version = 1)
abstract class DummyDatabase: RoomDatabase() {
    abstract fun dummyDao(): DummyDao
}
