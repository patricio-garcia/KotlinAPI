package cl.serlitoral.kotlinapi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cl.serlitoral.kotlinapi.R
import cl.serlitoral.kotlinapi.model.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_movie_item.view.*

class MovieAdapter(private val context : Context, private val movieList: MutableList<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        var itemView = LayoutInflater
            .from(context)
            .inflate(R.layout.layout_movie_item, parent, false)

        return MovieViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        Picasso.get()
            .load(movieList[position].imageurl)
            .into(holder.image_movie)

        holder.txt_name.text = movieList[position].name
        holder.txt_team.text = movieList[position].team
        holder.txt_creeatedby.text = movieList[position].createdby

    }

    class MovieViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
        var image_movie : ImageView
        var txt_name : TextView
        var txt_team : TextView
        var txt_creeatedby : TextView

        init {
            image_movie = itemView.image_movie
            txt_name = itemView.txt_name
            txt_team = itemView.txt_team
            txt_creeatedby = itemView.txt_createdby
        }
    }
}