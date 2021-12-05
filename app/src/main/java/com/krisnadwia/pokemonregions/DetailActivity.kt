package com.krisnadwia.pokemonregions

import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity() {

    companion object {
        // define extra
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_IMAGE = "extra_image"
        const val EXTRA_PROFESSOR = "extra_professor"
        const val EXTRA_NUMBER_OF_POKEMON = "extra_number_of_pokemon"
        const val EXTRA_STARTER_POKEMON = "extra_starter_pokemon"
        const val EXTRA_RIVALS = "extra_rivals"
        const val EXTRA_CRIME_ORGANIZATION = "extra_crime_organization"
        const val EXTRA_ANIME_SAGA = "extra_anime_saga"
        const val EXTRA_MANGA_ARCS = "extra_manga_arcs"
        const val EXTRA_REGION = "extra_region"
        const val EXTRA_CITIES_AND_TOWNS = "extra_cities_and_towns"
        const val EXTRA_ISLAND = "extra_island"
        const val EXTRA_OTHER_LOCATIONS = "extra_other_locations"
        const val EXTRA_AREAS_OF_INTEREST = "extra_areas_of_interest"
        const val EXTRA_LANDMARKS = "extra_landmarks"
        const val EXTRA_PLACES_OF_INTEREST = "extra_places_of_interest"
        const val EXTRA_REFERENCES = "extra_references"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // fetch id at view
        val imgImage = findViewById<ImageView>(R.id.img_full_thumbnail)
        val tvProfessor = findViewById<TextView>(R.id.tv_professor_value)
        val tvNumberOfPokemon = findViewById<TextView>(R.id.tv_number_of_pokemon_value)
        val tvStarterPokemon = findViewById<TextView>(R.id.tv_starter_pokemon_value)
        val tvRivals = findViewById<TextView>(R.id.tv_rivals_value)
        val tvCrimeOrganization = findViewById<TextView>(R.id.tv_crime_organization_value)
        val tvAnimeSaga = findViewById<TextView>(R.id.tv_anime_saga_value)
        val tvMangaArcs = findViewById<TextView>(R.id.tv_manga_arcs_value)
        val tvRegion = findViewById<TextView>(R.id.tv_region_value)
        val tvCitiesAndTowns = findViewById<TextView>(R.id.tv_cities_and_towns_value)
        val tvIsland = findViewById<TextView>(R.id.tv_island_value)
        val tvOtherLocations = findViewById<TextView>(R.id.tv_other_locations_value)
        val tvAreasOfInterest = findViewById<TextView>(R.id.tv_areas_of_interest_value)
        val tvLandmarks = findViewById<TextView>(R.id.tv_landmarks_value)
        val tvPlacesOfInterest = findViewById<TextView>(R.id.tv_places_of_interest_value)
        val tvReferences = findViewById<TextView>(R.id.tv_references_value)

        // get item data
        val name = intent.getStringExtra(EXTRA_NAME)
        val image = intent.getIntExtra(EXTRA_IMAGE, 0)
        val professor = intent.getStringExtra(EXTRA_PROFESSOR)
        val numberOfPokemon = intent.getStringExtra(EXTRA_NUMBER_OF_POKEMON)
        val starterPokemon = intent.getStringExtra(EXTRA_STARTER_POKEMON)
        val rivals = intent.getStringExtra(EXTRA_RIVALS)
        val crimeOrganization = intent.getStringExtra(EXTRA_CRIME_ORGANIZATION)
        val animeSaga = intent.getStringExtra(EXTRA_ANIME_SAGA)
        val mangaArcs = intent.getStringExtra(EXTRA_MANGA_ARCS)
        val region = intent.getStringExtra(EXTRA_REGION)
        val citiesAndTowns = intent.getStringExtra(EXTRA_CITIES_AND_TOWNS)
        val island = intent.getStringExtra(EXTRA_ISLAND)
        val otherLocations = intent.getStringExtra(EXTRA_OTHER_LOCATIONS)
        val areasOfInterest = intent.getStringExtra(EXTRA_AREAS_OF_INTEREST)
        val landmarks = intent.getStringExtra(EXTRA_LANDMARKS)
        val placesOfInterest = intent.getStringExtra(EXTRA_PLACES_OF_INTEREST)
        val references = intent.getStringExtra(EXTRA_REFERENCES)

        // set data to view
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = name

        Glide.with(this)
            .load(image)
            .apply(RequestOptions().override(336, 188))
            .into(imgImage)
        tvProfessor.text = professor
        tvNumberOfPokemon.text = numberOfPokemon
        tvStarterPokemon.text = starterPokemon
        tvRivals.text = rivals
        tvCrimeOrganization.text = crimeOrganization
        tvAnimeSaga.text = animeSaga
        tvMangaArcs.text = mangaArcs
        tvRegion.text = region
        tvCitiesAndTowns.text = citiesAndTowns
        tvIsland.text = island
        tvOtherLocations.text = otherLocations
        tvAreasOfInterest.text = areasOfInterest
        tvLandmarks.text = landmarks
        tvPlacesOfInterest.text = placesOfInterest
        tvReferences.text = Html.fromHtml(references)
        tvReferences.movementMethod = LinkMovementMethod.getInstance()
    }
}