package com.example.animequotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        nextQuote.setOnClickListener(){
            nextQuoteFunction()
        }
        nextQuoteFunction()

    }

    private fun nextQuoteFunction() {


        val url = "https://animechan.vercel.app/api/random"


        val queue= Volley.newRequestQueue(this)


        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
                val animename="Anime Name :-" + response.getString("anime")
                val animecharacter= "Character Name :-" + response.getString("character")
                val quotes="Character Quote :-" +response.getString("quote")

                animeName.text= animename.toString()
                animeCharacterName.text= animecharacter.toString()
                animeQuote.text= quotes.toString()

            },
            { error ->
                Toast.makeText(this,"error in fetching data ", Toast.LENGTH_SHORT).show()
            }
        )
        queue.add(jsonObjectRequest)


    }
}