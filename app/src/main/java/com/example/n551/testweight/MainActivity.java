package com.example.n551.testweight;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    public static String sex = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1 = (Button) findViewById(R.id.btn_calculate);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et = (EditText) findViewById(R.id.et_height);
                double height = Double.parseDouble(et.getText().toString());
                RadioGroup rg = (RadioGroup) findViewById(R.id.rg_sex);
                rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        if (checkedId == R.id.rb_male) {
                            sex = "M";
                        } else {
                            sex = "F";
                        }
                    }
                });


                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Result.class);
                Bundle bundle = new Bundle();
                bundle.putDouble("height", height);
                bundle.putString("sex", sex);
	    	        /*将Bundle对象assign给Intent*/
                intent.putExtras(bundle);
	    	        /*调用Activity*/
                startActivity(intent);
            }
        });
    }
}
