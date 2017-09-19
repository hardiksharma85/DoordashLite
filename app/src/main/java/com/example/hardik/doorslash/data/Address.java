package com.example.hardik.doorslash.data;

/**
 * Created by Hardik on 9/16/2017.
 */

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Address implements Parcelable
{

    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("street")
    @Expose
    private String street;
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("lng")
    @Expose
    private Double lng;
    @SerializedName("printable_address")
    @Expose
    private String printableAddress;
    public final static Parcelable.Creator<Address> CREATOR = new Creator<Address>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Address createFromParcel(Parcel in) {
            Address instance = new Address();
            instance.city = ((String) in.readValue((String.class.getClassLoader())));
            instance.state = ((String) in.readValue((String.class.getClassLoader())));
            instance.street = ((String) in.readValue((String.class.getClassLoader())));
            instance.lat = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.lng = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.printableAddress = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Address[] newArray(int size) {
            return (new Address[size]);
        }

    }
            ;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getPrintableAddress() {
        return printableAddress;
    }

    public void setPrintableAddress(String printableAddress) {
        this.printableAddress = printableAddress;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(city);
        dest.writeValue(state);
        dest.writeValue(street);
        dest.writeValue(lat);
        dest.writeValue(lng);
        dest.writeValue(printableAddress);
    }

    public int describeContents() {
        return 0;
    }

}
