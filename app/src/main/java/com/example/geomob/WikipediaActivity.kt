package com.example.geomob

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.geomob.Retrofit.RetrofitClientInstance
import com.example.geomob.Retrofit.Wikipedia
import com.example.geomob.model.Pays
import com.example.geomob.model.WikiArticle
import com.example.geomob.model.pages
import kotlinx.android.synthetic.main.activity_wikipedia.*
import org.json.JSONObject
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class WikipediaActivity : AppCompatActivity() {

    var firstparagraph = ""
    var seconparagraph = ""
    var thiredparagraph = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wikipedia)
        val pays = intent.getSerializableExtra("pays") as Pays
        get_wiki_article("Algeria")


    }

    private fun get_wiki_article(s: String)  {




        object : AsyncTask<Void, Void, Void>() {

            override fun doInBackground(vararg voids: Void): Void? {
                try{
                    val doc = Jsoup.connect("https://en.wikipedia.org/wiki/"+s).get()
                    val paragraphs = doc.select("p:not(:has(#coordinates))")
                    val firstParagraph = paragraphs.first();
                    firstparagraph =  firstParagraph.text()
                    val secondParagraph = paragraphs.next()
                    seconparagraph =  secondParagraph.text()
                    val thiredParagraph = paragraphs.next()
                    thiredparagraph=  thiredParagraph.text()

                }
                catch ( e: IOException) {
                    Log.v("Article", "failed")
                }

                return null
            }



            override fun onPostExecute(result: Void?) {
                firstp.text = firstparagraph
                secondp.text = seconparagraph
             //   thirdp.text = thiredparagraph


            }
        }.execute()



        }




}


