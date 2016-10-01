package com.hackersoflg.genderbender;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CompanyDisplay extends AppCompatActivity {

    private Company company;

    public class GenderInfoItem {
        private String genderTag;
        private Company company;

        public GenderInfoItem(String genderTag,Company company) {
            this.genderTag = genderTag;
            this.company = company;
        }
        public String toString() {
            return genderTag + ":   " + company.getGenderFrequency(genderTag);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_display);

        company = CompanyData.getInstance().getCompany((String)(getIntent().getExtras().get("LAUNCH_COMPANY")));

        TextView companyLabel = (TextView) findViewById(R.id.company_name);
        companyLabel.setText(company.name);

        ListView genderDataList = (ListView) findViewById(R.id.gender_data);

        ArrayList infoItems = new ArrayList();
        for(String genderTag : CompanyData.getInstance().genders) {
            infoItems.add(new GenderInfoItem(genderTag,company));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,infoItems);
        genderDataList.setAdapter(adapter);

        Button refreshButton = (Button) findViewById(R.id.refresh_button);
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refresh();
            }
        });
    }

    public void refresh() {
        Intent intent = new Intent(this,CompanyDisplay.class);
        intent.putExtra("LAUNCH_COMPANY", (String)(getIntent().getExtras().get("LAUNCH_COMPANY")));
        finish();
        startActivity(intent);
    }
}
