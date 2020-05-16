EasyPermission库是一个谷歌官方提供的简化基本的系统权限逻辑的库，可用于在Android M或者更高版本上。

官方项目地址：https://github.com/googlesamples/easypermissions

### EasyPermission配置依赖

在需要使用此库的module的build.gradle中添加以下代码：

```
dependencies {
    // For developers using AndroidX in their applications
    implementation 'pub.devrel:easypermissions:3.0.0'
 
    // For developers using the Android Support Library
    implementation 'pub.devrel:easypermissions:2.0.1'
}
```

### EasyPermission使用流程

权限可以是单个，也可以是一些列。在EasyPermission库中，使用EasyPermissions#hasPermissions(...)检查若干权限。

```
/**
*
* @param context
* return true:已经获取权限
* return false: 未获取权限，主动请求权限
*/

public static boolean checkPermission(Activity context,String[] perms) {
　　return EasyPermissions.hasPermissions(context, perms);
}
```

**EasyPermissions.hasPermissions():**

第一个参数 : Context参数.例如，Activity对象。

第二个参数 : 一些系列的权限。例如，public final static String[] PERMS_WRITE ={Manifest.permission.WRITE_EXTERNAL_STORAGE};



检查后，发觉用户没有赋予权限，这时候需要代码请求权限，让用户同意。

在EasyPermission库中，使用EasyPermissions#requestPermissions,来请求权限。

```
/**
* 请求权限
* @param context
*/
public static void requestPermission(Activity context,String tip,int requestCode,String[] perms) {
　　EasyPermissions.requestPermissions(context, tip,requestCode,perms);
}
```

**EasyPermissions.requestPermissions():**

第一个参数：Context对象
第二个参数：权限弹窗上的文字提示语。告诉用户，这个权限用途。
第三个参数：这次请求权限的唯一标示，code。
第四个参数 : 一些系列的权限。



请求后，弹出系统权限弹窗，剩下是用户是否授权操作。权限结果是回调在Activity或者Fragment中的重写的onRequestPermissionsResult()方法中。

```
public class MainActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {

//.....省略部分代码。

/**
* 重写onRequestPermissionsResult，用于接受请求结果
*
* @param requestCode
* @param permissions
* @param grantResults
*/
@Override
public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
　　super.onRequestPermissionsResult(requestCode, permissions, grantResults);
　　//将请求结果传递EasyPermission库处理
　　EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
}

/**
* 请求权限成功。
* 可以弹窗显示结果，也可执行具体需要的逻辑操作
*
* @param requestCode
* @param perms
*/
@Override
public void onPermissionsGranted(int requestCode, List<String> perms) {
　　ToastUtils.showToast(getApplicationContext(), "用户授权成功");
}
/**
* 请求权限失败
*
* @param requestCode
* @param perms
*/
@Override
public void onPermissionsDenied(int requestCode, List<String> perms) {
　　ToastUtils.showToast(getApplicationContext(), "用户授权失败");
　　/**
　　* 若是在权限弹窗中，用户勾选了'NEVER ASK AGAIN.'或者'不在提示'，且拒绝权限。
　　* 这时候，需要跳转到设置界面去，让用户手动开启。
　　*/
　　if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
　　　　new AppSettingsDialog.Builder(this).build().show();
　　}
}
}
```

将权限结果传递给EasyPermissions.onRequestPermissionsResult()来处理。

EasyPermissions.onRequestPermissionsResult()方法：

第一个参数： 请求的code
第二个参数： 一些列的请求权限
第三个参数： 用户授权的结果
第四个参数： 权限回调监听器
这里不需要手写判断权限是否成功的逻辑操作，而会在EasyPermissions.PermissionCallbacks监听器中响应。

EasyPermissions.PermissionCallbacks接口：

- onPermissionsGranted()：用户授权成功，接下来执行具体需要的逻辑操作
- onPermissionsDenied()：用户授权失败，处理失败的逻辑。

**注意**：若是在权限弹窗中，用户勾选了’NEVER ASK AGAIN.’或者’不在提示’，且拒绝权限。 这时候，需要跳转到设置界面去，让用户手动开启。

你可能并不满足，需要手动调用逻辑处理方法。EasyPermissions库为你考虑好了，具备强大之处。当用户同意权限后，可以不需要通过监听器方式来实现，直接调用相关的逻辑代码的方法。只需要使用@AfterPermissionGranted注解标注逻辑处理的方法。



@AfterPermissionGranted注解为了提供方便，但可以添加也可以不添加，是可选的。

好处：

使用了该注解，当权限请求被用户同意后，会根据请求code来执行，相应的含有@AfterPermissionGranted注解的方法。

简化了请求成功操作流程，不需要在EasyPermissions.onRequestPermissionsResult()的回调监听器中请求成功的方法中，再次手动调用，获取权限后需要操作的逻辑代码。

以下代码，请求写入磁盘的权限，当用户同意权限后，弹出一个Toast弹窗的逻辑处理操作。

```
@AfterPermissionGranted(Constance.WRITE_PERMISSION_CODE) // 可选的
public void onPermissionsSuccess() {
　　ToastUtils.showToast(getApplicationContext(), "用户授权成功");
}
```

当用户同意权限，该方法不需要手动调用，会匹配到的Constance.WRITE_PERMISSION_CODE请求码，自动执行。

在权限弹窗中，用户可能直接拒绝权限，下次权限请求依旧会弹出该权限弹窗。除此之外，还可以勾选’NEVER ASK AGAIN.’或者’不在提示’，且拒绝权限，下次请求权限，弹窗不能弹出，无法让用户授权。这时候，需要跳转到设置界面去，让用户手动开启。

在EasyPermission库中，使用EasyPermissions.somePermissionPermanentlyDenied()来处理，是否勾选不再提示的选项。

```
/**
* 请求权限失败
*
* @param requestCode
* @param perms
*/
@Override
public void onPermissionsDenied(int requestCode, List<String> perms) {
　　ToastUtils.showToast(getApplicationContext(), "用户授权失败");
　　/**
　　* 若是在权限弹窗中，用户勾选了'NEVER ASK AGAIN.'或者'不在提示'，且拒绝权限。
　　* 这时候，需要跳转到设置界面去，让用户手动开启。
　　*/
　　if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
　　　　new AppSettingsDialog.Builder(this).build().show();
　　}
}

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
　　super.onActivityResult(requestCode, resultCode, data);
　　switch (requestCode) {
　　//当从软件设置界面，返回当前程序时候
　　case AppSettingsDialog.DEFAULT_SETTINGS_REQ_CODE:
　　　　//执行Toast显示或者其他逻辑处理操作
　　　　break;
　　} 
}
```

以上代码是，当无法弹出权限弹框，直接跳转到设置界面去，让用户手动开启权限。

当从设置界面返回时候，结果会在Activity或者Fragment中onActivityResult()响应。