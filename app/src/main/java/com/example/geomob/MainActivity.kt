package com.example.geomob

import android.annotation.SuppressLint
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.geomob.model.Pays
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var list_pays : MutableList<Pays>?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        get_pays()



//        val algeria = Pays("Algerie"," Sa capitale est Alger, la ville la plus peuplée du pays, dans le Nord, sur la côte méditerranéenne.",
//           "2381741.0" , "40400000", "1962   independence","petrole gaze naturel...",
//            "missali el hadj ,abdelhamid ben badis",
//            "https://cdn.webshopapp.com/shops/94414/files/53432190/icone-drapeau-dalgerie-telechargement-gratuit.jpg",
//            "algerie_hymne",
//            ("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQU-gd8K5WglLLfsrcibwUjm0oLkp2pXQmVlLwDLO-89pfElb28&usqp=CAU"+
//             ", https://images.laprovence.com/media/2020-05/2020-05-30/generated_map_jpg_1590851739.png?twic=v1/dpr=2/focus=0x0/cover=740x416"
//                ),
//            ("5nkLeotSFp8,MuUBK4rtP4Q"),
//
//            false)
//          // ajouter_pays(algeria)
//
//        modifier_pays(algeria)


    }

    private fun setuprecyclerview(list_pays: MutableList<Pays>) {

        val adapter =PaysRecyclerAdapter(this, list_pays)
        val manager = LinearLayoutManager(this)
        manager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = manager
        recyclerView.adapter = adapter

    }


    fun ajouter_pays(pays : Pays) {
        var act = this


        object : AsyncTask<Void, Void, Void>() {
            @SuppressLint("StaticFieldLeak")
            override fun doInBackground(vararg voids: Void): Void? {
                val db = PaysDB.getInstance(act)
                val dao = db?.PaysDAO()
                 dao?.ajouter(pays)

                return null
            }


            @SuppressLint("StaticFieldLeak")
            override fun onPostExecute(result: Void?) {
                Toast.makeText(this@MainActivity,"pays ajouté",Toast.LENGTH_SHORT).show()


            }
        }.execute()
    }


    fun get_pays()   {
        var act = this


        object : AsyncTask<Void, Void, Void>() {
            override fun doInBackground(vararg voids: Void): Void? {
                val db = PaysDB.getInstance(act)
                val dao = db?.PaysDAO()
                val pays = dao?.liste_pays()

                if (pays != null) {
                    list_pays = pays
                    setuprecyclerview(list_pays!!)
                }

                return null
            }

            override fun onPostExecute(result: Void?) {

            }
        }.execute()

    }




    fun modifier_pays(pays : Pays) {
        var act = this


        object : AsyncTask<Void, Void, Void>() {
            @SuppressLint("StaticFieldLeak")
            override fun doInBackground(vararg voids: Void): Void? {
                val db = PaysDB.getInstance(act)
                val dao = db?.PaysDAO()
                dao?.modifier(pays)

                return null
            }


            @SuppressLint("StaticFieldLeak")
            override fun onPostExecute(result: Void?) {
                Toast.makeText(this@MainActivity,"pays ajouté",Toast.LENGTH_SHORT).show()


            }
        }.execute()
    }
}
