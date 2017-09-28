package com.example.touristhan.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.touristhan.R;

/**
 * Created by aadi on 28/9/17.
 */
public class Holder extends RecyclerView.ViewHolder {

    private TextView textView;

    public Holder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.card_tv_1);
    }

    public void setName(String name) {
        textView.setText(name);
    }
}
