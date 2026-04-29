package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GameSubject subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        subject = new GameSubject();

        // Paper beats Rock
        subject.registerObserver(game -> {
            if (game.getItem1() instanceof Paper && game.getItem2() instanceof Rock)
                game.setP1Score(game.getP1Score() + 1);
            else if (game.getItem1() instanceof Rock && game.getItem2() instanceof Paper)
                game.setP2Score(game.getP2Score() + 1);
        });

        // Rock beats Scissors
        subject.registerObserver(game -> {
            if (game.getItem1() instanceof Rock && game.getItem2() instanceof Scissor)
                game.setP1Score(game.getP1Score() + 1);
            else if (game.getItem1() instanceof Scissor && game.getItem2() instanceof Rock)
                game.setP2Score(game.getP2Score() + 1);
        });

        // Scissors beats Paper
        subject.registerObserver(game -> {
            if (game.getItem1() instanceof Scissor && game.getItem2() instanceof Paper)
                game.setP1Score(game.getP1Score() + 1);
            else if (game.getItem1() instanceof Paper && game.getItem2() instanceof Scissor)
                game.setP2Score(game.getP2Score() + 1);
        });

        // Set up spinner
        List<Item> items = new ArrayList<>();
        items.add(new Rock());
        items.add(new Paper());
        items.add(new Scissor());

        ArrayAdapter<Item> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                items
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = findViewById(R.id.itemSpinner);
        spinner.setAdapter(adapter);

        TextView resultText = findViewById(R.id.resultText);
        Button goButton = findViewById(R.id.goButton);

        goButton.setOnClickListener(v -> {
            Item userItem = (Item) spinner.getSelectedItem();
            Item cpuItem = new RandomStrategy().getItem();

            Game game = new Game(userItem, cpuItem);
            subject.setGame(game);
            subject.notifyObservers();

            String result;
            if      (game.getP1Score() > game.getP2Score()) result = "You win!";
            else if (game.getP2Score() > game.getP1Score()) result = "CPU wins!";
            else                                             result = "It's a draw!";

            resultText.setText("You: " + userItem.getName()
                    + " | CPU: " + cpuItem.getName()
                    + "\n" + result);
        });
    }
}