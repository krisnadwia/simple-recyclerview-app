package com.krisnadwia.pokemonregions.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.krisnadwia.pokemonregions.DetailActivity
import com.krisnadwia.pokemonregions.R
import com.krisnadwia.pokemonregions.model.Region

class ListRegionAdapter(private val listRegion: ArrayList<Region>) :
    RecyclerView.Adapter<ListRegionAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_region, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val region = listRegion[position]

        Glide.with(holder.itemView.context)
            .load(region.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)

        holder.tvName.text = region.name
        holder.tvDetail.text = region.detail

        // intent with data for detail
        val context = holder.itemView.context
        holder.itemView.setOnClickListener {
            val itemDetailIntent = Intent(context, DetailActivity::class.java)
            itemDetailIntent.putExtra(DetailActivity.EXTRA_NAME, region.name)
            itemDetailIntent.putExtra(DetailActivity.EXTRA_IMAGE, region.image)
            itemDetailIntent.putExtra(DetailActivity.EXTRA_PROFESSOR, region.professor)
            itemDetailIntent.putExtra(
                DetailActivity.EXTRA_NUMBER_OF_POKEMON,
                region.numberOfPokemon
            )
            itemDetailIntent.putExtra(DetailActivity.EXTRA_STARTER_POKEMON, region.starterPokemon)
            itemDetailIntent.putExtra(DetailActivity.EXTRA_RIVALS, region.rivals)
            itemDetailIntent.putExtra(
                DetailActivity.EXTRA_CRIME_ORGANIZATION,
                region.crimeOrganization
            )
            itemDetailIntent.putExtra(DetailActivity.EXTRA_ANIME_SAGA, region.animeSaga)
            itemDetailIntent.putExtra(DetailActivity.EXTRA_MANGA_ARCS, region.mangaArcs)
            itemDetailIntent.putExtra(DetailActivity.EXTRA_REGION, region.region)
            itemDetailIntent.putExtra(DetailActivity.EXTRA_CITIES_AND_TOWNS, region.citiesAndTowns)
            itemDetailIntent.putExtra(DetailActivity.EXTRA_ISLAND, region.island)
            itemDetailIntent.putExtra(DetailActivity.EXTRA_OTHER_LOCATIONS, region.otherLocations)
            itemDetailIntent.putExtra(
                DetailActivity.EXTRA_AREAS_OF_INTEREST,
                region.areasOfInterest
            )
            itemDetailIntent.putExtra(DetailActivity.EXTRA_LANDMARKS, region.landmarks)
            itemDetailIntent.putExtra(
                DetailActivity.EXTRA_PLACES_OF_INTEREST,
                region.placesOfInterst
            )
            itemDetailIntent.putExtra(DetailActivity.EXTRA_REFERENCES, region.references)
            context.startActivity(itemDetailIntent)
        }
    }

    override fun getItemCount(): Int {
        return listRegion.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }
}