package ucf.assignments;
/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Anthony Banaag
 */
import javafx.beans.property.SimpleStringProperty;

public class ItemInfo {


    private SimpleStringProperty name, serialnumber,value;



    public ItemInfo(String name, String serialnumber, String value) {
        //input strings and make it simplepropertystring
        this.name = new SimpleStringProperty(name);
        this.serialnumber = new SimpleStringProperty(serialnumber);
        this.value = new SimpleStringProperty(value);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {

        return name;
    }

    public void setName(String name) {

        this.name = new SimpleStringProperty(name);
    }

    public String getSerialnumber() {

        return serialnumber.get();
    }

    public SimpleStringProperty serialnumberProperty() {

        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {

        this.serialnumber = new SimpleStringProperty(serialnumber);
    }

    public String getValue() {

        return value.get();
    }

    public SimpleStringProperty valueProperty() {

        return value;
    }

    public void setValue(String value) {

        this.value = new SimpleStringProperty(value);
    }



}
