package edu.iss.nus.medipaldemo.dummy;

/**
 * Created by weihua on 28/2/2017.
 */

import java.util.Date;

/**
 * A dummy item representing a piece of conditonName.
 */
public class DummyHealthBio {
    public  String id;
    public  String description;
    public  Date startDate;
    public  String conditionType;

    public DummyHealthBio()
    {}

    public DummyHealthBio(String id, String description,Date startDate,String conditionType) {
        this.id = id;
        this.description = description;
        this.startDate = startDate;
        this.conditionType = conditionType;
    }

    @Override
    public String toString() {
        return description;
    }
}
