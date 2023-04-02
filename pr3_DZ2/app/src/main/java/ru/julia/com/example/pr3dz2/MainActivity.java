package ru.julia.com.example.pr3dz2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView coordinatesOut;
    private float x;
    private float y;
    private String sDown;
    private String sMove;
    private String sUp;
    private final float xCat = 500;
    private


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coordinatesOut = findViewById(R.id.coordinatesOut);
        coordinatesOut.setOnTouchListener(listener);

    }
    private View.OnTouchListener listener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {

            x = motionEvent.getX();
            y = motionEvent.getY();
            switch (motionEvent.getAction()){
                case MotionEvent.ACTION_DOWN:
                    sDown =  "Нажата координата X =" + x + " координата y=" + y;
                    sMove = "";
                    sUp = "";
                    break;
                case MotionEvent.ACTION_MOVE:
                    sMove = "Нажата координата X =" + x + " координата y=" + y;
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    sMove = "";
                    sUp = "Отпускание: координата Х = " + x + ", координата y = " + y;
                    break;
            }
            coordinatesOut.setText(sDown + "\n" + sMove + "\n" + sUp);
            return true;
        }
    };
}