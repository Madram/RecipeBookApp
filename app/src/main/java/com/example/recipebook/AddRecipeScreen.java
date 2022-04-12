package com.example.recipebook;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class AddRecipeScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_recipe_screen);

        ArrayList<String> ingredientsArrayList = new ArrayList<>();
        ArrayList<String> stepsArrayList = new ArrayList<>();

        ArrayAdapter<String> ingredientsAdapter;
        ArrayAdapter<String> stepsAdapter;

        ListView ingredientsList;
        ListView stepsList;

        FloatingActionButton addIngredientButton = findViewById(R.id.add_ingredient);
        FloatingActionButton removeIngredientButton = findViewById(R.id.remove_ingredient);

        FloatingActionButton addStepButton = findViewById(R.id.add_step);
        FloatingActionButton removeStepButton = findViewById(R.id.remove_step);

        ExtendedFloatingActionButton readyToAddButton = findViewById(R.id.ready_to_add_button);

        TextInputEditText nameText = findViewById(R.id.nameEditText);
        TextInputEditText descriptionText = findViewById(R.id.descriptionEditText);
        TextInputEditText ingredientText = findViewById(R.id.ingredientsEditText);
        TextInputEditText stepsText = findViewById(R.id.stepsEditText);

        ingredientsList = findViewById(R.id.ingredients_list);
        stepsList = findViewById(R.id.steps_list);

        ingredientsAdapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1, ingredientsArrayList);
        ingredientsList.setAdapter(ingredientsAdapter);

        stepsAdapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1, stepsArrayList);
        stepsList.setAdapter(stepsAdapter);

        addIngredientButton.setOnClickListener(view -> {
            ingredientsArrayList.add(ingredientText.getText().toString());
            ingredientText.setText("");
            ingredientsAdapter.notifyDataSetChanged();
        });

        removeIngredientButton.setOnClickListener(view -> {
            if (ingredientsArrayList.size() > 0){
                ingredientsArrayList.remove(ingredientsArrayList.size() - 1);
            }
            ingredientsAdapter.notifyDataSetChanged();
        });

        addStepButton.setOnClickListener(view -> {
            stepsArrayList.add(stepsText.getText().toString());
            stepsText.setText("");
            stepsAdapter.notifyDataSetChanged();
        });

        removeStepButton.setOnClickListener(view -> {
            if (stepsArrayList.size() > 0){
                stepsArrayList.remove(stepsArrayList.size() - 1);
            }
            stepsAdapter.notifyDataSetChanged();
        });

        readyToAddButton.setOnClickListener(view -> {
            String name = nameText.getText().toString();
            String description = descriptionText.getText().toString();
            Intent intent = new Intent(AddRecipeScreen.this, MainActivity.class);
            startActivity(intent);
        });
    }
}