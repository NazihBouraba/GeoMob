package com.example.geomob

import androidx.room.*
import com.example.geomob.model.Pays

@Dao
interface PaysDAO {

    @Query("SELECT * FROM Pays")
    fun liste_pays(): MutableList<Pays>

    @Insert
    fun ajouter(pays : Pays)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun modifier(pays:  Pays)
}