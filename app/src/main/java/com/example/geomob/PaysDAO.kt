package com.example.geomob

import androidx.room.*
import com.example.geomob.model.Pays

@Dao
interface PaysDAO {

    @Query("SELECT * FROM Pays")
    fun liste_pays(): MutableList<Pays>

    @Query("SELECT * FROM Pays where visited=:t")
    fun new_pays(t : Boolean): MutableList<Pays>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun ajouter(pays : Pays)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun modifier(pays:  Pays)

    @Delete
    fun supprimer(pays:  Pays)


}