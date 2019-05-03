package com.example.digitalpolice;

public class AnonymousGetData {



    String AboutComplaint;
    String Location;
    String  image_url;

    public AnonymousGetData(String aboutComplaint, String location, String image_url) {
        AboutComplaint = aboutComplaint;
        Location = location;
        this.image_url = image_url;
    }

    public AnonymousGetData(){



    }


    public String getAboutComplaint() {
        return AboutComplaint;
    }

    public void setAboutComplaint(String aboutComplaint) {
        AboutComplaint = aboutComplaint;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
