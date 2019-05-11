package com.xx.Shopping.android.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;


public class  SecondActivity extends AppCompatActivity {
        String[] color={"红","黄","蓝"};
        int selectorPosition=0;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_second);
            initView();
        }
        private  void initView() {
            GridView mGridView = (GridView) findViewById(R.id.gridView);
            //添加数据
            List<String> mList = new ArrayList<>();
            for (int i = 0; i < color.length; i++) {
                mList.add(color[i]);
            }
            final GridViewAdapter mAdapter = new GridViewAdapter(this, mList);
            mGridView.setAdapter(mAdapter);
            //GridView的点击事件
            mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //把点击的position传递到adapter里面去
                    mAdapter.changeState(position);
                    selectorPosition = position;
                }
            });
        }

        /**
         * button的点击事件
         * 进入属性选择完毕界面 SecondActivity ->SingleSelectorActivity
         * @param view
         */
        public void buttonClick(View view){
            Intent intent=new Intent(SecondActivity.this,SingleSelectorActivity.class);
            intent.putExtra("pos",color[selectorPosition]);
            startActivity(intent);
        }

}
