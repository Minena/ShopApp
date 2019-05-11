package com.xx.Shopping.android.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private String[] name = {"无线鼠标可充电式笔记本台式电脑游戏办公家用无声静音男女生联想华硕惠普苹果小米戴尔机械无限电竞有声便携",
            "华研外语 大学英语六级阅读理解专项训练备考2019 赠阅读译文 大学英语6级阅读180篇 可搭英语六级真题试卷 词汇强化训练书CET考试",
            "运动短裤男科比詹姆斯欧文KD篮球短裤速干跑步健身短裤宽松五分裤",
            "胖子短袖t恤男士潮流夏季大码男装宽松纯棉加肥加大潮牌半袖衣服",
            "【限时限量低价抢】Apple/苹果 iPhone 8 Plus 64G 移动联通电信全网通4G手机 官方正品苹果iPhone8plus",
            "春夏季薄款工装裤男士国潮九分哈伦运动宽松小脚chic束脚裤子潮牌",
            "迷彩裤男韩版潮流束脚工装裤潮牌宽松百搭运动休闲春季九分男裤子",
            "伊利优酸乳酸奶整箱250ml*24盒原味草莓蓝莓AD成人学生早餐酸牛奶",
            "阿迪达斯运动长裤男休闲针织裤子训练透气束脚裤AK1566",
            "裤子男韩版潮流秋季男士休闲裤男宽松男生大码哈伦工装裤九分裤"};
    private int[] images = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five, R.drawable.six, R.drawable.seven, R.drawable.eight, R.drawable.nine, R.drawable.ten};
    List<Map<String, Object>> list_map = new ArrayList<Map<String, Object>>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.listView);
        for (int i = 0; i < 10; i++) {
            //采用集合方式来将图片和具体名称联系起来
            Map<String, Object> items = new HashMap<String, Object>();
            items.put("pic", images[i]);
            items.put("name", name[i]);
            list_map.add(items);
            //适配器将数据与列表联系起来
            SimpleAdapter simpleAdapter = new SimpleAdapter(MainActivity.this, list_map, R.layout.main, new String[]{"pic", "name"}, new int[]{R.id.items_imageView1, R.id.items_textView1});
            //列表上显示图片与具体名称
            listView.setAdapter(simpleAdapter);
        }

        /**
         * 点击列表进入下一界面并提示（由于知识有限，正在寻找方法能够点击某个界面就进入某个界面，惭愧！这里我只实现点击第一个界面就进入对应界面）
         MainActivity->FirstActivity
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map<String,Object>map=(Map<String, Object>) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this,map.get("name").toString(),Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,FirstActivity.class);
                startActivity(intent);
            }
        });



    }
}
