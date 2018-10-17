# WaterMarkView

简单易用的水印控件

## 功能实现
- [x] 静态/动态加载
- [x] 支持全局同步更新水印内容和样式
- [x] 支持多行水印显示
- [x] 支持自定义角度、字体大小、字体颜色、粗体、间距

## 效果图
<img src="./snapshoot.gif"  width="400px"/>

## 准备工作
添加依赖<br>
1.Add it in your root build.gradle at the end of repositories:

```groovy
    allprojects {
    	repositories {
    		...
    		maven { url 'https://jitpack.io' }
    	}
    }
```
2.Add the dependency

```groovy
    dependencies {
    	 implementation 'com.github.AurelionX:WaterMarkView:$version'
    }
```

The latest version is: [![WaterMarkView](https://jitpack.io/v/AurelionX/WaterMarkView.svg)](https://jitpack.io/#AurelionX/WaterMarkView)

## 静态加载
```xml
<!-- 以下数据均为默认值 -->
<me.aurelion.x.ui.view.watermark.WaterMarkView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:align="CENTER"                  // 对齐方式
        app:degree="-30"                    // 角度
        app:dx="100px"                      // X间距
        app:dy="240px"                      // Y间距
        app:sync="true"                     // 是否同步（true:响应全局设置，false:独立生效）
        app:text="XXX///XXX"                // 水印内容（默认为空，"///"为默认分隔符）
        app:textBold="false"                // 是否粗体
        app:textColor="#3300000"            // 字体颜色
        app:textSize="42px"/>               // 字体大小
```

WaterMarkView常用方法

| 方法名 | 含义 | 备注 |
| :--- | :--- | :--- |
|setText(String... text)|设置水印文字内容||
|setDegrees(int degrees)|设置水印倾斜角度|默认:-30|
|setTextColor(int textColor)|设置水印字体颜色|默认:#33000000|
|setTextSize(int textSize)|设置水印字体大小|默认:42px|
|setTextBold(boolean textBold)|设置水印字体是否粗体|默认:false|
|setDx(int dx)|设置水印X轴偏移量|默认:100px|
|setDy(int dy)|设置水印Y轴偏移量|默认:240px|
|setAlign(Paint.Align align)|设置水印对齐方式|默认:CENTER|
|onDestroy()|同步更新时，需要在销毁相关页面时调用|重要！！！|

## 动态加载
### 修改Activity基类实现全局加载水印
```java
public abstract class BaseActivity extends AppCompatActivity {

    protected WaterMarkView mWmv;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        mWmv = WaterMarkManager.getView(this);
        ((ViewGroup) findViewById(android.R.id.content)).addView(mWmv);
    }

    @Override
    protected void onDestroy() {
        if (mWmv != null) {
            mWmv.onDestroy();
        }
        super.onDestroy();
    }
}
```

### 自定义全局样式
```java
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        WaterMarkManager.setInfo(
                WaterMarkInfo.create()
                        .setDegrees(-45)
                        .setTextSize(Utils.dp2px(getApplicationContext(), 20))
                        .setTextColor(Color.parseColor("#220000FF"))
                        .setTextBold(true)
                        .setDx(Utils.dp2px(getApplicationContext(), 60))
                        .setDy(Utils.dp2px(getApplicationContext(), 120))
                        .setAlign(Paint.Align.CENTER)
                        .generate());
    }
    
}
```

### 随时同步更新水印内容和样式
```java
    // 修改水印内容
    WaterMarkManager.setText("XXXXXX","XXXXXX");
```

WaterMarkManager常用**静态**方法

| 方法名 | 含义 | 备注 |
| :--- | :--- | :--- |
|setInfo(WaterMarkInfo info)|设置水印全局配置信息||
|getView(Activity activity)|获取一个满屏水印View|return WaterMarkView|
|setText(String content)|同步设置全部水印文字信息||
|setDegrees(int degrees)|同步设置全部水印倾斜角度|默认:-30|
|setTextColor(int textColor)|同步设置全部水印字体颜色|(默认:#33000000)|
|setTextSize(int textSize)|同步设置全部水印字体大小|默认:42px|
|setTextBold(boolean textBold)|同步设置全部水印字体是否粗体|默认:false|
|setDx(int dx)|同步设置全部水印X轴偏移量|默认:100px|
|setDy(int dy)|同步设置全部水印Y轴偏移量|默认:240px|
|setAlign(Paint.Align align)|同步设置全部水印对齐方式|默认:CENTER|

## License
   
    Copyright 2018 AurelionX

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

           http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
