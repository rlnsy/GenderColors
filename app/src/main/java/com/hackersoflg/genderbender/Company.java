package com.hackersoflg.genderbender;

import java.util.HashMap;

/**
 * Created by rowlindsay on 10/1/16.
 */
public class Company {

    public HashMap<String,Integer> genderFrequencies;

    public Company () {
        genderFrequencies = new HashMap<String,Integer> ();
        for(String gender : CompanyData.genders) {
            genderFrequencies.put(gender,0);
        }
    }

    public void addEmployee(String gender) {
        Integer frequency = genderFrequencies.get(gender);
        frequency = frequency.intValue() + 1;
    }
}
