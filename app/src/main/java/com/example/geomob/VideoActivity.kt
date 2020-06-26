package com.example.geomob

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.geomob.model.Pays
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView
import kotlinx.android.synthetic.main.activity_video.*

class VideoActivity : YouTubeBaseActivity() , YouTubePlayer.OnInitializedListener {

     var currentvideo = ""
    var taille =0
    lateinit var myoutubeplayer : YouTubePlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)
        val pays = intent.getSerializableExtra("pays") as Pays
        val videos: List<String> = pays.videos.split(",")
         taille = videos.size
         currentvideo = videos[0]

        playVideo(youtubePlayerView)

        next_btn.setOnClickListener({
            if(videos.indexOf(currentvideo)< taille-1)
            {
                currentvideo = videos[videos.indexOf(currentvideo)+1]
                myoutubeplayer.cueVideo(currentvideo)

            }
            else{
                currentvideo= videos[0]
                myoutubeplayer.cueVideo(currentvideo)
            }

        })

    }

    fun playVideo(  youTubePlayerView  : YouTubePlayerView){

        youTubePlayerView.initialize("AIzaSyBcTMN_jWUvaPECzmnAzPym2mGppvWKGnI",this)

    }

    override fun onInitializationSuccess(
        p0: YouTubePlayer.Provider?,
        p1: YouTubePlayer?,
        p2: Boolean
    ) {
        if (!p2) {
            p1?.cueVideo(currentvideo)
            if (p1 != null) {
                myoutubeplayer = p1
            }
        }
    }

    override fun onInitializationFailure(
        p0: YouTubePlayer.Provider?,
        p1: YouTubeInitializationResult?
    ) {
        if (p1 != null) {
            if (p1.isUserRecoverableError()) {

                p1.getErrorDialog(this, 1).show()
            } else {
                Toast.makeText(this, "Eroor playing video from youtube", Toast.LENGTH_LONG).show()
            }
        }
    }


}

