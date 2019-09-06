package com.lambdaschool.pokemonapi.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lambdaschool.pokemonapi.R
import com.lambdaschool.pokemonapi.adapter.PokemonListAdapter
import com.lambdaschool.pokemonapi.model.Pokemon
import com.lambdaschool.pokemonapi.retrofit.PokemonAPI
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), Callback<Pokemon> {

    private val listOfPokemon = mutableListOf<Pokemon>()
    lateinit var pokemonServices: PokemonAPI

    companion object {
        const val POKEMON_DETAILS_REQUEST_KEY = "IUH9-08UBHQPI9FGH134UT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pokemonServices = PokemonAPI.Factory.create()

        btn_search.setOnClickListener {
            val searchText = et_search.text
            if (searchText.isDigitsOnly()) {
                getPokemonById(searchText.toString().toInt())
            } else {
                getPokemonByName(searchText.toString())
            }
        }

        list_view.setHasFixedSize(true)
        val manager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val adapter = PokemonListAdapter(listOfPokemon)
        list_view.layoutManager = manager
        list_view.adapter = adapter
    }

    private fun getPokemonByName(pokemonName: String) {
        pokemonServices.getPokemonByName(pokemonName).enqueue(this)
    }

    private fun getPokemonById(pokemonId: Int) {
        pokemonServices.getPokemonById(pokemonId).enqueue(this)
    }

    override fun onFailure(call: Call<Pokemon>, t: Throwable) {
        t.printStackTrace()
        val response = "faliure; ${t.printStackTrace()}"
        Toast.makeText(this@MainActivity, response, Toast.LENGTH_SHORT).show()
    }

    override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
        if (response.isSuccessful) {
            val pokemonDetails = response.body()
            val pokeName = pokemonDetails?.name
            val pokeSprites = pokemonDetails?.sprites
            val pokeId = pokemonDetails?.id
            val pokeAbilities = pokemonDetails?.abilities
            val pokeTypes = pokemonDetails?.types

            val elementNumber = listOfPokemon.size
            listOfPokemon.add(Pokemon(pokeName, pokeSprites, pokeId, pokeAbilities, pokeTypes))
            list_view.adapter?.notifyDataSetChanged()

            val intentDetail = Intent(this, DetailActivity::class.java)
            intentDetail.putExtra(POKEMON_DETAILS_REQUEST_KEY, listOfPokemon[elementNumber])
            startActivity(intentDetail)
        } else {
            val response = "response not successful; ${response.errorBody().toString()}"
            Toast.makeText(this@MainActivity, response, Toast.LENGTH_SHORT).show()
        }
    }
}
