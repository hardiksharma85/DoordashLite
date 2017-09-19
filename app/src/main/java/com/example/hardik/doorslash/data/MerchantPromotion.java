package com.example.hardik.doorslash.data;

/**
 * Created by Hardik on 9/17/2017.
 */

import android.os.Parcelable;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MerchantPromotion implements Parcelable
{

    @SerializedName("new_store_customers_only")
    @Expose
    private Boolean newStoreCustomersOnly;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("delivery_fee")
    @Expose
    private Object deliveryFee;
    public final static Parcelable.Creator<MerchantPromotion> CREATOR = new Creator<MerchantPromotion>() {


        @SuppressWarnings({
                "unchecked"
        })
        public MerchantPromotion createFromParcel(Parcel in) {
            MerchantPromotion instance = new MerchantPromotion();
            instance.newStoreCustomersOnly = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.deliveryFee = ((Object) in.readValue((Object.class.getClassLoader())));
            return instance;
        }

        public MerchantPromotion[] newArray(int size) {
            return (new MerchantPromotion[size]);
        }

    }
            ;

    public Boolean getNewStoreCustomersOnly() {
        return newStoreCustomersOnly;
    }

    public void setNewStoreCustomersOnly(Boolean newStoreCustomersOnly) {
        this.newStoreCustomersOnly = newStoreCustomersOnly;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(Object deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(newStoreCustomersOnly);
        dest.writeValue(id);
        dest.writeValue(deliveryFee);
    }

    public int describeContents() {
        return 0;
    }

}
