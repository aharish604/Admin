package com.example.digitalpolice;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewHelp extends AppCompatActivity {

    FirebaseDatabase database;

    DatabaseReference myRef;

    RecyclerView recyclerView;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_help);


        recyclerView = findViewById(R.id.rv);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        database = FirebaseDatabase.getInstance();

        dialog=new ProgressDialog(this);

        dialog.setTitle("Loadng");
        dialog.setMessage("PlaseWaitaWhile....");
        dialog.show();


        getdata();


    }

    public void getdata() {

        final List<GetHelpDataposo> data = new ArrayList();

        myRef = database.getReference("Help/Help");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                    GetHelpDataposo getHelpDataposo = dataSnapshot1.getValue(GetHelpDataposo.class);

                    data.add(getHelpDataposo);

                    Toast.makeText(ViewHelp.this, ""+getHelpDataposo.getMessage(), Toast.LENGTH_SHORT).show();


                }


                recyclerView.setAdapter(new HelpAdapter(ViewHelp.this, data));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}