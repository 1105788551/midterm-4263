package com.example.androidmidterm

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.androidmidterm.R
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Volley uses internet permissions which needs to be enabled in the AndroidManifest.xml
        val queue = Volley.newRequestQueue(this)

        // OU Calendar url
        // TODO: change this to your url after you have endpoin

         val jsonObject = JSONObject()
        jsonObject.put("kloc", "3")
        jsonObject.put("model", "1")
        jsonObject.put("q1", "1")
        jsonObject.put("q2", "1")
        jsonObject.put("q3", "1")
        jsonObject.put("q4", "1")
        jsonObject.put("q5", "1")
        jsonObject.put("q6", "1")
        jsonObject.put("q7", "1")
        jsonObject.put("q8", "1")
        jsonObject.put("q9", "1")
        jsonObject.put("q10", "1")
        jsonObject.put("q11", "1")
        jsonObject.put("q12", "1")
        jsonObject.put("q13", "1")
        jsonObject.put("q14", "1")
        jsonObject.put("q15", "1")

        // OU calendar returns a Json Array, if your website returns a Json Object then use JsonObjectRequest
        val url = "https://phrasal-bond-292319.uc.r.appspot.com/"

        // OU calendar returns a Json Array, if your website returns a Json Object then use JsonObjectRequest
        val stringRequest = JsonObjectRequest(Request.Method.POST, url, jsonObject,
                Response.Listener<JSONObject> { response ->
                    val event = response
                    // eventTitle is the id for the textbox in activity_main.xml
                    eventTitle.text = "Event title is : ${event.toString()}"
                },
                Response.ErrorListener { error -> eventTitle.text = error.message })


        // button is the id for the button in activity_main.xml
        button.setOnClickListener {
            queue.add(stringRequest)
        }
    }
}
