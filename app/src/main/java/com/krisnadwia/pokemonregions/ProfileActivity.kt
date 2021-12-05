package com.krisnadwia.pokemonregions

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // set title
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.title = "Profile"
        }
        val imgPhotoProfileView = findViewById<ImageView>(R.id.img_profile_photo)
        val photoProfile: Int = R.drawable.profile_photo

        val imgPhotoBackgroundView = findViewById<ImageView>(R.id.img_background_photo)
        val photoBackground: Int = R.drawable.background_photo

        // set profile photo
        Glide.with(this)
            .load(photoProfile)
            .apply(RequestOptions().override(145, 145))
            .into(imgPhotoProfileView)

        Glide.with(this)
            .load(photoBackground)
            .apply(RequestOptions().override(145, 145))
            .into(imgPhotoBackgroundView)
    }
}