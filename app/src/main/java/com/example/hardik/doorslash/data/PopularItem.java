package com.example.hardik.doorslash.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PopularItem implements Parcelable
{

    @SerializedName("img_url")
    @Expose
    private String imgUrl;
    @SerializedName("id")
    @Expose
    private Integer id;
    public final static Parcelable.Creator<PopularItem> CREATOR = new Creator<PopularItem>() {


        @SuppressWarnings({
                "unchecked"
        })
        public PopularItem createFromParcel(Parcel in) {
            PopularItem instance = new PopularItem();
            instance.imgUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
            return instance;
        }

        public PopularItem[] newArray(int size) {
            return (new PopularItem[size]);
        }

    }
            ;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(imgUrl);
        dest.writeValue(id);
    }

    public int describeContents() {
        return 0;
    }

}