package com.xx.Shopping.android.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        /**
         *  在规格，颜色文本框界面点击进入属性选择界面 FirstActivity ->SecondActivity
         */
        TextView tv1 = (TextView) findViewById(R.id.tv1);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        /**
         * 购买界面 FirstActivity ->BuyActivity
         */
        Button btn_buy= (Button) findViewById(R.id.btn_buy);
        btn_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(FirstActivity.this,BuyActivity.class);
                startActivity(intent1);
            }
        });

        /**
         * 加入购物车界面 FirstActivity ->AddActivity
         */
        Button btn_shopping_cart= (Button) findViewById(R.id.btn_shopping_cart);
        btn_shopping_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(FirstActivity.this,AddActivity.class);
                startActivity(intent2);
            }
        });
    }
}



