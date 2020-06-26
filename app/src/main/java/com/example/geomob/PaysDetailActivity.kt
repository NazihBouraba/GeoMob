package com.example.geomob

import android.content.Intent
import android.media.MediaPlayer
import android.media.MediaPlayer.OnCompletionListener
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.geomob.model.Pays
import kotlinx.android.synthetic.main.activity_pays_detail.*

class PaysDetailActivity : AppCompatActivity() {
     var mMediaPlayer: MediaPlayer? = null
     var  isplaying = false
    val mCompletionListener = OnCompletionListener { releaseMediaPlayer() }

    private fun releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer!!.release()
            mMediaPlayer = null
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pays_detail)
        val pays = intent.getSerializableExtra("pays") as Pays
        nom_pays.text= pays.nom
        superficie_txt.text =pays.surface
        population_txt.text = pays.population
        if (this != null) {
            Glide.with(this)
                .load(pays.drapeau)
                .into(detail_drapeau)
        }

        description_txt.text = pays.description
        ressources_tv.text= pays.rerssources
        val images: List<String> = pays.images.split(",")
        slider.setItems(images)
        slider.getIndicator()
        // automatique animation
        slider.addTimerToSlide(5000)


        hymne_btn.setOnClickListener({
            if(isplaying) {

               mMediaPlayer?.release()
                hymne_btn.text = "ECOUTER L'HYMNE DU PAYS"
                isplaying = false

            }
            else{
                val resID = resources.getIdentifier(pays.hymme, "raw", packageName)
                mMediaPlayer = MediaPlayer.create(this@PaysDetailActivity, resID)
                mMediaPlayer?.start()
                isplaying = true
                mMediaPlayer?.setOnCompletionListener(mCompletionListener)
                hymne_btn.text = "ARRETER"

            }


        })


        video_btn.setOnClickListener({
            val intent = Intent(this,VideoActivity::class.java)
            intent.putExtra("pays",pays)
            startActivity(intent)
        })

        wiki_btn.setOnClickListener({
            val intent = Intent(this,WikipediaActivity::class.java)
            intent.putExtra("pays",pays)
            startActivity(intent)
        })




    }
}
