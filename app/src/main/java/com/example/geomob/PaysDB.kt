package com.example.geomob

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.geomob.model.Pays

@Database(entities = arrayOf(Pays::class), version = 1)
abstract class PaysDB(): RoomDatabase() {

    abstract fun PaysDAO():PaysDAO

    companion object {
        private var instance: PaysDB? = null

        fun getInstance(context: Context): PaysDB? {
            if (instance == null) {


                instance = Room.databaseBuilder(context.getApplicationContext(),
                        PaysDB::class.java, "pays.db")
                    .build()


            }
            return instance
        }

        fun destroyInstance() {
            instance = null
        }
    }
}