package com.example.baguiobluezone.foodhub.smartfood

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.baguiobluezone.R

class SmartFoodActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.smartfood)


        // SearchView setup
        val searchView = findViewById<SearchView>(R.id.search_view)

        // Ingredients categorized
        val vegetableList = listOf("carrots", "spinach", "garlic", "beans", "chili", "cabbage", "squash", "onion", "cabbage", "corn")
        val fruitList = listOf("apple", "orange", "lemon", "kiwi", "melon")
        val grainList = listOf("rice", "pasta", "bread", "potato", "oats")
        val proteinList = listOf("chicken", "beef", "pork", "tofu", "eggs")
        val condimentList = listOf("soy", "vinegar", "salt", "honey", "mayo")

        // Set up SearchView listener
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    when {
                        vegetableList.any { vegetable -> vegetable.equals(it, true) } -> {
                            Toast.makeText(this@SmartFoodActivity, "$it is in Vegetables", Toast.LENGTH_SHORT).show()
                        }
                        fruitList.any { fruit -> fruit.equals(it, true) } -> {
                            Toast.makeText(this@SmartFoodActivity, "$it is in Fruits", Toast.LENGTH_SHORT).show()
                        }
                        grainList.any { grain -> grain.equals(it, true) } -> {
                            Toast.makeText(this@SmartFoodActivity, "$it is in Grains", Toast.LENGTH_SHORT).show()
                        }
                        proteinList.any { protein -> protein.equals(it, true) } -> {
                            Toast.makeText(this@SmartFoodActivity, "$it is in Proteins", Toast.LENGTH_SHORT).show()
                        }
                        condimentList.any { condiment -> condiment.equals(it, true) } -> {
                            Toast.makeText(this@SmartFoodActivity, "$it is in Condiments", Toast.LENGTH_SHORT).show()
                        }
                        else -> {
                            Toast.makeText(this@SmartFoodActivity, "$it is not available", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // Optional: Add live search or filtering logic here
                return false
            }
        })

        // Find the views for toggling
        val toggleVegButton = findViewById<Button>(R.id.toggle_btn)
        val toggleFruitButton = findViewById<Button>(R.id.toggle1_btn)
        val toggleGrainButton = findViewById<Button>(R.id.toggle2_btn)
        val toggleProteinButton = findViewById<Button>(R.id.toggle3_btn)
        val toggleCondimentsButton = findViewById<Button>(R.id.toggle4_btn)

        // Find the LinearLayouts to control visibility
        val vegExtsnLayout = findViewById<LinearLayout>(R.id.veg_extsn)
        val fruitExtsnLayout = findViewById<LinearLayout>(R.id.fruit_extsn)
        val grainExtsnLayout = findViewById<LinearLayout>(R.id.gas_extsn)
        val prtnExtsnLayout = findViewById<LinearLayout>(R.id.prtn_extsn)
        val cndmntsExtsnLayout = findViewById<LinearLayout>(R.id.cdmnts_extsn)


        // Initially hide the additional layouts
        vegExtsnLayout.visibility = View.GONE
        fruitExtsnLayout.visibility = View.GONE
        grainExtsnLayout.visibility = View.GONE
        prtnExtsnLayout.visibility = View.GONE
        cndmntsExtsnLayout.visibility = View.GONE

        // Set listeners for the toggle buttons
        toggleVegButton.setOnClickListener {
            if (vegExtsnLayout.visibility == View.GONE) {
                vegExtsnLayout.visibility = View.VISIBLE
                toggleVegButton.setBackgroundResource(R.drawable.buttonup)
            } else {
                vegExtsnLayout.visibility = View.GONE
                toggleVegButton.setBackgroundResource(R.drawable.buttonbg)
            }
        }

        toggleFruitButton.setOnClickListener {
            if (fruitExtsnLayout.visibility == View.GONE) {
                fruitExtsnLayout.visibility = View.VISIBLE
                toggleFruitButton.setBackgroundResource(R.drawable.buttonup)
            } else {
                fruitExtsnLayout.visibility = View.GONE
                toggleFruitButton.setBackgroundResource(R.drawable.buttonbg)
            }
        }

        toggleGrainButton.setOnClickListener {
            if (grainExtsnLayout.visibility == View.GONE) {
                grainExtsnLayout.visibility = View.INVISIBLE
                toggleGrainButton.setBackgroundResource(R.drawable.buttonup)
            } else {
                grainExtsnLayout.visibility = View.GONE
                toggleGrainButton.setBackgroundResource(R.drawable.buttonbg)
            }
        }

        toggleProteinButton.setOnClickListener {
            if (prtnExtsnLayout.visibility == View.GONE) {
                prtnExtsnLayout.visibility = View.INVISIBLE
                toggleProteinButton.setBackgroundResource(R.drawable.buttonup)
            } else {
                prtnExtsnLayout.visibility = View.GONE
                toggleProteinButton.setBackgroundResource(R.drawable.buttonbg)
            }
        }

        toggleCondimentsButton.setOnClickListener {
            if (cndmntsExtsnLayout.visibility == View.GONE) {
                cndmntsExtsnLayout.visibility = View.INVISIBLE
                toggleCondimentsButton.setBackgroundResource(R.drawable.buttonup)
            } else {
                cndmntsExtsnLayout.visibility = View.GONE
                toggleCondimentsButton.setBackgroundResource(R.drawable.buttonbg)
            }
        }
    }
}
