package com.antu.bazinga.priyomukh;

/**
 * Created by Antu on 12-Nov-18.
 */
public class MotherInformation {
    private String heading;
    private String data;


    public MotherInformation() {
    }

    public MotherInformation(String heading, String data, String photoUrl) {
        this.heading = heading;
        this.data = data;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return this.heading+" "+this.data;
    }
}
