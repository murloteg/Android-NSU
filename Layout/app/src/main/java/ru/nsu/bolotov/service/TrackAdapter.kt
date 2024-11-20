import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.nsu.bolotov.data.TrackItem
import ru.nsu.bolotov.layout.R

class TrackAdapter(private val trackList: List<TrackItem>) :
    RecyclerView.Adapter<TrackAdapter.TrackViewHolder>() {

    companion object {
        private const val TAG = "TrackAdapter"
    }

    class TrackViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.title)
        val artist: TextView = view.findViewById(R.id.description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.track_item, parent, false)
        return TrackViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        val track = trackList[position]
        holder.title.text = track.title
        holder.artist.text = track.description
    }

    override fun getItemCount(): Int {
        Log.d(TAG, "getItemCount --> Tracks count: ${trackList.size}")
        return trackList.size
    }
}
