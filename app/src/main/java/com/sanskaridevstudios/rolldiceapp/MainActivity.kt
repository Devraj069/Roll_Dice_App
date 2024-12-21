package com.sanskaridevstudios.rolldiceapp

import android.media.Image
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val rollDice:Button = findViewById(R.id.roll_dice)
        //Setting up on click listener
        rollDice.setOnClickListener {
//            Toast.makeText(this,"Button Clicked",Toast.LENGTH_SHORT).show()
            rolledDice()
        }
    }

    private fun rolledDice() {
        val diceImage : ImageView = findViewById(R.id.dice_image)

        //Getting a Random value
        var randomNum : Int = Random().nextInt(6) + 1
        //Combine image with random value and it return image
        var drawableResource = when(randomNum){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else ->R.drawable.dice_6
        }
        //Setting up image resource
        diceImage.setImageResource(drawableResource)

    }
}