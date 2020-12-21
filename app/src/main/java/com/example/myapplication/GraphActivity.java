package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class GraphActivity extends AppCompatActivity {



    ImageView iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);


        iv1=findViewById(R.id.iv1);

        final String r=getIntent().getStringExtra("name");
        //Toast.makeText(this, r, Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, r, Toast.LENGTH_SHORT).show();
        //iv1.setImageResource(getResources().getIdentifier(r,"drawable",getPackageName()));
        String uri = "@drawable/g_"+r;
        int id = getResources().getIdentifier(r, "drawable", getPackageName());
        int imageResource = getResources().getIdentifier(uri, null, getPackageName());
        Log.d("value",String.valueOf(imageResource));
        Drawable res = getResources().getDrawable(imageResource);
        iv1.setImageDrawable(res);
        //Toast.makeText(this, String.valueOf(id), Toast.LENGTH_SHORT).show();
        //iv1.setImageResource();


    }
}
