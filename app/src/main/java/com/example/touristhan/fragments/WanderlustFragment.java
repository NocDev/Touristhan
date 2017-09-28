package com.example.touristhan.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.touristhan.R;
import com.example.touristhan.adapters.Holder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by aadi on 27/9/17.
 */

public class WanderlustFragment extends android.support.v4.app.Fragment {

    public static final String LOG_TAG = WanderlustFragment.class.getSimpleName();

    //Firebase
    private FirebaseDatabase mFirebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mDatabaseReference = mFirebaseDatabase.getReference("City");
    private FirebaseRecyclerAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        RecyclerView rv = (RecyclerView)rootView.findViewById(R.id.recyclerView);
        rv.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        mAdapter = new FirebaseRecyclerAdapter<String, Holder>(
                String.class,
                R.layout.card_item,
                Holder.class,
                mDatabaseReference
        ) {
            @Override
            protected void populateViewHolder(Holder viewHolder, String model, int position) {
                viewHolder.setName(model);
            }

        };


        rv.setHasFixedSize(true);
        rv.setAdapter(mAdapter);
        Log.d(LOG_TAG, "Inside WanderLust Fragment");
        return rootView;

    }
}
