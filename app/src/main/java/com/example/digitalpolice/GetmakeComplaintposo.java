package com.example.digitalpolice;

public class GetmakeComplaintposo {

    private String Adress;
    private String ComplaintaintsName;
    private String DateOfOccurence;
    private String Description;
    private String MobileNo;
    private String PlaceOFOccurence;
    private String image_url;
    private String Adhaar;

    public GetmakeComplaintposo()
    {


    }

    public String getAdhaar() {
        return Adhaar;
    }

    public void setAdhaar(String adhaar) {
        Adhaar = adhaar;
    }

    public GetmakeComplaintposo(String adress, String complaintaintsName, String dateOfOccurence,
                                String description, String mobileNo, String placeOFOccurence, String image_url, String Adhaar) {
        Adress = adress;
        ComplaintaintsName = complaintaintsName;
        DateOfOccurence = dateOfOccurence;
        Description = description;
        MobileNo = mobileNo;
        PlaceOFOccurence = placeOFOccurence;
        this.image_url = image_url;
        this.Adhaar=Adhaar;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public String getComplaintaintsName() {
        return ComplaintaintsName;
    }

    public void setComplaintaintsName(String complaintaintsName) {
        ComplaintaintsName = complaintaintsName;
    }

    public String getDateOfOccurence() {
        return DateOfOccurence;
    }

    public void setDateOfOccurence(String dateOfOccurence) {
        DateOfOccurence = dateOfOccurence;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }

    public String getPlaceOFOccurence() {
        return PlaceOFOccurence;
    }

    public void setPlaceOFOccurence(String placeOFOccurence) {
        PlaceOFOccurence = placeOFOccurence;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
