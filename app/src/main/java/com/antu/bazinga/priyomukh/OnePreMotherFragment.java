package com.antu.bazinga.priyomukh;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class OnePreMotherFragment extends Fragment {

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mMotherInfoDatabaseReference;
    private DatabaseReference mDatabaseReference;
    private ChildEventListener mChildEventListener;

    private ProgressBar mProgressBar;
    private ListView mInfoListView;

    private MotherInfromationAdapter mMotherInfromationAdapter;

    public OnePreMotherFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mMotherInfoDatabaseReference = mFirebaseDatabase.getReference().child("mother");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one_pre_mother, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mProgressBar = (ProgressBar) getView().findViewById(R.id.progressBar);
        mInfoListView = (ListView) getView().findViewById(R.id.infoListView);

        // Initialize message ListView and its adapter
        List<MotherInformation> informationList = new ArrayList<>();
        mMotherInfromationAdapter = new MotherInfromationAdapter(getContext(), R.layout.item_information, informationList);
        mInfoListView.setAdapter(mMotherInfromationAdapter);

        // Initialize progress bar
        mProgressBar.setVisibility(ProgressBar.INVISIBLE);

        onSignInInitialize();

    }

    private void onSignOutCleanUp() {
        detachDatabaseListener();
        mMotherInfromationAdapter.clear();
    }

    private void detachDatabaseListener() {
        if(mChildEventListener != null){
            mMotherInfoDatabaseReference.removeEventListener(mChildEventListener);
            mChildEventListener = null;
        }
    }

    private void onSignInInitialize() {
        attachDatabaseReadListener();
    }

    private void attachDatabaseReadListener() {
        if(mChildEventListener == null) {
            mChildEventListener = new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@"+dataSnapshot.getValue());
                    MotherInformation motherInformation = dataSnapshot.getValue(MotherInformation.class);
                    mMotherInfromationAdapter.add(motherInformation);
                }
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {}
                public void onChildRemoved(DataSnapshot dataSnapshot) {}
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {}
                public void onCancelled(DatabaseError databaseError) {}
            };
            mMotherInfoDatabaseReference.addChildEventListener(mChildEventListener);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        onSignOutCleanUp();
    }

    @Override
    public void onResume() {
        super.onResume();
        onSignInInitialize();
    }
}
