package ru.nsu.bolotov.layout

import TrackAdapter
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.nsu.bolotov.data.TrackItem

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val tracks = listOf(
            TrackItem("First song", "Wooow! Amazing song"),
            TrackItem("Second song", "Pretty cool vibe"),
            TrackItem("Third song", "Available on our service"),
            TrackItem("Track #4", "Wooow! Amazing song"),
            TrackItem("Track #5", "Wooow! Amazing song"),
            TrackItem("Track #6", "Wooow! Amazing song"),
            TrackItem("Track #7", "Wooow! Amazing song"),
            TrackItem("Track #8", "Wooow! Amazing song"),
            TrackItem("Track #9", "Wooow! Amazing song"),
            TrackItem("Track #10", "Wooow! Amazing song"),
            TrackItem("Track #11", "Wooow! Amazing song"),
            TrackItem("Track #12", "Wooow! Amazing song"),
            TrackItem("Track #13", "Wooow! Amazing song"),
            TrackItem("Track #14", "Wooow! Amazing song"),
            TrackItem("Track #15", "Wooow! Amazing song"),
            TrackItem("Track #16", "Wooow! Amazing song"),
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = TrackAdapter(tracks)

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                Log.d("RecyclerView", "Scrolling...")
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                when (newState) {
                    RecyclerView.SCROLL_STATE_IDLE -> Log.d("RecyclerView", "Scroll state: Idle")
                    RecyclerView.SCROLL_STATE_DRAGGING -> Log.d("RecyclerView", "Scroll state: Dragging")
                }
            }
        })
    }
}
