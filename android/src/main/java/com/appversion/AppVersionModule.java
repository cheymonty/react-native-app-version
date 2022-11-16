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
    try {
      PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
      String version = pInfo.versionName;
      promise.resolve(version);
    } catch (PackageManager.NameNotFoundException e) {
      promise.reject(e);
    }
  }

  @ReactMethod
  public void getBuildNumber(Promise promise) {
    ReactApplicationContext context = getReactApplicationContext();
    try {
      PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
      int build = pInfo.versionCode;
      promise.resolve(Integer.toString(build)); // change to string to be consistent with iOS
    } catch (PackageManager.NameNotFoundException e) {
      promise.reject(e);
    }
  }
}
