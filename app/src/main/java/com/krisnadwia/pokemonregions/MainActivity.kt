package com.krisnadwia.pokemonregions

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.krisnadwia.pokemonregions.adapter.ListRegionAdapter
import com.krisnadwia.pokemonregions.data.RegionsData
import com.krisnadwia.pokemonregions.model.Region

class MainActivity : AppCompatActivity() {
    private lateinit var rvRegions: RecyclerView
    private var list: ArrayList<Region> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvRegions = findViewById(R.id.rv_regions)
        rvRegions.setHasFixedSize(true)

        list.addAll(RegionsData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvRegions.layoutManager = LinearLayoutManager(this)
        val listRegionAdapter = ListRegionAdapter(list)
        rvRegions.adapter = listRegionAdapter
    }

    // make menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // onclick menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    // what menu does when clicked
    private fun setMode(selectedMode: Int) {
        if (selectedMode == R.id.menu_about) {
            val profileIntent = Intent(this@MainActivity, ProfileActivity::class.java)
            startActivity(profileIntent)
        }
    }
}