package com.example.tablo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int NaviPoint = 0;
    int VirtusProPoint = 0;
    TextView counterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        resetUI();
    }

    @Override
    protected void onSaveInstanceState(Bundle outstate) {
        super.onSaveInstanceState(outstate);
        outstate.putInt("Navi", NaviPoint);
        outstate.putInt("VirtusPro", VirtusProPoint);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null &&
                savedInstanceState.containsKey("Navi") && savedInstanceState.containsKey("VirtusPro")) {
            NaviPoint = savedInstanceState.getInt("Navi");
            VirtusProPoint = savedInstanceState.getInt("VirtusPro");
        }
    }

    private void resetUI() {
        ((TextView) findViewById(R.id.Navi)).setText("" + NaviPoint);
        ((TextView) findViewById(R.id.VirtusPro)).setText("" + VirtusProPoint);

    }

    public void ClickNavi(View view) {
        NaviPoint++;
        counterView = (TextView)findViewById(R.id.Navi);
        counterView.setText(""+NaviPoint);
        if (NaviPoint > 99){
        counterView.setTextSize(56);}
    }

    public void ClickVirtuesPro(View view) {
        VirtusProPoint++;
        counterView = (TextView)findViewById(R.id.VirtusPro);
        counterView.setText(""+VirtusProPoint);
        if (VirtusProPoint > 99){
        counterView.setTextSize(56); }
    }

    public void ClickResrt(View view) {
        counterView = (TextView)findViewById(R.id.Navi);
        if (NaviPoint > 99){
        counterView.setTextSize(72);}
        NaviPoint=0;
        counterView.setText(""+NaviPoint);
        counterView = (TextView)findViewById(R.id.VirtusPro);
        if (VirtusProPoint > 99){
        counterView.setTextSize(72);}
        VirtusProPoint=0;
        counterView.setText(""+VirtusProPoint);
    }
}