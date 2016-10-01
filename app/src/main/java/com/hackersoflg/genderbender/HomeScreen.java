package com.hackersoflg.genderbender;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */

        Button companyButton = (Button) findViewById(R.id.view_companies_button);
        companyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startCompanyActivity();
            }
        });

        Button addEmployeeButton = (Button) findViewById(R.id.employeebutton);
        addEmployeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startNewEmployeeActivity();
            }
        });

        Button keyButton = (Button) findViewById(R.id.keybutton);
        keyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startKeyActivity();
            }
        });
    }

    public void startCompanyActivity() {
        Intent intent = new Intent(this,CompanyList.class);
        startActivity(intent);
    }

    public void startNewEmployeeActivity() {
        Intent intent = new Intent(this, EmployeeAdd.class);
        startActivity(intent);
    }

    public void startKeyActivity() {
        Intent intent = new Intent(this, Key.class);
        startActivity(intent);
    }
}
