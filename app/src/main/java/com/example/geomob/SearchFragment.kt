package com.example.geomob

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.ListFragment
import com.twitter.sdk.android.tweetui.SearchTimeline
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter

class SearchFragment : ListFragment() {

    private val setting by lazy { Setting(TwitterActivity.context) }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var style = R.style.tw__TweetLightStyle
        if (setting.darkMode) {
            style = R.style.tw__TweetDarkStyle
            listView.divider = ColorDrawable(ContextCompat.getColor(TwitterActivity.context, R.color.darkDivider))
        }
        val timeline = SearchTimeline.Builder()
            .query(getQuery())
            .build()
        val adapter = TweetTimelineListAdapter.Builder(activity)
            .setTimeline(timeline)
            .setViewStyle(style)
            .build()
        listAdapter = adapter
    }

    private fun getQuery(): String {
        val mute = ArrayList<String>()
        mute.add("twittbot.net")
        mute.add("IFTTT")
        mute.add("tdr_dash")
        mute.add("myThings_App")
        mute.add("ＯｄａＹｕｋｉｏのツール")
        return "#tdr_now OR #tdr_md OR #tdr_food" +
                mute.joinToString(separator = "") { " -source:$it" }
    }
}