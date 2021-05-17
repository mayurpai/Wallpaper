package com.example.wallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Button button;
    Boolean running = false;
    int imageArray [] = new int[] {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.j};
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button =  findViewById(R.id.button);
        button.setOnClickListener(this::onClick);
    }

    public void onClick (View view) {
            if(!running) {
                new Timer().schedule(new MyTimer(),0,1);
                running = true;
        }
    }

     class MyTimer extends TimerTask {
        public void run() {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),imageArray[i]);
            WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
            try {
                wallpaperManager.setBitmap(bitmap);
//                WallpaperManager wallpaperManager = WallpaperManager.getInstance(getBaseContext());
//                wallpaperManager.setBitmap(BitmapFactory.decodeResource(getResources(),imageArray[i]));
                Log.d("Activity","Done!");
                i++;
                if (i==9) {
                    i = 0;
                }
            } catch (IOException e) {
                Log.d("Activity","Error!");
                e.printStackTrace();
            }
        }
    }
}