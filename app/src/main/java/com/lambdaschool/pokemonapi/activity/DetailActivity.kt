package com.lambdaschool.pokemonapi.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lambdaschool.pokemonapi.R
import com.lambdaschool.pokemonapi.model.PokemonSerial
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val data = intent.getSerializableExtra(MainActivity.POKEMON_DETAILS_REQUEST_KEY) as PokemonSerial
        var abilityString = ""

        data.ability.forEach {
            abilityString += it + "\n"
        }

        tv_name.text = data.name
        tv_id.text = "No." + data.id.toString()
        tv_type_1.text = data.type[0]

        if (data.type.size > 1) {
            tv_type_2.text = data.type[1]
        }

        tv_abilities.text = abilityString
        Picasso.get().load(data.sprites).into(iv_sprite)
    }
}
