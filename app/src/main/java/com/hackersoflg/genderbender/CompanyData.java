package com.hackersoflg.genderbender;

/**
 * Created by rowlindsay on 10/1/16.
 */
public class CompanyData {

    public static String[] genders = {"Male","Female"};

    public Company netflix,google;

    private static CompanyData instance = null;

    protected CompanyData () {}

    public static CompanyData getInstance() {
        if(instance == null) {
            instance = new CompanyData();
        }
        return instance;
    }
}
