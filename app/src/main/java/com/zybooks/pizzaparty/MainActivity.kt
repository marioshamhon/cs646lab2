package com.zybooks.pizzaparty

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * MainActivity for the Pizza Party app.
 *
 * This activity allows users to get the number of pizzas needed for a party based on
 * the number of attendees and their hunger level.
 */

class MainActivity : AppCompatActivity() {

    private lateinit var numAttendEditText: EditText // Creating a reference to the edit text UI element
    private lateinit var numPizzasTextView: TextView // Creating a reference to the "total pizzas" text UI element
    private lateinit var howHungryRadioGroup: RadioGroup // Creating a reference to the Radio group UI element

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numAttendEditText = findViewById(R.id.num_attend_edit_text) // Finding the edit text UI element using its ID
        numPizzasTextView = findViewById(R.id.num_pizzas_text_view) // Finding the "total pizzas" text UI element using its ID
        howHungryRadioGroup = findViewById(R.id.hungry_radio_group) // Finding the radio group UI element using its ID
    }

    /**
     * Handles the click event for the calculate button.
     *
     * This function reads the number of attendees and their hunger level, gets the
     * total number of pizzas required, and displays the result.
     *
     * @param view The view that was clicked.
     */

    fun calculateClick(view: View) {

        // Get the text that was typed into the EditText
        val numAttendStr = numAttendEditText.text.toString()

        // Convert the text into an integer
        val numAttend = numAttendStr.toIntOrNull() ?: 0

        // Get hunger level selection
        val hungerLevel = when (howHungryRadioGroup.checkedRadioButtonId) {
            R.id.light_radio_button -> PizzaCalculator.HungerLevel.LIGHT
            R.id.medium_radio_button -> PizzaCalculator.HungerLevel.MEDIUM
            else -> PizzaCalculator.HungerLevel.RAVENOUS
        }

        // Get the number of pizzas needed
        val calc = PizzaCalculator(numAttend, hungerLevel)
        val totalPizzas = calc.totalPizzas

        // Place totalPizzas into the string resource and display
        val totalText = getString(R.string.total_pizzas_num, totalPizzas)
        numPizzasTextView.text = totalText
    }
}
