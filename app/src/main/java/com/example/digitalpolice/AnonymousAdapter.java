package com.example.digitalpolice;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AnonymousAdapter extends RecyclerView.Adapter<AnonymousAdapter.Hold> {


     AnonymusReportView anonymusReportView;

    List<AnonymousGetData> data;


    public AnonymousAdapter(AnonymusReportView anonymusReportView, List<AnonymousGetData> data) {

        this.anonymusReportView=anonymusReportView;

        this.data=data;

    }

    @NonNull
    @Override
    public Hold onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.anonymousrow,viewGroup,false);

        Hold hold=new Hold(view);


        return hold;
    }

    @Override
    public void onBindViewHolder(@NonNull final Hold hold, final  int i) {




        hold.locationdata.setText(data.get(i).getLocation());
        hold.complaint.setText(" Complaint: \n"+data.get(i).getAboutComplaint());
        //hold.complaint.setText(data.get(i).getLocation());

        anonymusReportView.dialog.dismiss();

        Picasso.with(anonymusReportView)
                .load(data.get(i).getImage_url())

                .into(hold.proofimage, new Callback() {
                    @Override
                    public void onSuccess() {
                        hold.progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });





       // Picasso.with(anonymusReportView).load(data.get(i).getImage_url()).into(hold.proofimage);


      /*  Toast.makeText(anonymusReportView, ""+data.get(i).getImage_url(), Toast.LENGTH_SHORT).show();
        Toast.makeText(anonymusReportView, ""+data.get(i).getAboutComplaint(), Toast.LENGTH_SHORT).show();
        Toast.makeText(anonymusReportView, ""+data.get(i).getImage_url(), Toast.LENGTH_SHORT).show();*/

        hold.locationimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse(data.get(i).getLocation()));
                anonymusReportView.startActivity(intent);




            }
        });

        hold.locationdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse(data.get(i).getLocation()));
                anonymusReportView.startActivity(intent);


            }
        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class Hold extends RecyclerView.ViewHolder {

        ImageView locationimage,proofimage;
        TextView complaint,locationdata;
        ProgressBar progressBar;

        public Hold(@NonNull View itemView) {
            super(itemView);


            proofimage=itemView.findViewById(R.id.proofimageview);
            locationimage=itemView.findViewById(R.id.loctionimage);
            complaint=itemView.findViewById(R.id.aboutcomplaint);
            locationdata=itemView.findViewById(R.id.location);

            progressBar=itemView.findViewById(R.id.progressBar);

        }
    }
}
