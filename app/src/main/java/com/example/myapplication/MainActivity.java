package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String outcomeText; //I'll connect this to the GUI somehow

        Item item1 = new Paper();
        Item item2 = new Rock();
        Item item3 = new Scissor();

        //Paper vs Rock
        if(item1.getWeight() < item2.getWeight()) {
            System.out.println(item1.getName() + " Wins");
            outcomeText = item1.getName() + " Wins";
        }

        //Rock vs Scissor
        if(item2.getThickness() > item3.getSharpness()) {
            System.out.println(item2.getName() + " Wins");
            outcomeText = item2.getName() + " Wins";
        }

        //Paper vs Scissors
        if(item3.getSharpness() > item1.getSharpness()) {
            System.out.println(item3.getName() + " Wins");
            outcomeText = item3.getName() + " Wins";
        }

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}