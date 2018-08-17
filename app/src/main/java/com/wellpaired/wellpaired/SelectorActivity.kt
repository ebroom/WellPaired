package com.wellpaired.wellpaired

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_selector.*

class SelectorActivity : AppCompatActivity() {

    lateinit var selectorViewModel: SelectorViewModel

    val clickListener = View.OnClickListener { view ->
        when (view.id) {
            R.id.wine_tv -> startFoodActivity(0)
            R.id.beer_tv -> startFoodActivity(1)
            R.id.both_tv -> startFoodActivity(2)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selector)
        selectorViewModel = createViewModel()
        addOnClickListeners()
    }

    private fun createViewModel(): SelectorViewModel {
        return ViewModelProviders.of(this).get(SelectorViewModel::class.java)
    }

    private fun addOnClickListeners() {
        wine_tv.setOnClickListener(clickListener)
        beer_tv.setOnClickListener(clickListener)
        both_tv.setOnClickListener(clickListener)
    }

    private fun startFoodActivity(type: Int) {
        val intent = Intent(this, FoodActivity::class.java)
        intent.putExtra("wineOrBeer", type)
        startActivity(intent)
    }
}
