package com.example.pizzaparty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlin.math.ceil
import android.widget.RadioGroup

//define constant value for the pizza slices
const val SLICES_PER_PIZZA = 8

/**
 * MainActivity
 *
 * @constructor Create empty MainActivity
 */

class MainActivity : AppCompatActivity() {

    //private variable to store the value of EditText, TextView and RadioGroup
    private lateinit var numAttendEditText: EditText
    private lateinit var numPizzasTextView: TextView
    private lateinit var howHungryRadioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numAttendEditText = findViewById(R.id.num_attend_edit_text)
        numPizzasTextView = findViewById(R.id.num_pizzas_text_view)
        howHungryRadioGroup = findViewById(R.id.hungry_radio_group)
    }

    /**
     * CalculateClick
     *
     * this function will calculate the total number of pizzas needed for the certain people.
     * this function will ask value of total number of people and the ratio of hunger and it will calculate total pizzas.
     *
     *@param view
     */

    fun calculateClick(view: View) {
        //get the value of the EditText
        // Get the text that was typed into the EditText
        val numAttendStr = numAttendEditText.text.toString()

        // Convert the text into an integer
        val numAttend = numAttendStr.toInt()

        // Determine how many slices on average each person will eat based on hunger
        val slicesPerPerson = when (howHungryRadioGroup.checkedRadioButtonId) {
            R.id.light_radio_button -> 2
            R.id.medium_radio_button -> 3
            else -> 4
        }

        // Calculate and show the total number of pizzas needed
        val totalPizzas = ceil(numAttend * slicesPerPerson / SLICES_PER_PIZZA.toDouble()).toInt()
        numPizzasTextView.text = "Total pizzas: $totalPizzas"
    }
}
