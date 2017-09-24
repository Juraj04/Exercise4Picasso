package com.example.janik.exercise4picasso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Image> images = new ArrayList<>();
    private ImageView imageView;
    private TextView textView;
    private float x1, x2;
    private int imageIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        someImages();
        imageView = (ImageView) findViewById(R.id.imageView);
        textView = (TextView) findViewById(R.id.textView);
        imageIndex = 0;

        loader(images.get(imageIndex), textView, imageView);
    }

    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                if (x1 < x2) { // left to right -> previous
                    imageIndex--;
                    if (imageIndex < 0) imageIndex = images.size() - 1;
                } else { // right to left -> next
                    imageIndex++;
                    if (imageIndex > (images.size() - 1)) imageIndex = 0;
                }
                loader(images.get(imageIndex), textView, imageView);
                break;
        }
        return false;
    }


    public void someImages() {
        Image i1 = new Image("Bratislava", "https://welcome.aiesec.sk/wp-content/uploads/2016/02/welcome_slider02.jpg");
        images.add(i1);
        Image i2 = new Image("Slovakia", "http://flagpedia.net/data/flags/ultra/sk.png");
        images.add(i2);
        Image i3 = new Image("High Tatras", "https://hiking.sk/pictures/photos/a0b98ef0f57ffe1629501e253562d1b9.jpg");
        images.add(i3);
        Image i4 = new Image("Zilina", "http://www.tikzilina.eu/images/023.jpg");
        images.add(i4);
    }

    public void loader(Image image, TextView tv, ImageView iv) {
        Picasso.with(this)
                .load(image.getUrl())
                .into(iv);

        tv.setText(image.getName());
    }

    public void rotate(int x, Image image, TextView tv, ImageView iv) {
        Picasso.with(this)
                .load(image.getUrl())
                .rotate(x)
                .into(iv);
    }


    public void resizeOnClick(View view) {
        EditText x = (EditText)findViewById(R.id.editText);
        rotate(Integer.parseInt(x.getText().toString()),images.get(imageIndex),textView,imageView);
    }
}


