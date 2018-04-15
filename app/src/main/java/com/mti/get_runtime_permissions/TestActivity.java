package com.mti.get_runtime_permissions;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



public class TestActivity extends AppCompatActivity {

    Context mContext;

    GetRuntimePermission mGetRuntimePermission;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    mContext=this;


        Button button=findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mGetRuntimePermission=new GetRuntimePermission(mContext, GetRuntimePermission.TYPE_OF_PERMISSIONS.CALENDER) {
                    @Override
                    public void setTaskCompleteAction() {

                        Toast.makeText(mContext, "Task Successful Read External Calender", Toast.LENGTH_SHORT).show();
                    }
                };
            }

        });

        Button button1=findViewById(R.id.button4);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGetRuntimePermission=new GetRuntimePermission(mContext, GetRuntimePermission.TYPE_OF_PERMISSIONS.ACCESS_FINE_LOCATION) {
                    @Override
                    public void setTaskCompleteAction() {

                        Toast.makeText(mContext, "Task successful Read Location", Toast.LENGTH_SHORT).show();
                    }
                };
            }
        });



    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

             mGetRuntimePermission.onRequestPermissionsResult(requestCode,permissions,grantResults);
    }
}
