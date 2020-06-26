package com.example.geomob.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity
data class Pays(  @PrimaryKey() var nom :String ,
             @ColumnInfo(name = "description") var description : String,
             @ColumnInfo(name = "surface") var surface : String,
             @ColumnInfo(name = "population") var population : String,
             @ColumnInfo(name = "historique") var  historique : String,
             @ColumnInfo(name = "rerssources") var  rerssources : String,
             @ColumnInfo(name = "personnalites") var personnalites : String,
             @ColumnInfo(name = "drapeau") var drapeau : String, // url
             @ColumnInfo(name = "hymme") var hymme : String, // android ressource
             @ColumnInfo(name = "images") var images : String, // urls
             @ColumnInfo(name = "videos") var videos : String, // urls
             @ColumnInfo(name = "visited" , defaultValue = "false") var visited : Boolean   // urls
// add tweets later

) : Serializable

{
    object Paysprovider {

        val data: MutableList<Pays>
            get() {


                return ArrayList()
            }

    }
}