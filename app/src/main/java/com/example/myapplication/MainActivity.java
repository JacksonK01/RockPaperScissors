package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GameSubject subject;
    Strategy currentStrategy;
    String previousToggled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        previousToggled = "Random";

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        subject = new GameSubject();

        subject.registerObserver((game) -> {
            Item item1 = game.getItem1();
            Item item2 = game.getItem2();
            if (item1 instanceof Paper && item2 instanceof Rock) {
                game.setWinner(item1.getName());
            } else if (item2 instanceof Paper && item1 instanceof Rock) {
                game.setWinner(item2.getName());
            }
        });

        subject.registerObserver((game) -> {
            Item item1 = game.getItem1();
            Item item2 = game.getItem2();
            if (item1 instanceof Scissor && item2 instanceof Paper) {
                game.setWinner(item1.getName());
            } else if(item2 instanceof Scissor && item1 instanceof Paper) {
                game.setWinner(item2.getName());
            }
        });

        subject.registerObserver((game) -> {
            Item item1 = game.getItem1();
            Item item2 = game.getItem2();
            if (item1 instanceof Rock && item2 instanceof Scissor) {
                game.setWinner(item1.getName());
            } else if (item2 instanceof Rock && item1 instanceof Scissor) {
                game.setWinner(item2.getName());
            }
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

        //AI Toggle
        ToggleButton aiToggle = findViewById(R.id.aiToggle);
        TextView aiModeLabel = findViewById(R.id.aiModeLabel);
        aiToggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            aiModeLabel.setText("AI Mode: " + (isChecked ? "Reflect" : "Random"));
        });

        currentStrategy = new StrategySelector().selectStrategy(previousToggled);

        goButton.setOnClickListener(v -> {
            String selectedToggle = aiToggle.getText().toString();
            if(!previousToggled.equals(selectedToggle)) {
                currentStrategy = new StrategySelector().selectStrategy(selectedToggle);
            }
            previousToggled = selectedToggle;

            Item userItem = (Item) spinner.getSelectedItem();
            aiToggle.getText();
            Item cpuItem = currentStrategy.getItem();

            Game game = new Game(userItem, cpuItem);
            subject.setGame(game);
            subject.notifyObservers();

            String result;
            String winner = game.getWinner();
            if (winner.equals(userItem.getName())) {
                result = "You win!";
            }
            else if (winner.equals(cpuItem.getName())) {
                result = "CPU wins!";
            }
            else {
                result = "It's a draw!";
            }

            currentStrategy.afterTurn(userItem);

            resultText.setText("You: " + userItem.getName()
                    + " | CPU: " + cpuItem.getName()
                    + "\n" + result);
        });
    }
}