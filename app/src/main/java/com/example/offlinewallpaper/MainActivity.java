package com.example.offlinewallpaper;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.postsRecyclerView);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        );
        int[] placeList=new int[]{
                R.drawable.image1,
                R.drawable.image00,
                R.drawable.image2,
                R.drawable.image3,
                R.drawable.image4,
                R.drawable.image5,
                R.drawable.image6,
                R.drawable.image7,
                R.drawable.image8,
                R.drawable.image9,
                R.drawable.image10,
                R.drawable.image11,
                R.drawable.image12,
                R.drawable.image13,
                R.drawable.image14,
                R.drawable.image15,
                R.drawable.image16,
                R.drawable.image17,
                R.drawable.image18,
                R.drawable.image19,
                R.drawable.image20,
                R.drawable.image21,
                R.drawable.image22,
                R.drawable.image23,
                R.drawable.image24,
                R.drawable.image25,
                R.drawable.image26,
                R.drawable.image27,
                R.drawable.image28,
                R.drawable.image30,
                R.drawable.image31,
                R.drawable.image32,
                R.drawable.image33,
                R.drawable.image34,
                R.drawable.image35,
                R.drawable.image36,
                R.drawable.image37,
                R.drawable.image38,
                R.drawable.image39,
                R.drawable.image40,
                R.drawable.image41,
                R.drawable.image42,
                R.drawable.image43,
                R.drawable.image44,
                R.drawable.image45,
                R.drawable.image46,
                R.drawable.image47,
                R.drawable.image48,
                R.drawable.image49,
                R.drawable.image50,
                R.drawable.image51,
                R.drawable.image52,
                R.drawable.image53,

                R.drawable.image147,
                R.drawable.image148,
                R.drawable.image149,
                R.drawable.image150,
                R.drawable.image151,
                R.drawable.image152,
                R.drawable.image153,
                R.drawable.image154,
                R.drawable.image155

        };
PostsAdapter postsAdapter=new PostsAdapter(placeList, MainActivity.this);
recyclerView.setAdapter(postsAdapter);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("IntentReset")
            @Override
            public void onClick(View view) {
                Log.i("Send email", "");

                String[] TO = {"eslam.ee600@gmail.com"};
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Offline Wallpaper");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Type the message you would like to send to the devs");
                try {
                    startActivity(Intent.createChooser(emailIntent, "Sending email to..."));
                    //finish();
                    //Log.i("Finished sending email", "");
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(MainActivity.this,
                            "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;}
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            Intent in = new Intent(this, Setting.class);
            startActivity(in);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    }
