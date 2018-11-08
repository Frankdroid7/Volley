package com.example.franklin.trende.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.franklin.trende.R
import kotlinx.android.synthetic.main.activity_anime.*
import kotlinx.android.synthetic.main.anime_row_item.*

class AnimeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anime)

        supportActionBar!!.hide()


        val name = intent.getStringExtra("anime_name")
        val description = intent.getStringExtra("anime_description")
        val studio = intent.getStringExtra("anime_studio")
        val category = intent.getStringExtra("anime_category")
        val nb_episode = intent.getStringExtra("anime_nb_episode")
        val img = intent.getStringExtra("anime_img")
        val rating = intent.getStringExtra("anime_rating")


        collapsing_toolbar_id.isTitleEnabled = true
        collapsing_toolbar_id.title = name

        aa_anime_name.text = name
        aa_categorie.text = category
        aa_description.text = description
        aa_rating.text = rating
        aa_studio.text = studio
        aa_studio.text = studio


        val requestOption = RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape)

        Glide.with(this).load(img).apply(requestOption).into(aa_thumbnail)

    }
}
