package com.example.qwert;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.qwert.floatingbutton.FolatingButtonView;
import com.example.qwert.floatingbutton.R;

public class MainActivity extends Activity implements FolatingButtonView.LoginTypeListener {

    private FolatingButtonView mPopupWindow;
    private Button buttonPanel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonPanel = findViewById(R.id.buttonPanel);
    }

    public void onClick(View view) {
        if (mPopupWindow == null) {
            mPopupWindow = new FolatingButtonView(this);
            mPopupWindow.setLoginTypeListener(this);
        }
        mPopupWindow.showAtLocation(buttonPanel, Gravity.CENTER, 0, 0);
    }

    @Override
    public void onLogin(ImageView view, String type) {
        if (type.equals("QQ")) {
            Toast.makeText(MainActivity.this, "sssssssss", Toast.LENGTH_SHORT).show();
        }
    }
}
