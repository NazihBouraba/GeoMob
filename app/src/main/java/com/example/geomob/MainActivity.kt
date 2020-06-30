package com.example.geomob

import android.annotation.SuppressLint
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.AsyncTask
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.geomob.model.Pays
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_pays_detail.*


class MainActivity : AppCompatActivity() {

    var list_pays : MutableList<Pays>?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        chagecolor(all_btn)
        get_pays()


        new_btn.setOnClickListener({
            chagecolor(new_btn)
         New_pays()
        })

        visited_btn.setOnClickListener({
            chagecolor(visited_btn)
            visited_pays()
        })

        all_btn.setOnClickListener({
            chagecolor(all_btn)
           get_all()
        })




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


    fun supprimer_pays(pays : Pays) {
        var act = this


        object : AsyncTask<Void, Void, Void>() {
            @SuppressLint("StaticFieldLeak")
            override fun doInBackground(vararg voids: Void): Void? {
                val db = PaysDB.getInstance(act)
                val dao = db?.PaysDAO()
                dao?.supprimer(pays)

                return null
            }


            @SuppressLint("StaticFieldLeak")
            override fun onPostExecute(result: Void?) {
                Toast.makeText(this@MainActivity,"pays ajouté",Toast.LENGTH_SHORT).show()


            }
        }.execute()
    }

    fun remplire_bdd() {






        val algeria = Pays("Algeria"," Sa capitale est Alger, la ville la plus peuplée du pays, dans le Nord, sur la côte méditerranéenne.",
           "2381741.0" , "40400000", "1962   independence","petrole gaze naturel...",
            "missali el hadj ,abdelhamid ben badis",
            "https://cdn.webshopapp.com/shops/94414/files/53432190/icone-drapeau-dalgerie-telechargement-gratuit.jpg",
            "algerie_hymne",
            ("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQU-gd8K5WglLLfsrcibwUjm0oLkp2pXQmVlLwDLO-89pfElb28&usqp=CAU"+
             ",https://images.laprovence.com/media/2020-05/2020-05-30/generated_map_jpg_1590851739.png?twic=v1/dpr=2/focus=0x0/cover=740x416"
                ),
            ("5nkLeotSFp8,MuUBK4rtP4Q"),

            false)
        val france = Pays("France","La France (Écouter), en forme longue depuis 1875 la République française (Écouter), est un État souverain transcontinental dont le territoire métropolitain est situé en Europe de l'Ouest. Ce dernier a des frontières terrestres avec la Belgique, le Luxembourg, l'Allemagne, la Suisse, l'Italie, l'Espagne et les deux principautés d'Andorre et de Monaco. La France dispose aussi d'importantes façades maritimes sur l'Atlantique et la Méditerranée. Son territoire ultramarin s'étend dans les océans Indien, Atlantique et Pacifique ainsi qu'en Amérique du Sud, et a des frontières terrestres avec le Brésil, le Suriname et les Pays-Bas.",
            "643 801" , "6700000", "Bilan démographique 2019. Le bilan démographique donne la population de la France estimée au 1ᵉʳ janvier de chaque année et l'évolution de la situation ","petrole gaze naturel...",
            " Emmanuel Macron",
            "https://www.lephareonline.net/wp-content/uploads/2014/05/1009493-Drapeau_de_la_France.jpg",
            "france_hymne",
            ("https://lh3.googleusercontent.com/proxy/okCUA1OfV2rKzxV-wEX9ceUqAYwEC0ZJBdpQ4-oh3NuSu7zzk6_AYU4dWhHn2YuMWDYaQ6nMxPtDz8fuOp9q5G_Bi5fIxLnxuqFexGd4fawp"+
                    ",https://images.france.fr/zeaejvyq9bhj/3vEFP2bjpfOvg78I35GBlc/0c29272999d0bc663d04457b9cc7c378/Header-France.fr2_optim.jpg?w=1120&h=491&q=70&fl=progressive&fit=fill"
                    ),
            ("wWIsSMpiC1c,lk3-TchIhE4"),

            false)

        val England = Pays("England","L'Angleterre (en anglais England [ˈɪŋɡlənd] Écouter) est une nation constitutive du Royaume-Uni1. Elle est bordée par l'Écosse au nord et le pays de Galles à l'ouest. Son littoral est entouré par la mer du Nord à l'est, la mer d'Irlande au nord-ouest, la mer Celtique au sud-ouest, et la Manche au sud qui la sépare de l'Europe continentale.",
            "130 395" , "55,98 million", "The earliest known evidence of human presence in the area now known as England was that of Homo antecessor, dating to approximately 780,000 years ago. ","petrole gaze naturel...",
            " Emmanuel Macron",
            "https://image.shutterstock.com/image-vector/flag-united-kingdom-vector-260nw-304681397.jpg",
            "england_hymne",
            ("https://d3dqioy2sca31t.cloudfront.net/Projects/cms/production/000/024/811/slideshow/c56bd725101bef2aaef43b0def6a24c7/england-london-big-ben-river-night.jpg"+
                    ",https://resize.hswstatic.com/w_907/gif/UK-Britain-1.jpg"
                    ),
            ("Y4Syasft_5Y,WHEthsO7T7w"),

            false)

        val Italy = Pays("Italy","Italy (Italian: Italia [iˈtaːlja] (About this soundlisten)), officially the Italian Republic (Italian: Repubblica Italiana [reˈpubblika itaˈljaːna]),[10][11][12][13] is a country consisting of a peninsula delimited by the Alps and surrounded by several islands. Italy is located in south-central Europe,[14][15] and it is also considered a part of western Europe.[16][17] A unitary parliamentary republic with its capital in Rome,",
            "301,340" , "60,36 million", "The earliest known evidence of human presence in the area now known as England was that of Homo antecessor, dating to approximately 780,000 years ago. ","petrole gaze naturel...",
            " Emmanuel Macron",
            "https://images-na.ssl-images-amazon.com/images/I/216-f6h7qRL._AC_.jpg",
            "italy_hymne",
            ("https://www.fodors.com/wp-content/uploads/2019/03/20GorgeousSidetownsinItaly__HERO_shutterstock_688078159.jpg"+
                    ",https://tr-images.condecdn.net/image/2736pore2VG/crop/1440/0.5235602094240838/f/2italy-gettyimages-908413712.jpg,https://media.gettyimages.com/photos/view-of-venices-grand-canal-picture-id911570904?s=612x612"
                    ),
            ("FlRwssZYRM0,TRGAzB858F8,b3VTeppIOmA"),

            false)


         ajouter_pays(algeria)
         ajouter_pays(france)
         ajouter_pays(England)
        ajouter_pays(Italy)



    }

