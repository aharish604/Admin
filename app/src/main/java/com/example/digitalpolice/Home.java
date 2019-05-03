package com.example.digitalpolice;

import android.content.Intent;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Home extends AppCompatActivity {

    SliderLayout mDemoSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        mDemoSlider =findViewById(R.id.slider);

        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Helmate Aware Ness Camp", R.drawable.helmateadd);
        file_maps.put("Award Reciving Ceremony", R.drawable.award);
        file_maps.put("Safety First Speed Next", R.drawable.helmateaware);
        //file_maps.put("Game of Thrones", R.drawable.site);
        file_maps.put("Don't Break The Trafic Rules", R.drawable.sevelince);
        file_maps.put("Please Avoid Thriple Riding", R.drawable.helmate);

        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(this);
// initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);

//add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(2500);
        // mDemoSlider.addOnPageChangeListener();







    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:


                Intent intent=new Intent(this,LoginActivity.class);


                startActivity(intent);


                //https://drive.google.com/file/d/1TctekQrSzaFeFLekZ_vttg0FkxZOlRym/view?usp=sharing
                // Toast.makeText(this, "Share APP", Toast.LENGTH_SHORT).show();


                break;
        }

        return super.onOptionsItemSelected(item);

    }




            public void viewMakeComplaint(View view) {

        Intent intent=new Intent(this,ComplaintsView.class);
        startActivity(intent);
    }

    public void viewAnonimusComplaint(View view) {

        Intent intent=new Intent(this,AnonymusReportView.class);
        startActivity(intent);
    }

    public void viewHelipComplaint(View view) {



        Intent intent=new Intent(this,ViewHelp.class);
        startActivity(intent);

    }
}
