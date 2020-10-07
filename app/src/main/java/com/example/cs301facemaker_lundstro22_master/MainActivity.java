/*
* @author Malia Lundstrom
*  main activity to run app
 */
package com.example.cs301facemaker_lundstro22_master;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Face face= findViewById(R.id.faceView);
        Spinner spinner= findViewById(R.id.hairSpinner);
        spinner.setOnItemSelectedListener(face);
        SeekBar redSeek= findViewById(R.id.Red);
        redSeek.setOnClickListener(face);
        SeekBar greenSeek= findViewById(R.id.Green);
        greenSeek.setOnClickListener(face);
        SeekBar blueSeek= findViewById(R.id.Blue);
        blueSeek.setOnClickListener(face);
        RadioButton hairButton= findViewById(R.id.hairButton);
        hairButton.setOnClickListener(face);
        RadioButton eyeButton= findViewById(R.id.eyeButton);
        eyeButton.setOnClickListener(face);
        RadioButton skinButton= findViewById(R.id.skinButton);
        skinButton.setOnClickListener(face);
        Button randomButton= findViewById(R.id.randomFace);
        randomButton.setOnClickListener(face);


    }

}
