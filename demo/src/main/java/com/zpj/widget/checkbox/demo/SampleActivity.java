package com.zpj.widget.checkbox.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.zpj.widget.checkbox.ZCheckBox;
import com.zpj.widget.checkbox.demo.databinding.ActivitySampleBinding;

public class SampleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivitySampleBinding binding = ActivitySampleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.scb.setOnCheckedChangeListener(new ZCheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(ZCheckBox checkBox, boolean isChecked) {
                Log.d("ZCheckBox", String.valueOf(isChecked));
            }
        });

        binding.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.checkBox.toggle();
            }
        });

        binding.checkBox.setOnCheckedChangeListener(new ZCheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(final ZCheckBox checkBox, boolean isChecked) {
                if (isChecked) {
                    checkBox.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            checkBox.setBorderColor(Color.BLACK);
                            checkBox.setBorderSize(10);
                            checkBox.setTickSize(10);
                            checkBox.setCheckedColor(Color.YELLOW);
                            checkBox.setDuration(2000);
                            ViewGroup.LayoutParams params = checkBox.getLayoutParams();
                            if (params.height != 1000) {
                                Toast.makeText(SampleActivity.this, "动态设置ZCheckBox参数", Toast.LENGTH_SHORT).show();
                                params.height = 1000;
                                checkBox.setLayoutParams(params);
                            }
                        }
                    }, checkBox.getDuration() * 2);
                }
            }
        });

    }

}
