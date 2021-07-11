package com.example.madlab04;

import android.app.WallpaperManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button button;

    int i = 0;

    public void changeWallpaper(View view) {
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(getBaseContext());

        int images[] = new int[]{

                R.drawable.i2,
                R.drawable.i3
        };
        try {
            wallpaperManager.setBitmap(BitmapFactory.decodeResource(getResources(), images[i]));
            i++;
            if (i == 2) {
                i = 0;
            }
            Thread.sleep(30000);
            changeWallpaper(view);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);


    }
}