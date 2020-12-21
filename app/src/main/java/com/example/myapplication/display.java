package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class display extends AppCompatActivity {


    Button btnGraph;


    ImageView iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);


        iv1=findViewById(R.id.iv1);

        btnGraph=findViewById(R.id.btnGraph);

        final String r=getIntent().getStringExtra("name");
        //Toast.makeText(this, r, Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, r, Toast.LENGTH_SHORT).show();
        //iv1.setImageResource(getResources().getIdentifier(r,"drawable",getPackageName()));
        String uri = "@drawable/"+r;
        int id = getResources().getIdentifier(r, "drawable", getPackageName());
        int imageResource = getResources().getIdentifier(uri, null, getPackageName());
        Log.d("value",String.valueOf(imageResource));
        Drawable res = getResources().getDrawable(imageResource);
        iv1.setImageDrawable(res);
        //Toast.makeText(this, String.valueOf(id), Toast.LENGTH_SHORT).show();
        //iv1.setImageResource();


        btnGraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(display.this,GraphActivity.class);
                i.putExtra("name",r);
                startActivity(i);

            }
        });

    }
}
