#ZCheckBox

### ScreenShot 截图:

![](demo.gif)

### Attrs 属性
|attr|format|description|
|---|:---|:---:|
|z_checkbox_anim_duration|integer|动画持续时间|
|z_checkbox_border_size|dimension|未选中时边框宽度|
|z_checkbox_border_color|color|未选中时边框颜色|
|z_checkbox_tick_size|dimension|对勾大小|
|z_checkbox_tick_color|color|对勾颜色|
|z_checkbox_checked_color|color|选中时填充颜色|
|z_checkbox_unchecked_color|color|未选中时填充颜色|

## Usage 使用

```gradle
dependencies {
  implementation 'com.github.Z-P-J:ZCheckBox:1.0.0'
}
```

```java
    setChecked(boolean checked);                   // 设置状态，默认带动画
    setChecked(boolean checked, boolean animate);  // 设置状态，参数:animate 是否显示动画
    setCheckedWithoutAnim(boolean checked);        // 设置状态，不带动画
    toggle(boolean checked);                       // 切换状态，带动画
    toggleWithoutAnim(boolean checked);            // 切换状态，不带动画
```

```java

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
    }    
```

## License

    Copyright 2021 Z-P-J
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
       http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.