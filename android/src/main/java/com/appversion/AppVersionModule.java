package com.appversion;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = AppVersionModule.NAME)
public class AppVersionModule extends ReactContextBaseJavaModule {
  public static final String NAME = "AppVersion";

  public AppVersionModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }

  @ReactMethod
  public void getAppVersion(Promise promise) {
    ReactApplicationContext context = getReactApplicationContext();
    String version = "";
    try {
      PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
      version = pInfo.versionName;
    } catch (PackageManager.NameNotFoundException e) {
      promise.reject(e);
    }
    promise.resolve(version);
  }

  @ReactMethod
  public void getBuildNumber(Promise promise) {
    ReactApplicationContext context = getReactApplicationContext();
    int build = 0;
    try {
      PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
      build = pInfo.versionCode;
    } catch (PackageManager.NameNotFoundException e) {
      promise.reject(e);
    }
    // change to a string to be consistent with iOS
    promise.resolve(Integer.toString(build));
  }
}
