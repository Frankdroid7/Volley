package com.example.franklin.trende

import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.ImageRequest
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.franklin.trende.models.Anime
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    var isFragmentOneLoaded = 1
    val manager = supportFragmentManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportActionBar!!.hide()

        showFragmentOne()


        btn_change_1.setOnClickListener {

            if (isFragmentOneLoaded == 2 || isFragmentOneLoaded == 3) {
                showFragmentOne()
            }
        }
        btn_change_2.setOnClickListener {

            if (isFragmentOneLoaded == 1 || isFragmentOneLoaded == 3) {

                showFragmentTwo()
            }

        }

        btn_change_3.setOnClickListener {

            if (isFragmentOneLoaded == 1 || isFragmentOneLoaded == 2) {

                showFragmentThree()
            }

        }


//        val queue = Volley.newRequestQueue(this)
//        val url = "https://imgur.com/gallery/8vwSLb7"
//
//        butt.setOnClickListener {
//            pb.visibility = View.VISIBLE
//            val imageRequest = ImageRequest(url, Response.Listener<Bitmap> { response ->
//                        imgv.setImageBitmap(response)
//                pb.visibility = View.GONE },0,0,null,Response.ErrorListener {
//                tv.text = "Something went wrong!"
//                pb.visibility = View.GONE
//            })
//
//            queue.add(imageRequest)
//        }


    }


    fun showFragmentOne() {
        val transaction = manager.beginTransaction()
        val fragment = FragmentOne()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded = 1
    }


    fun showFragmentTwo() {
        val transaction = manager.beginTransaction()
        val fragment = FragmentTwo()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded = 2
    }

    fun showFragmentThree() {
        val transaction = manager.beginTransaction()
        val fragment = FragmentThree()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded = 3
    }


}
