package com.example.digitalpolice;

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

public class ComplaintAdapter extends RecyclerView.Adapter<ComplaintAdapter.Hold> {

    List<GetmakeComplaintposo> data;
    ComplaintsView complaintsView;

    public ComplaintAdapter(ComplaintsView complaintsView, List<GetmakeComplaintposo> data) {
        this.data=data;

        this.complaintsView=complaintsView;
    }

    @NonNull
    @Override



    public Hold onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.complaintrow,viewGroup,false);

        ComplaintAdapter.Hold holder=new ComplaintAdapter.Hold(view);

        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull final Hold hold, int i) {






        hold.name.setText(" Name:"+data.get(i).getComplaintaintsName());
        hold.placeofoc.setText(" Place of Occur:\n"+data.get(i).getPlaceOFOccurence());
        hold.dateofoc.setText(" Date of Occur:"+data.get(i).getDateOfOccurence());
        hold.adress.setText(" Adress:\n"+data.get(i).getAdress());
        hold.desription.setText("About Complaint: \n"+(data.get(i).getDescription()));
        hold.mobileno.setText("MobileNo: \n"+data.get(i).getMobileNo());


hold.adhaar_no.setText("AdhaarNo:"+data.get(i).getAdhaar());


complaintsView.dialog.dismiss();


        Picasso.with(complaintsView)
                .load(data.get(i).getImage_url())

                .into(hold.imageproof, new Callback() {
                    @Override
                    public void onSuccess() {
                       hold.progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });

       // Glide.with(complaintsView).load(data.get(i).getImage_url()).into(hold.imageproof);





    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class Hold extends RecyclerView.ViewHolder {

        TextView name,adress,placeofoc,dateofoc,mobileno,desription,adhaar_no;
        ImageView imageproof;

        ProgressBar progressBar;

        public Hold(@NonNull View itemView) {

            super(itemView);

           name=itemView.findViewById(R.id.name);
            adress=itemView.findViewById(R.id.adress);
            adhaar_no=itemView.findViewById(R.id.adhaar_no);
            placeofoc=itemView.findViewById(R.id.placeofoc);
            dateofoc=itemView.findViewById(R.id.dateofoc);
            mobileno=itemView.findViewById(R.id.mobileno);
            desription=itemView.findViewById(R.id.description);
            imageproof=itemView.findViewById(R.id.proofimg);
            progressBar=itemView.findViewById(R.id.progressBar);





        }
    }
}
