package com.zybooks.pizzaparty

import kotlin.math.ceil

/**
 * PizzaCalculator class for the Pizza Party app.
 *
 * This class calculates the number of pizzas needed for a party based on
 * the number of attendees and their hunger level.
 */

// Declares a constant named SLICES_PER_PIZZA with a value of 8
const val SLICES_PER_PIZZA = 8

class PizzaCalculator(partySize: Int, var hungerLevel: HungerLevel) {
    var partySize = 0 // Declares a variable named partySize initialized with a default value of 0
        // Defines a custom setter for the partySize property
        set(value) {
            field = if (value >= 0) value else 0 // Ensures that the value of partySize cannot be set to a negative number
        }

    // Defines an enum class named HungerLevel with three enum constants and associated properties
    enum class HungerLevel(var numSlices: Int) {
        LIGHT(2), MEDIUM(3), RAVENOUS(4)
    }

    // A getter method for dynamically calculating the total number of pizzas needed.
    val totalPizzas: Int
        // Defines a custom getter for the totalPizzas property
        get() {
            // Calculates the total number of pizzas needed for the pizza party
            return ceil(partySize * hungerLevel.numSlices / SLICES_PER_PIZZA.toDouble()).toInt()
        }

    // Initializes the newly created PizzaCalculator instance
    init {
        // Assigns the value of the partySize parameter to the partySize property
        this.partySize = partySize
    }
}