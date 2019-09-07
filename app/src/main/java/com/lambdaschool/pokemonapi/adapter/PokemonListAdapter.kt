package com.lambdaschool.pokemonapi.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lambdaschool.pokemonapi.R
import com.lambdaschool.pokemonapi.activity.DetailActivity
import com.lambdaschool.pokemonapi.activity.MainActivity
import com.lambdaschool.pokemonapi.model.PokemonSerial
import kotlinx.android.synthetic.main.card_view_layout.view.*

class PokemonListAdapter(val data: MutableList<PokemonSerial>) :
    RecyclerView.Adapter<PokemonListAdapter.ViewHolder>() {

    lateinit var context: Context

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val pokemonName: TextView = view.tv_pokemon_name
        val pokemonCard = view.cardview_pokemon
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewGroup = LayoutInflater.from(parent.context).inflate(R.layout.card_view_layout, parent, false)
        context = parent.context
        return ViewHolder(viewGroup)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // holder.image.setImageDrawable(data[position].image)
        holder.pokemonName.text = data[position].name

        holder.pokemonCard.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(MainActivity.POKEMON_DETAILS_REQUEST_KEY, data[position])
            (context as Activity).startActivity(intent)
        }
    }
}
