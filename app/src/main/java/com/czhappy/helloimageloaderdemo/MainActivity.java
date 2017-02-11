package com.czhappy.helloimageloaderdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.czhappy.helloimageloader.ImageLoader;

public class MainActivity extends AppCompatActivity {

    private ImageView my_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        my_image = (ImageView) findViewById(R.id.my_image);
    }

    public void beginLoad(View view){
        String url = "http://img06.tooopen.com/images/20161112/tooopen_sy_185726882764.jpg";
        ImageLoader.getInstance().loadImageView(my_image, url);
    }
}
