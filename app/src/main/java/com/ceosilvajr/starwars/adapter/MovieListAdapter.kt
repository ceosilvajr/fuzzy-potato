package com.ceosilvajr.starwars.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.ceosilvajr.models.Movie
import com.ceosilvajr.starwars.R
import com.ceosilvajr.starwars.extensions.toMoney
import kotlinx.android.synthetic.main.item_movie.view.*

/**
 * @author ceosilvajr@gmail.com
 */
class MovieListAdapter(private val items: ArrayList<Movie>) : RecyclerView.Adapter<MovieListAdapter.AdapterViewHolder>() {

    private lateinit var context: Context
    private lateinit var listener: Listener

    fun init(context: Context, listener: Listener) {
        this.context = context
        this.listener = listener
    }

    fun updateList(items: ArrayList<Movie>) {
        this.items.clear()
        this.items.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        if (!::context.isInitialized || !::listener.isInitialized) throw RuntimeException()
        return AdapterViewHolder(LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        val model = items[position]
        holder.itemView.setOnClickListener { listener.onMovieItemClicked(model) }
        holder.displayView(model)
    }


    inner class AdapterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val image = view.iv_banner!!
        private val price = view.tv_price!!
        private val genre = view.tv_genre!!
        private val name = view.tv_name!!
        fun displayView(model: Movie) {
            image.load(model.artwork) {
                placeholder(R.drawable.img_movie_placeholder)
            }
            name.text = model.name
            genre.text = model.genre
            price.text = model.price.toMoney()
        }
    }

    interface Listener {
        fun onMovieItemClicked(movie: Movie)
    }

}