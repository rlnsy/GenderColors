package com.hackersoflg.genderbender;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by rowlindsay on 10/1/16.
 */
public class Company {

    public HashMap<String,GenderGroup> genderFrequencyGroups;
    public String name;

    public class GenderGroup {
        public String genderTag;
        public int frequency;

        public GenderGroup(String genderTag,int frequency) {
            this.genderTag = genderTag;
            this.frequency = frequency;
        }

        public void addEmployee() {
            frequency++;
        }

        public int getFrequency() {
            return frequency;
        }
    }

    public Company (String name) {
        genderFrequencyGroups = new HashMap<String,GenderGroup> ();
        for(String gender : CompanyData.genders) {
            genderFrequencyGroups.put(gender,new GenderGroup(gender,0));
        }
        this.name = name;
    }

    public void addEmployee(String gender) {
        genderFrequencyGroups.get(gender).addEmployee();
    }

    public int getGenderFrequency(String genderTag) {
        return genderFrequencyGroups.get(genderTag).getFrequency();
    }
}
