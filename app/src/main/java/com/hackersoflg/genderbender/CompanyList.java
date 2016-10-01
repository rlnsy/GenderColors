package com.hackersoflg.genderbender;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CompanyList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,CompanyData.getInstance().companyNames);

        ListView companyList = (ListView) findViewById(R.id.company_list);
        companyList.setAdapter(adapter);

        AdapterView.OnItemClickListener mMessageClickedHandler = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                String companyValue = (String) parent.getItemAtPosition(position);
                openCompanyPage(companyValue);
            }
        };

        companyList.setOnItemClickListener(mMessageClickedHandler);
    }

    public void openCompanyPage(String companyName) {
        Intent intent = new Intent(this,CompanyDisplay.class);
        intent.putExtra("LAUNCH_COMPANY", companyName);
        startActivity(intent);
    }
}
