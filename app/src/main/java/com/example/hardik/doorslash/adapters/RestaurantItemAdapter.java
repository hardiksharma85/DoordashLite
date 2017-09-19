package com.example.hardik.doorslash.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.hardik.doorslash.R;
import com.example.hardik.doorslash.data.RestaurantList;
import com.example.hardik.doorslash.utils.ClickListener;
import com.example.hardik.doorslash.utils.Commons;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Hardik on 9/16/2017.
 */
public class RestaurantItemAdapter extends RecyclerView.Adapter<RestaurantItemAdapter.RestaurantItemHolder> {

    private final Context mContext;
    private final ArrayList<RestaurantList> mData;
    private View view;
    private ClickListener mListener;

    public RestaurantItemAdapter(Context context, ArrayList<RestaurantList> mDataSet) {
        mContext = context;
        mData = mDataSet;
    }

    public class RestaurantItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView restName;
        private ImageView restImage;
        private TextView type;
        private TextView rating;
        private ToggleButton fav;

        public RestaurantItemHolder(View itemView) {
            super(itemView);
            view = itemView;
            restName = (TextView) itemView.findViewById(R.id.rest_name);
            restImage = (ImageView) itemView.findViewById(R.id.rest_image);
            type = (TextView) itemView.findViewById(R.id.rest_type);
            rating = (TextView) itemView.findViewById(R.id.distance);
            fav = (ToggleButton) itemView.findViewById(R.id.star);
            fav.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean check) {
                    if (compoundButton.isPressed() && mListener != null)
                        mListener.onItemClick(getAdapterPosition(), fav, mData, Commons.FAVORITE);
                }
            });
        }

        @Override
        public void onClick(View v) {

        }
    }

    @Override
    public RestaurantItemAdapter.RestaurantItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new RestaurantItemHolder(view);
    }

    @Override
    public void onBindViewHolder(RestaurantItemAdapter.RestaurantItemHolder holder, int position) {
        RestaurantList data = mData.get(position);
        holder.restName.setText(data.getName());
        Picasso.with(mContext).load(data.getCoverImgUrl()).error(R.drawable.rest_place_holder).into(holder.restImage);
        holder.type.setText(data.getDescription());
        String rate = Double.toString(data.getAverageRating());
        holder.rating.setText(rate);

        if (data.isFavorited()) {
            holder.fav.setChecked(true);
        } else {
            holder.fav.setChecked(false);
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setOnItemClickListener(ClickListener listener) {
        mListener = listener;
    }
}
