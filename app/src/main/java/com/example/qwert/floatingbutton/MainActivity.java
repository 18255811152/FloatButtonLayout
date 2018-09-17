package com.example.qwert.floatingbutton;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

public class MainActivity extends Activity implements FolatingButtonActivity.LoginTypeListener {

    private FolatingButtonActivity mPopupWindow;
    private Button buttonPanel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonPanel = findViewById(R.id.buttonPanel);
    }

    public void onClick(View view) {
        if (mPopupWindow == null) {
            mPopupWindow = new FolatingButtonActivity(this);
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
