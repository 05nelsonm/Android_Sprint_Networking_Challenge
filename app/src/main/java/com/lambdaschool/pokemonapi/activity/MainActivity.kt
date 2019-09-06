package com.lambdaschool.pokemonapi.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lambdaschool.pokemonapi.R
import com.lambdaschool.pokemonapi.adapter.PokemonListAdapter
import com.lambdaschool.pokemonapi.model.Pokemon
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val listOfPokemon = mutableListOf<Pokemon>()

    companion object {
        const val POKEMON_DETAILS_REQUEST_KEY = "IUH9-08UBHQPI9FGH134UT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listOfPokemon.add(Pokemon("random name", ArrayList(),"", ArrayList(),ArrayList() ))
        listOfPokemon.add(Pokemon("random name", ArrayList(),"", ArrayList(),ArrayList() ))
        listOfPokemon.add(Pokemon("random name", ArrayList(),"", ArrayList(),ArrayList() ))
        listOfPokemon.add(Pokemon("random name", ArrayList(),"", ArrayList(),ArrayList() ))
        listOfPokemon.add(Pokemon("random name", ArrayList(),"", ArrayList(),ArrayList() ))
        listOfPokemon.add(Pokemon("random name", ArrayList(),"", ArrayList(),ArrayList() ))
        listOfPokemon.add(Pokemon("random name", ArrayList(),"", ArrayList(),ArrayList() ))
        listOfPokemon.add(Pokemon("random name", ArrayList(),"", ArrayList(),ArrayList() ))
        listOfPokemon.add(Pokemon("random name", ArrayList(),"", ArrayList(),ArrayList() ))
        listOfPokemon.add(Pokemon("random name", ArrayList(),"", ArrayList(),ArrayList() ))
        listOfPokemon.add(Pokemon("random name", ArrayList(),"", ArrayList(),ArrayList() ))
        listOfPokemon.add(Pokemon("random name", ArrayList(),"", ArrayList(),ArrayList() ))
        listOfPokemon.add(Pokemon("random name", ArrayList(),"", ArrayList(),ArrayList() ))
        listOfPokemon.add(Pokemon("random name", ArrayList(),"", ArrayList(),ArrayList() ))
        listOfPokemon.add(Pokemon("random name", ArrayList(),"", ArrayList(),ArrayList() ))
        listOfPokemon.add(Pokemon("random name", ArrayList(),"", ArrayList(),ArrayList() ))
        listOfPokemon.add(Pokemon("random name", ArrayList(),"", ArrayList(),ArrayList() ))
        listOfPokemon.add(Pokemon("random name", ArrayList(),"", ArrayList(),ArrayList() ))
        listOfPokemon.add(Pokemon("random name", ArrayList(),"", ArrayList(),ArrayList() ))

        list_view.setHasFixedSize(true)
        val manager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val adapter = PokemonListAdapter(listOfPokemon)
        list_view.layoutManager = manager
        list_view.adapter = adapter
    }
}
