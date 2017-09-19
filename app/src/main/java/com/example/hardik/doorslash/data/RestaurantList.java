package com.example.hardik.doorslash.data;

import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.example.hardik.doorslash.Business;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RestaurantList implements Parcelable {


    private boolean isFavorited;
    @SerializedName("is_time_surging")
    @Expose
    private Boolean isTimeSurging;
    @SerializedName("max_order_size")
    @Expose
    private Object maxOrderSize;
    @SerializedName("delivery_fee")
    @Expose
    private Integer deliveryFee;
    @SerializedName("max_composite_score")
    @Expose
    private Integer maxCompositeScore;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("merchant_promotions")
    @Expose
    private List<MerchantPromotion> merchantPromotions = null;
    @SerializedName("average_rating")
    @Expose
    private Double averageRating;
    @SerializedName("menus")
    @Expose
    private List<Menu> menus = null;
    @SerializedName("composite_score")
    @Expose
    private Integer compositeScore;
    @SerializedName("status_type")
    @Expose
    private String statusType;
    @SerializedName("is_only_catering")
    @Expose
    private Boolean isOnlyCatering;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("number_of_ratings")
    @Expose
    private Integer numberOfRatings;
    @SerializedName("asap_time")
    @Expose
    private Integer asapTime;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("business")
    @Expose
    private Business business;
    @SerializedName("tags")
    @Expose
    private List<String> tags = null;
    @SerializedName("yelp_review_count")
    @Expose
    private Integer yelpReviewCount;
    @SerializedName("business_id")
    @Expose
    private Integer businessId;
    @SerializedName("extra_sos_delivery_fee")
    @Expose
    private Integer extraSosDeliveryFee;
    @SerializedName("yelp_rating")
    @Expose
    private Double yelpRating;
    @SerializedName("cover_img_url")
    @Expose
    private String coverImgUrl;
    @SerializedName("header_img_url")
    @Expose
    private String headerImgUrl;
    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("price_range")
    @Expose
    private Integer priceRange;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("is_newly_added")
    @Expose
    private Boolean isNewlyAdded;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("service_rate")
    @Expose
    private Double serviceRate;
    @SerializedName("promotion")
    @Expose
    private Object promotion;
    @SerializedName("featured_category_description")
    @Expose
    private Object featuredCategoryDescription;
    public final static Parcelable.Creator<RestaurantList> CREATOR = new Creator<RestaurantList>() {


        @SuppressWarnings({
                "unchecked"
        })
        public RestaurantList createFromParcel(Parcel in) {
            RestaurantList instance = new RestaurantList();
            instance.isTimeSurging = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.maxOrderSize = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.deliveryFee = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.maxCompositeScore = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
            in.readList(instance.merchantPromotions, (java.lang.Object.class.getClassLoader()));
            instance.averageRating = ((Double) in.readValue((Double.class.getClassLoader())));
            in.readList(instance.menus, (com.example.hardik.doorslash.data.Menu.class.getClassLoader()));
            instance.compositeScore = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.statusType = ((String) in.readValue((String.class.getClassLoader())));
            instance.isOnlyCatering = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.status = ((String) in.readValue((String.class.getClassLoader())));
            instance.numberOfRatings = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.asapTime = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.description = ((String) in.readValue((String.class.getClassLoader())));
            instance.business = ((Business) in.readValue((Business.class.getClassLoader())));
            in.readList(instance.tags, (java.lang.String.class.getClassLoader()));
            instance.yelpReviewCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.businessId = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.extraSosDeliveryFee = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.yelpRating = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.coverImgUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.headerImgUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.address = ((Address) in.readValue((Address.class.getClassLoader())));
            instance.priceRange = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.slug = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.isNewlyAdded = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.url = ((String) in.readValue((String.class.getClassLoader())));
            instance.serviceRate = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.promotion = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.featuredCategoryDescription = ((Object) in.readValue((Object.class.getClassLoader())));
            return instance;
        }

        public RestaurantList[] newArray(int size) {
            return (new RestaurantList[size]);
        }

    };

    public boolean isFavorited() {
        return isFavorited;
    }

    public void setFavorited(boolean favorited) {
        isFavorited = favorited;
    }

    public Boolean getIsTimeSurging() {
        return isTimeSurging;
    }

    public void setIsTimeSurging(Boolean isTimeSurging) {
        this.isTimeSurging = isTimeSurging;
    }

    public Object getMaxOrderSize() {
        return maxOrderSize;
    }

    public void setMaxOrderSize(Object maxOrderSize) {
        this.maxOrderSize = maxOrderSize;
    }

    public Integer getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(Integer deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public Integer getMaxCompositeScore() {
        return maxCompositeScore;
    }

    public void setMaxCompositeScore(Integer maxCompositeScore) {
        this.maxCompositeScore = maxCompositeScore;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<MerchantPromotion> getMerchantPromotions() {
        return merchantPromotions;
    }

    public void setMerchantPromotions(List<MerchantPromotion> merchantPromotions) {
        this.merchantPromotions = merchantPromotions;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public Integer getCompositeScore() {
        return compositeScore;
    }

    public void setCompositeScore(Integer compositeScore) {
        this.compositeScore = compositeScore;
    }

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    public Boolean getIsOnlyCatering() {
        return isOnlyCatering;
    }

    public void setIsOnlyCatering(Boolean isOnlyCatering) {
        this.isOnlyCatering = isOnlyCatering;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getNumberOfRatings() {
        return numberOfRatings;
    }

    public void setNumberOfRatings(Integer numberOfRatings) {
        this.numberOfRatings = numberOfRatings;
    }

    public Integer getAsapTime() {
        return asapTime;
    }

    public void setAsapTime(Integer asapTime) {
        this.asapTime = asapTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Integer getYelpReviewCount() {
        return yelpReviewCount;
    }

    public void setYelpReviewCount(Integer yelpReviewCount) {
        this.yelpReviewCount = yelpReviewCount;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public Integer getExtraSosDeliveryFee() {
        return extraSosDeliveryFee;
    }

    public void setExtraSosDeliveryFee(Integer extraSosDeliveryFee) {
        this.extraSosDeliveryFee = extraSosDeliveryFee;
    }

    public Double getYelpRating() {
        return yelpRating;
    }

    public void setYelpRating(Double yelpRating) {
        this.yelpRating = yelpRating;
    }

    public String getCoverImgUrl() {
        return coverImgUrl;
    }

    public void setCoverImgUrl(String coverImgUrl) {
        this.coverImgUrl = coverImgUrl;
    }

    public String getHeaderImgUrl() {
        return headerImgUrl;
    }

    public void setHeaderImgUrl(String headerImgUrl) {
        this.headerImgUrl = headerImgUrl;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(Integer priceRange) {
        this.priceRange = priceRange;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsNewlyAdded() {
        return isNewlyAdded;
    }

    public void setIsNewlyAdded(Boolean isNewlyAdded) {
        this.isNewlyAdded = isNewlyAdded;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getServiceRate() {
        return serviceRate;
    }

    public void setServiceRate(Double serviceRate) {
        this.serviceRate = serviceRate;
    }

    public Object getPromotion() {
        return promotion;
    }

    public void setPromotion(Object promotion) {
        this.promotion = promotion;
    }

    public Object getFeaturedCategoryDescription() {
        return featuredCategoryDescription;
    }

    public void setFeaturedCategoryDescription(Object featuredCategoryDescription) {
        this.featuredCategoryDescription = featuredCategoryDescription;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(isTimeSurging);
        dest.writeValue(maxOrderSize);
        dest.writeValue(deliveryFee);
        dest.writeValue(maxCompositeScore);
        dest.writeValue(id);
        dest.writeList(merchantPromotions);
        dest.writeValue(averageRating);
        dest.writeList(menus);
        dest.writeValue(compositeScore);
        dest.writeValue(statusType);
        dest.writeValue(isOnlyCatering);
        dest.writeValue(status);
        dest.writeValue(numberOfRatings);
        dest.writeValue(asapTime);
        dest.writeValue(description);
        dest.writeValue(business);
        dest.writeList(tags);
        dest.writeValue(yelpReviewCount);
        dest.writeValue(businessId);
        dest.writeValue(extraSosDeliveryFee);
        dest.writeValue(yelpRating);
        dest.writeValue(coverImgUrl);
        dest.writeValue(headerImgUrl);
        dest.writeValue(address);
        dest.writeValue(priceRange);
        dest.writeValue(slug);
        dest.writeValue(name);
        dest.writeValue(isNewlyAdded);
        dest.writeValue(url);
        dest.writeValue(serviceRate);
        dest.writeValue(promotion);
        dest.writeValue(featuredCategoryDescription);
    }

    public int describeContents() {
        return 0;
    }

}