package com.example.notesapptutorial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.example.notesapptutorial.databinding.ActivityNotedetailsBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Random;

public class notedetails extends AppCompatActivity {

    private ActivityNotedetailsBinding binding;


    private TextView mtitleofnotedetail, mcontentofnotedetail;
    FloatingActionButton mgotoeditnote;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNotedetailsBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbarofnotedetail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.backGround.setImageResource(getRandomImageBackground());
        Intent data = getIntent();

        binding.gotoeditnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), editnoteactivity.class);
                intent.putExtra("title", data.getStringExtra("title"));
                intent.putExtra("content", data.getStringExtra("content"));
                intent.putExtra("noteId", data.getStringExtra("noteId"));
                v.getContext().startActivity(intent);
            }
        });

        binding.contentofnotedetail.setText(data.getStringExtra("content"));
        binding.titleofnotedetail.setText(data.getStringExtra("title"));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    private int getRandomImageBackground() {
        int[] imageViews = {R.drawable.img1, R.drawable.img2, R.drawable.img4, R.drawable.img5};

        Random random = new Random();
        int number = random.nextInt(imageViews.length);
        return imageViews[number];
    }
}