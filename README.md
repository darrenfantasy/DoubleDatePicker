# DoubleDatePicker
### 安卓双日期选择器，可以选择开始日期和结束日期。

![](http://oic2oders.bkt.clouddn.com/double_picker_1.gif)



![](http://oic2oders.bkt.clouddn.com/double_picker_2.gif)

### How to

**Step 1.** Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

**Step 2.** Add the dependency

```
	dependencies {
	        compile 'com.github.darrenfantasy:DoubleDatePicker:1.0'
	}
```

**Step 3.** API

```
/**
 * @param context
 * @param allowedSmallestDate 日期选择器的起始日期
 * @param allowedBiggestDate  日期选择器的终止日期
 */
public DoubleDateSelectDialog(Context context, String allowedSmallestDate, String allowedBiggestDate)
```

```
/**
 *
 * @param context
 * @param allowedSmallestDate 日期选择器的起始日期
 * @param allowedBiggestDate 日期选择器的终止日期
 * @param defaultChooseDate 日期选择器默认选择日期
 */
public DoubleDateSelectDialog(Context context, String allowedSmallestDate, String allowedBiggestDate, String defaultChooseDate)
```

```
/**
 * set监听
 *
 * @param onDateSelectFinished 完成监听
 */
public void setOnDateSelectFinished(OnDateSelectFinished onDateSelectFinished) 
```