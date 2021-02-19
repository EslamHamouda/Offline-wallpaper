package com.example.offlinewallpaper;

import androidx.appcompat.app.AppCompatActivity;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.IOException;

public class DetailActivity extends AppCompatActivity {
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        final ImageView imageView=findViewById(R.id.imageView);
        Bundle bundle=getIntent().getExtras();
        if (bundle!= null){
            imageView.setImageResource(bundle.getInt("Image"));

        }



        button=findViewById(R.id.imageSet);
        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap=((BitmapDrawable)imageView.getDrawable()).getBitmap();
                WallpaperManager wallpaperManager=WallpaperManager.getInstance(getApplicationContext());
                try {
                    wallpaperManager.setBitmap(bitmap);
                    Toast.makeText(getApplicationContext(),"Set as Wallpaper successfully",Toast.LENGTH_LONG).show();
                }catch (IOException e){
                    Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    }
