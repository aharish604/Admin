package com.example.digitalpolice;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ComplaintsView extends AppCompatActivity {


    FirebaseDatabase database;

    DatabaseReference myRef;
    ProgressDialog dialog;

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaints_view);


        recyclerView = findViewById(R.id.rvc);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        database = FirebaseDatabase.getInstance();


        dialog=new ProgressDialog(this);
        dialog.setTitle("Loadng");
        dialog.setMessage("PlaseWaitaWhile....");
        dialog.show();

getdata();
    }

    public void getdata() {

        final List<GetmakeComplaintposo> data = new ArrayList();

        myRef = database.getReference("MakeaComplaint");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                    GetmakeComplaintposo getmakeComplaintposo = dataSnapshot1.getValue(GetmakeComplaintposo.class);

                    data.add(getmakeComplaintposo);


                }


                recyclerView.setAdapter(new ComplaintAdapter(ComplaintsView.this, data));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}


