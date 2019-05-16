package com.fxp.codescanning;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.fxp.libzxing.CaptureActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.code_scan_txt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent("com.fxp.libzxing.CaptureActivity"), 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == CaptureActivity.QRCODE_REUSLT){
            if (data == null) return;
            String str = data.getStringExtra(CaptureActivity.EXTRA_RESULT);
            if (str != null && !str.isEmpty()){
                Toast.makeText(this, str, Toast.LENGTH_LONG).show();
            }
        }
    }
}
