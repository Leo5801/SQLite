package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlite.entitys.Populations;

public class InsertActivity extends AppCompatActivity {

    private EditText counrtyName, countryPopulation, countryRank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        counrtyName = findViewById(R.id.country_name_edit_text);
        countryPopulation = findViewById(R.id.country_population_edit_text);
        countryRank = findViewById(R.id.country_rank_edit_text);

    }

    private void insertRecords () {

        Populations populations = new Populations();

        String name = counrtyName.getText().toString();
        String cPopulation = countryPopulation.getText().toString();
        String cRank = countryRank.getText().toString();

        populations.setCountryName(name);
        populations.setCountryPopulation(Double.parseDouble(cPopulation));
        populations.setCountryRanking(Integer.parseInt(cRank));

        populations.save();

        setResult(RESULT_OK);

        Toast.makeText(InsertActivity.this, "Record Insert Success", Toast.LENGTH_LONG).show();

        counrtyName.setText("");
        countryPopulation.setText("");
        countryRank.setText("");


    }

    public void addRecords(View view) {
        insertRecords();


    }
}