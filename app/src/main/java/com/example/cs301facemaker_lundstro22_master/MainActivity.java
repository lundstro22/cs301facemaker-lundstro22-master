/*
* @author Malia Lundstrom
*  main activity to run app
 */
package com.example.cs301facemaker_lundstro22_master;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements RadioButton.OnClickListener{
    private int r;
    private int b;
    private int g;
    public int doIt=0;
    private int eyeR,eyeG,eyeB,skinR,skinG,skinB,hairR,hairG,hairB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Face face= findViewById(R.id.faceView);
        eyeR= face.eyeColorR;
        eyeG= face.eyeColorG;
        eyeB= face.eyeColorB;
        skinR= face.skinColorR;
        skinG= face.skinColorG;
        skinB= face.skinColorB;
        hairR= face.hairColorR;
        hairG= face.hairColorG;
        hairB= face.hairColorB;

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
        if(doIt==1){
            redSeek.setProgress(hairR);
            greenSeek.setProgress(hairG);
            blueSeek.setProgress(hairB);
        }if(doIt==2){
            redSeek.setProgress(eyeR);
            greenSeek.setProgress(eyeG);
            blueSeek.setProgress(eyeB);
        }if(doIt==3){
            redSeek.setProgress(skinR);
            greenSeek.setProgress(skinG);
            blueSeek.setProgress(skinB);
        }

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.hairButton){ doIt=1; }
        if(v.getId() == R.id.eyeButton){ doIt=2; }
        if(v.getId() == R.id.skinButton) { doIt=3; }
    }
}
