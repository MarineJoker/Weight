package com.example.n551.testweight;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends Activity
{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.result);

        Bundle bunde = this.getIntent().getExtras();

        String sex = bunde.getString("sex");
        double height = bunde.getDouble("height");

        String sexText="";
        if(sex.equals("M")){
            sexText="男性";
        }else{
            sexText="女性";
        }
    /* 取得标准体重 */
        String weight=this.getWeight(sex, height);

    /* 设定输出文字 */
        TextView tv1=(TextView) findViewById(R.id.text1);
        tv1.setText("你是"+sexText+"\n你的身高"+height+ "公分\n你的标准体重是"+weight+"公斤");
    }

    private String getWeight(String sex,double height)
    {
        String weight="";
        if(sex.equals("M"))
        {
            weight=format((height-80)*0.7);
        }else
        {
            weight=format((height-70)*0.6);
        }
        return weight;
    }
    private String format(double num)
    {
        NumberFormat formatter = new DecimalFormat("0.00");
        String s=formatter.format(num);
        return s;
    }

}
