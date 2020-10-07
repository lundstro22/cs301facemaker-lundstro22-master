/*
* @author Malia Lundstrom
* face class to store face information
*
 */
package com.example.cs301facemaker_lundstro22_master;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SeekBar;
import android.widget.Spinner;


import androidx.annotation.RequiresApi;

import java.util.Random;

public class Face extends SurfaceView implements Spinner.OnItemSelectedListener, View.OnClickListener, SeekBar.OnSeekBarChangeListener{
    //declare variables
    public int skinColorR,skinColorG, skinColorB;
    public int eyeColorR, eyeColorG, eyeColorB;
    public int hairColorR, hairColorG, hairColorB;
    private int hairStyle;
    int xCanvas;
    int yCanvas;
    private Paint skinPaint= new Paint();
    private Paint eyePaint= new Paint();
    private Paint hairPaint= new Paint();
    private Paint background= new Paint();
    private int hairChoice=3;
    private int doIt;





    //constructor calls randomize() method
    public Face(Context context, AttributeSet attrs) {
        super(context,attrs);

        this.randomize();

        background.setColor(Color.WHITE);
        skinPaint.setARGB(255,skinColorR,skinColorG,skinColorB);
        eyePaint.setARGB(255, eyeColorR, eyeColorG, eyeColorB);
        hairPaint.setARGB(255,hairColorR,hairColorG,hairColorB);
    }

    public void randomize() {
        Random r= new Random();
        //initialize variables
        this.skinColorR= r.nextInt(255);
        this.eyeColorR= r.nextInt(255);
        this.hairColorR= r.nextInt(255);
        this.skinColorG= r.nextInt(255);
        this.eyeColorG= r.nextInt(255);
        this.hairColorG= r.nextInt(255);
        this.skinColorB= r.nextInt(255);
        this.eyeColorB= r.nextInt(255);
        this.hairColorB= r.nextInt(255);
        this.hairStyle= r.nextInt();
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onDraw(Canvas canvas){
        drawHair(canvas);
        drawFace(canvas);


    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void drawFace(Canvas canvas){
        xCanvas= canvas.getWidth();
        yCanvas= canvas.getHeight();
        canvas.drawCircle(xCanvas/2, yCanvas/2, xCanvas/3, skinPaint);
        canvas.drawCircle((xCanvas/2)-(xCanvas/15), (yCanvas/3), xCanvas/30, eyePaint);
        canvas.drawCircle((xCanvas/2)+(xCanvas/15), (yCanvas/3), xCanvas/30, eyePaint);
        canvas.drawCircle(xCanvas/2, yCanvas*2/3, yCanvas/35, eyePaint);

    }

    /*External Citation
    * Date: October 6, 2020
    * Problem: How to draw hair
    * Resource: thoughtbot.com
    * Solution: use drawArc to make hair
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void drawHair(Canvas canvas){
        if(hairChoice==0){
            canvas.drawArc(xCanvas/5,yCanvas/16,xCanvas*4/5,yCanvas*4/10,180,180,false,hairPaint);
        }else if(hairChoice==1){
            canvas.drawOval(xCanvas/12, yCanvas/16, xCanvas*11/12, yCanvas*5/6,hairPaint);
        }else if(hairChoice==2){
            canvas.drawArc(xCanvas/12,yCanvas/16,xCanvas*11/12,yCanvas*4/10,180,180,false,hairPaint);
            canvas.drawRect(xCanvas/12,yCanvas/5,xCanvas*11/12,yCanvas*15/16,hairPaint);
        }


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        hairChoice= position;
        this.invalidate();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        hairChoice= 3;

    }
/*External Citation
*Date: October 6
* Problem: Converting hex to rgb values
* Resource: https://stackoverflow.com/questions/7427141/how-to-get-rgb-value-from-hexadecimal-color-code-in-java
* Solution: separate into 3 ints, used code suggested in forum
 */

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.randomFace){
            Random rand= new Random();
            hairChoice= rand.nextInt(2);
            this.randomize();
            skinPaint.setARGB(255,skinColorR,skinColorG,skinColorB);
            eyePaint.setARGB(255, eyeColorR, eyeColorG, eyeColorB);
            hairPaint.setARGB(255,hairColorR,hairColorG,hairColorB);
            this.invalidate();
        }
        if(v.getId()==R.id.hairButton){ doIt=1; }
        if(v.getId() == R.id.eyeButton){ doIt=2; }
        if(v.getId() == R.id.skinButton) { doIt=3; }


    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if(doIt==1) {
            if (seekBar.getId() == R.id.Red) {
                hairColorR= progress;
                this.invalidate();
            }
            if (seekBar.getId() == R.id.Green) {
                hairColorG= progress;
                this.invalidate();
            }
            if (seekBar.getId() == R.id.Blue) {
                hairColorB= progress;
                this.invalidate();
            }
        }if(doIt==2) {
            if (seekBar.getId() == R.id.Red) {
                eyeColorR= progress;
                this.invalidate();
            }
            if (seekBar.getId() == R.id.Green) {
                eyeColorG= progress;
                this.invalidate();
            }
            if (seekBar.getId() == R.id.Blue) {
                eyeColorB= progress;
                this.invalidate();
            }
        }if(doIt==3) {
                if (seekBar.getId() == R.id.Red) {
                    skinColorR= progress;
                    this.invalidate();
                }
                if (seekBar.getId() == R.id.Green) {
                    skinColorG= progress;
                    this.invalidate();
                }
                if (seekBar.getId() == R.id.Blue) {
                    skinColorB= progress;
                    this.invalidate();
                }
        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