    fun New_pays() {
        var act = this


        object : AsyncTask<Void, Void, Void>() {
            @SuppressLint("StaticFieldLeak")
            override fun doInBackground(vararg voids: Void): Void? {
                val db = PaysDB.getInstance(act)
                val dao = db?.PaysDAO()
                list_pays = dao?.new_pays(false)

                return null
            }


            @SuppressLint("StaticFieldLeak")
            override fun onPostExecute(result: Void?) {

                val adapter =PaysRecyclerAdapter(act, list_pays!!)
                recyclerView.swapAdapter(adapter,true)


            }
        }.execute()
    }

    fun visited_pays() {
        var act = this


        object : AsyncTask<Void, Void, Void>() {
            @SuppressLint("StaticFieldLeak")
            override fun doInBackground(vararg voids: Void): Void? {
                val db = PaysDB.getInstance(act)
                val dao = db?.PaysDAO()
                list_pays = dao?.new_pays(true)

                return null
            }


            @SuppressLint("StaticFieldLeak")
            override fun onPostExecute(result: Void?) {

                val adapter =PaysRecyclerAdapter(act, list_pays!!)
                recyclerView.swapAdapter(adapter,true)


            }
        }.execute()
    }

    fun get_all()   {
        var act = this


        object : AsyncTask<Void, Void, Void>() {
            override fun doInBackground(vararg voids: Void): Void? {
                val db = PaysDB.getInstance(act)
                val dao = db?.PaysDAO()
                list_pays=  dao?.liste_pays()


                return null
            }

            override fun onPostExecute(result: Void?) {
                val adapter =PaysRecyclerAdapter(act, list_pays!!)
                recyclerView.swapAdapter(adapter,true)
            }
        }.execute()

    }

    fun chagecolor(b: Button){
        var cd = ColorDrawable(-0x808080)
        all_btn.background = cd
        visited_btn.background = cd
        new_btn.background = cd
        cd =ColorDrawable(-0x0FFFF)
        b.background = cd

    }
}
