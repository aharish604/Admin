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

public class AnonymusReportView extends AppCompatActivity {

    FirebaseDatabase database;

    DatabaseReference myRef;

    RecyclerView recyclerView;

    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anonymus_report_view);

        database=FirebaseDatabase.getInstance();

dialog=new ProgressDialog(this);
        recyclerView = findViewById(R.id.rva);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));




dialog.setTitle("Loadng");
dialog.setMessage("PlaseWaitaWhile....");
dialog.show();

        getdata();
}

    public void getdata() {

        final List<AnonymousGetData> data = new ArrayList();

        myRef = database.getReference("AnonymousReport");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                    AnonymousGetData anonymousGetData = dataSnapshot1.getValue(AnonymousGetData.class);

                    data.add(anonymousGetData);
}
                Toast.makeText(AnonymusReportView.this, ""+data.size(), Toast.LENGTH_SHORT).show();

                recyclerView.setAdapter(new AnonymousAdapter(AnonymusReportView.this, data));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}


