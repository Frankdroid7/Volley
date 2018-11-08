package com.example.franklin.trende.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.franklin.trende.R
import com.example.franklin.trende.adapters.RecyclerViewAdapter
import com.example.franklin.trende.models.Anime
import kotlinx.android.synthetic.main.activity_volley.*
import org.json.JSONArray
import org.json.JSONException

class Volley : AppCompatActivity() {

    val JSON_URL = "https://gist.githubusercontent.com/aws1994/f583d54e5af8e56173492d3f60dd5ebf/raw/c7796ba51d5a0d37fc756cf0fd14e54434c547bc/anime.json"
    val lstAnime = ArrayList<Anime>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volley)

        pgb.visibility = View.VISIBLE

        jsoncall()


    }

    fun jsoncall() {


        val request = JsonArrayRequest(JSON_URL, Response.Listener<JSONArray> { response ->


            var jsonObject = null


            for (i in 0 until response.length()) {

                //Toast.makeText(getApplicationContext(),String.valueOf(i),Toast.LENGTH_SHORT).show();

                try {

                    var jsonObject = response.getJSONObject(i)


                    var name = jsonObject.getString("name")
                    var rating = jsonObject.getString("Rating")
                    var desc = jsonObject.getString("description")
                    var nb_epidode = jsonObject.getInt("episode")
                    var img_url = jsonObject.getString("img")
                    var studio = jsonObject.getString("studio")
                    var categorie = jsonObject.getString("categorie")
                    var anime = Anime(name, rating, desc, nb_epidode, studio, categorie, img_url)

                    anime.name = jsonObject.getString("name")
                    anime.rating = jsonObject.getString("Rating")
                    anime.description = jsonObject.getString("description")
                    anime.nb_episode = jsonObject.getInt("episode")
                    anime.image_url = jsonObject.getString("img")
                    anime.studio = jsonObject.getString("studio")
                    anime.categorie = jsonObject.getString("categorie")
                    //Toast.makeText(MainActivity.this,anime.toString(),Toast.LENGTH_SHORT).show();
                    lstAnime.add(anime)
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }


            pgb.visibility = View.GONE
            setRecycler(lstAnime)

        }, Response.ErrorListener {

            pgb.visibility = View.GONE
            tv.text = it.toString()


        })

        val requestQueue = Volley.newRequestQueue(this).add(request)

    }

    fun setRecycler(lstAnime: ArrayList<Anime>) {
        var myadapter = RecyclerViewAdapter(this,lstAnime)
        recyclerviewid.layoutManager = LinearLayoutManager(this)
        recyclerviewid.adapter = myadapter
    }

}
