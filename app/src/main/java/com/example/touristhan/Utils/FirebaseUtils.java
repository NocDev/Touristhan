package com.example.touristhan.Utils;

import android.util.Log;

import com.example.touristhan.Data.Data;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by aadi on 27/9/17.
 */

public class FirebaseUtils {

    public static final String TAG = FirebaseUtils.class.getSimpleName();

    FirebaseDatabase mFirebaseDatabase = FirebaseDatabase.getInstance();
    private ArrayList<Data> dataList;
    DatabaseReference mDatabaseReference = mFirebaseDatabase.getReference("city");
    //private ChildEventListener mChildEventListener;

    public FirebaseUtils(ArrayList<Data> dataList){
        this.dataList = dataList;
    }

    public ArrayList<Data> readFromDatabase(){
        mDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever dataList at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                dataList.add(new Data(value, null));

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Failed to read value
                Log.e(TAG, "Failed to read value.", databaseError.toException());
            }
        });
        return dataList;
    }
}

