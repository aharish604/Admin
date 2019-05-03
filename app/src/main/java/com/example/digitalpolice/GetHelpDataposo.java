package com.example.digitalpolice;

public class GetHelpDataposo {

    private String Adhaar;
        private String Location;
        private String Message;

        public GetHelpDataposo(){}


    public GetHelpDataposo(String adhaar, String location, String message) {
        Adhaar = adhaar;
        Location = location;
        Message = message;
    }

    public String getAdhaar() {
        return Adhaar;
    }

    public void setAdhaar(String adhaar) {
        Adhaar = adhaar;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
