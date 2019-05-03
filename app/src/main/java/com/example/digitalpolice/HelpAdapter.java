package com.example.digitalpolice;

import android.content.Intent;
import android.drm.DrmStore;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class HelpAdapter extends RecyclerView.Adapter<HelpAdapter.Holder> {


    List<GetHelpDataposo> data;


ViewHelp viewHelp;


    public HelpAdapter(ViewHelp viewHelp, List<GetHelpDataposo> data) {


        this.data=data;
        this.viewHelp=viewHelp;

    }

    @NonNull
    @Override
    public HelpAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rowhelp,viewGroup,false);

        Holder holder=new Holder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final HelpAdapter.Holder viewHolder, final int i) {



        viewHolder.adhaar.setText("Adhaar:"+data.get(i).getAdhaar());
        viewHolder.message.setText(" Message:"+data.get(i).getMessage());
        viewHolder.location.setText(data.get(i).getLocation());

        viewHelp.dialog.dismiss();

viewHolder.locationbutton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse(data.get(i).getLocation()));
        viewHelp.startActivity(intent);


    }
});


viewHolder.location.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {


        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse(data.get(i).getLocation()));
        viewHelp.startActivity(intent);





    }
});






    }



    @Override
    public int getItemCount() {
        return data.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        TextView location,message,adhaar;

        ImageView locationbutton;
        public Holder(@NonNull View itemView) {
            super(itemView);

            location=itemView.findViewById(R.id.location);
            message=itemView.findViewById(R.id.message);
            adhaar=itemView.findViewById(R.id.adhaar);
        locationbutton=itemView.findViewById(R.id.loctionimage);

        }
    }
}
