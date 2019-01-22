package com.example.qwert;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.qwert.base.BaseActivity;
import com.example.qwert.weight.FolatingButtonView;
import com.example.qwert.floatingbutton.R;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements FolatingButtonView.LoginTypeListener {

    private FolatingButtonView mPopupWindow;
    private Button buttonPanel;


    private String permissionInfo;
    private final int SDK_PERMISSION_REQUEST = 127;

    @Override
    public void CreateLayout() {
        setContentView(R.layout.activity_main);
        getPersimmions();
        buttonPanel = findViewById(R.id.buttonPanel);
    }

    @Override
    public void InitView() {

    }

    @TargetApi(23)
    private void getPersimmions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ArrayList<String> permissions = new ArrayList<String>();
            /***
             * 定位权限为必须权限，用户如果禁止，则每次进入都会申请
             */
            // 定位精确位置
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                permissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
            }
            if (checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                permissions.add(Manifest.permission.ACCESS_COARSE_LOCATION);
            }
            /*
             * 读写权限和电话状态权限非必要权限(建议授予)只会申请一次，用户同意或者禁止，只会弹一次
             */
            // 读写权限
            if (addPermission(permissions, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                permissionInfo += "Manifest.permission.WRITE_EXTERNAL_STORAGE Deny \n";
            }
            // 读取电话状态权限
            if (addPermission(permissions, Manifest.permission.READ_PHONE_STATE)) {
                permissionInfo += "Manifest.permission.READ_PHONE_STATE Deny \n";
            }

            if (permissions.size() > 0) {
                requestPermissions(permissions.toArray(new String[permissions.size()]), SDK_PERMISSION_REQUEST);
            }
        }
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


    //    @RequiresApi(api = Build.VERSION_CODES.M)
    @TargetApi(23)
    private boolean addPermission(ArrayList<String> permissionsList, String permission) {
        if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) { // 如果应用没有获得对应权限,则添加到列表中,准备批量申请
            if (shouldShowRequestPermissionRationale(permission)) {
                return true;
            } else {
                permissionsList.add(permission);
                return false;
            }

        } else {
            return true;
        }
    }

    @TargetApi(23)
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        // TODO Auto-generated method stub
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
