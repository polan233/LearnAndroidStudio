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
