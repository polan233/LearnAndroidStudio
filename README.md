# LearnAndroidStudio

就在这里记笔记好了

## 几种常用的布局

一共有五种布局: LinearLayout线性布局,FrameLayout框架布局,AbsoluteLayout绝对布局,RelativeLayout相对布局,TableLayout表格布局,其中AbsoluteLayout和TableLayout不太常用.

### LinearLayout

是ViewGroup的子类,按照android:orientation的属性值对子View排序,android:layout_width和android:layout_height必须有,指定尺寸.

```java
android:orientation="vertical";//垂直排列
android:orientation="horizontal";//水平排列
```



#### 子元素的属性

- android:layout_gravity 设置子元素对于容器的对齐方式,可选值有: top bottom left right center_vertical center_horizontal center fill ...
- android:weight 设置子元素占容器的比例,值是整数

### RelativeLayout

灵活性很大,操作难度也很大

见写的登录界面实例

### FrameLayout

见写的实例,所有组件会位于这个容器的左上角,后面的会覆盖前面的

可以添加layout_gravity调整对齐方式

### 嵌套

看实例

## intent
Intent是不同组件之间通信的<strong>媒介</strong>或者<strong>信使</strong>

### intent实现Activity页面跳转
1. 第一个Activity添加setOnClickListener(),在这个方法里建立intent对象：<br>
   ```
    Intent intent=new Intent();
   ```
2. 设定如何启动另一个activity:
   ```
    Intent.setClass(CurrentActivity.this, OtherActivity.class);
    CurrentActivity.this.startActivity(intent);
   ```
