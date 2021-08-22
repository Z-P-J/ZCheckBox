package com.zpj.widget.checkbox.demo;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.zpj.widget.checkbox.ZCheckBox;

import java.io.Serializable;
import java.util.ArrayList;

public class SampleListViewActivity extends AppCompatActivity {

    private final ArrayList<Bean> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        for (int i = 0; i < 100; i++) {
            mList.add(new Bean());
        }

        ListView lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return mList.size();
            }

            @Override
            public Object getItem(int position) {
                return mList.get(position);
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(final int position, View convertView, ViewGroup parent) {
                ViewHolder holder;
                if (convertView == null) {
                    holder = new ViewHolder();
                    convertView = View.inflate(SampleListViewActivity.this, R.layout.item, null);
                    holder.tv = (TextView) convertView.findViewById(R.id.tv);
                    holder.cb = (ZCheckBox) convertView.findViewById(R.id.scb);
                    convertView.setTag(holder);
                } else {
                    holder = (ViewHolder) convertView.getTag();
                }

                final Bean bean = mList.get(position);
                holder.cb.setOnCheckedChangeListener(new ZCheckBox.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(ZCheckBox checkBox, boolean isChecked) {
                        bean.isChecked = isChecked;
                    }
                });
                String text = getString(R.string.string_item_subffix) + position;
                holder.tv.setText(text);
                holder.cb.setChecked(bean.isChecked, false);

                return convertView;
            }

            class ViewHolder {
                ZCheckBox cb;
                TextView tv;
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bean bean = (Bean) parent.getAdapter().getItem(position);
                bean.isChecked = !bean.isChecked;
                ZCheckBox checkBox = (ZCheckBox) view.findViewById(R.id.scb);
                checkBox.setChecked(bean.isChecked, true);
            }
        });
    }

    class Bean implements Serializable {
        boolean isChecked;
    }
}
