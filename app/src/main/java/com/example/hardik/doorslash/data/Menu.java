package com.example.hardik.doorslash.data;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Menu implements Parcelable
{

    @SerializedName("popular_items")
    @Expose
    private List<PopularItem> popularItems = null;
    @SerializedName("is_catering")
    @Expose
    private Boolean isCatering;
    @SerializedName("subtitle")
    @Expose
    private String subtitle;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    public final static Parcelable.Creator<Menu> CREATOR = new Creator<Menu>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Menu createFromParcel(Parcel in) {
            Menu instance = new Menu();
            in.readList(instance.popularItems, (com.example.hardik.doorslash.data.PopularItem.class.getClassLoader()));
            instance.isCatering = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.subtitle = ((String) in.readValue((String.class.getClassLoader())));
            instance.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Menu[] newArray(int size) {
            return (new Menu[size]);
        }

    }
            ;

    public List<PopularItem> getPopularItems() {
        return popularItems;
    }

    public void setPopularItems(List<PopularItem> popularItems) {
        this.popularItems = popularItems;
    }

    public Boolean getIsCatering() {
        return isCatering;
    }

    public void setIsCatering(Boolean isCatering) {
        this.isCatering = isCatering;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(popularItems);
        dest.writeValue(isCatering);
        dest.writeValue(subtitle);
        dest.writeValue(id);
        dest.writeValue(name);
    }

    public int describeContents() {
        return 0;
    }

}