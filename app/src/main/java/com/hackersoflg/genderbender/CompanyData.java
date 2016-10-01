package com.hackersoflg.genderbender;

import java.util.HashMap;

/**
 * Created by rowlindsay on 10/1/16.
 */

public class CompanyData {

    public static String[] genders = {"Male","Female"};
    public static String[] companyNames = {"Netflix","Google"};

    public HashMap<String,Company> companies;

    private static CompanyData instance = null;

    protected CompanyData () {
        companies = new HashMap<String,Company>();
        for(String companyName : companyNames) {
            companies.put(companyName,new Company(companyName));
        }
    }

    public static CompanyData getInstance() {
        if(instance == null) {
            instance = new CompanyData();
        }
        return instance;
    }

    public void addEmployee(String company,String gender) {
            companies.get(company).addEmployee(gender);
    }

    public Company getCompany(String companyName) {
        return companies.get(companyName);
    }
}
