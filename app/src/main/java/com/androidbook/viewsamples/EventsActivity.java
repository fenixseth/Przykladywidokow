package com.androidbook.viewsamples;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.TextView;

public class EventsActivity extends
    Activity {
    private String mSaveText = null;
    private GestureDetector mGestures = null;

    @Override
    public boolean onTouchEvent(
        MotionEvent event) {
        if (mGestures != null) {
            return mGestures
                .onTouchEvent(event);
        } else {
            return super
                .onTouchEvent(event);
        }
    }

    @Override
    protected void onCreate(
        Bundle savedInstanceState) {
 
        super
            .onCreate(savedInstanceState);
        
        setContentView(R.layout.events);
        
        /* demonstrowane zdarzenia:
        zmiany trybu dotyku
        zdarzenia dotyczące całego ekranu
        naciśnięcie i przytrzymanie
        gesty
        zmiany wybranej kontrolki        
        zdarzenia związane z pzyciskami i klawiaturą -- hmm... i tak nie działają, może je pominąć?
        */
        
        final TextView events = (TextView)findViewById(R.id.last_event_text);
        
        View all = findViewById(R.id.events_screen);
        
ViewTreeObserver vto =
    all
        .getViewTreeObserver();
vto
    .addOnTouchModeChangeListener(new ViewTreeObserver.OnTouchModeChangeListener() {

        public void onTouchModeChanged(
            boolean isInTouchMode) {
            events
                .setText("Tryb dotyku: "
                    + isInTouchMode);
        }
    });
        
        vto.addOnGlobalFocusChangeListener(new ViewTreeObserver.OnGlobalFocusChangeListener() {

            public void onGlobalFocusChanged(
                View oldFocus, View newFocus) {
                if (oldFocus != null && newFocus != null) {
                    events.setText("Wybrana kontrolka \nwcześniej: " + oldFocus.toString() + " \nteraz: " + newFocus.toString());    
                }
            }
        });

        Button long_press = (Button)findViewById(R.id.long_press);
        long_press.setOnLongClickListener(new View.OnLongClickListener() {

            public boolean onLongClick(View v) {
                events.setText("Long click: " + v.toString());
                return true;
            }
            
        });
        
               
        mGestures = new GestureDetector( new GestureDetector.SimpleOnGestureListener() {

            @Override
            public boolean onFling(
                MotionEvent e1, MotionEvent e2, float velocityX,
                float velocityY) {
                events.setText("Przesunięcie! \nx= " + velocityX + "px/s\ny="+velocityY + "px/s");
                
                return super
                    .onFling(
                        e1, e2, velocityX, velocityY);
            }

            @Override
            public boolean onScroll(
                MotionEvent e1, MotionEvent e2, float distanceX,
                float distanceY) {
                events.setText("Przewijanie! \nX = " + distanceX + "\nY = " +distanceY);
                return super 
                    .onScroll(
                        e1, e2, distanceX, distanceY);
            }
        });
        
        TextView focus = (TextView)findViewById(R.id.text_focus_change);
        focus.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(
                View v, boolean hasFocus) {
                
                if (hasFocus) {
                    if (mSaveText != null) {
                        ((TextView)v).setText(mSaveText);
                    }
                } else {
                    mSaveText = ((TextView)v).getText().toString();
                    ((TextView)v).setText("");
                
                }
            }
            
        });
        
        
    }

    @Override
    public boolean onKeyDown(
        int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        return super
            .onKeyDown(
                keyCode, event);
    }

    @Override
    public boolean onKeyMultiple(
        int keyCode, int repeatCount, KeyEvent event) {
        Log.d(ViewSampleActivity.debugTag, "Kod = "+keyCode);
        return super
            .onKeyMultiple(
                keyCode, repeatCount, event);
    }

    @Override
    public boolean onKeyUp(
        int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        return super
            .onKeyUp(
                keyCode, event);
    }

}
