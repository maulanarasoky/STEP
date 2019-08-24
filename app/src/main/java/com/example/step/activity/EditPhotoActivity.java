package com.example.step.activity;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.media.effect.EffectFactory;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.step.R;

import java.io.File;

import ja.burhanrashid52.photoeditor.CustomEffect;
import ja.burhanrashid52.photoeditor.OnPhotoEditorListener;
import ja.burhanrashid52.photoeditor.PhotoEditor;
import ja.burhanrashid52.photoeditor.PhotoEditorView;
import ja.burhanrashid52.photoeditor.PhotoFilter;
import ja.burhanrashid52.photoeditor.SaveSettings;
import ja.burhanrashid52.photoeditor.ViewType;

import static com.loopj.android.http.AsyncHttpClient.LOG_TAG;

public class EditPhotoActivity extends AppCompatActivity {

    ImageView imgPhoto;

    Button saveBtn;

    PhotoEditor photoEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_photo);

        imgPhoto = findViewById(R.id.img_photo);
        saveBtn = findViewById(R.id.btn_save);

        Bundle extras = getIntent().getExtras();
        Uri uri = extras.getParcelable("image");

        PhotoEditorView photoEditorView = findViewById(R.id.photoEditorView);
        photoEditorView.getSource().setImageURI(uri);

        final Typeface firaSans = ResourcesCompat.getFont(this, R.font.firasans);

        Typeface emojiTypeFace = Typeface.createFromAsset(getAssets(), "firasans.ttf");

        photoEditor = new PhotoEditor.Builder(this, photoEditorView)
                .setPinchTextScalable(true)
                .setDefaultTextTypeface(firaSans)
                .setDefaultEmojiTypeface(emojiTypeFace)
                .build();

        photoEditor.setBrushDrawingMode(true);

        final SaveSettings saveSettings = new SaveSettings.Builder()
                .setClearViewsEnabled(true)
                .setTransparencyEnabled(true)
                .build();


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                photoEditor.saveAsFile("/storage/emulated/0/Download", saveSettings, new PhotoEditor.OnSaveListener() {
                    @Override
                    public void onSuccess(@NonNull String imagePath) {

                    }

                    @Override
                    public void onFailure(@NonNull Exception exception) {

                    }
                });
            }
        });

    }
}
