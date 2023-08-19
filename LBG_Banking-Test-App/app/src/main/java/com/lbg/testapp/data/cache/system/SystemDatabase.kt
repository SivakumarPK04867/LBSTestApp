package com.lbg.testapp.data.cache.system

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lbg.testapp.data.cache.dao.UserDao
import com.lbg.testapp.data.cache.entity.UserEntity

/**
 * Created by Siva kumar boddu 
 */
@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class SystemDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        fun newInstance(context: Context): SystemDatabase {
            return Room.databaseBuilder(context, SystemDatabase::class.java, "wisetest-system.db").build()
        }
    }
}