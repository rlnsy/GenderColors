package com.hackersoflg.genderbender;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class employee_add extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String companyChoice;
    private String genderChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_add);

        Spinner companyPicker = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.company_choices, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        companyPicker.setAdapter(adapter1);
        companyPicker.setOnItemSelectedListener(this);

        final Spinner genderPicker = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.gender_choices, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderPicker.setAdapter(adapter2);
        genderPicker.setOnItemSelectedListener(this);

        Button finishButton = (Button) findViewById(R.id.employee_done);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitEmployee(companyChoice,genderChoice);
            }
        });

        companyChoice = "default";
        genderChoice = "default";
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {

        Log.d("SPINNER","Item selected");
        String choice = (String) parent.getItemAtPosition(pos);
        Log.d("SPINNER",choice);

        switch(parent.getId()) {
            case R.id.spinner:
                companyChoice = choice;
                break;
            case R.id.spinner2:
                genderChoice = choice;
                break;
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    public void submitEmployee(String companyChoice, String genderChoice) {
        Log.d("COMPANY",companyChoice);
        Log.d("GENDER",genderChoice);
    }
}
