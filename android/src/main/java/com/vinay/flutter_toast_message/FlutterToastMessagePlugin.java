package com.vinay.flutter_toast_message;

import android.os.Build;

import androidx.annotation.NonNull;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** FlutterToastMessagePlugin */
public class FlutterToastMessagePlugin implements FlutterPlugin, MethodCallHandler {
  /// The MethodChannel that will the communication between Flutter and native Android
  ///
  /// This local reference serves to register the plugin with the Flutter Engine and unregister it
  /// when the Flutter Engine is detached from the Activity
  private MethodChannel channel;

  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
    channel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "flutter_toast_message");
    channel.setMethodCallHandler(this);
  }

  @Override
  public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {

    switch (call.method){
      case "getPlatformVersion":
        result.success("Android " + android.os.Build.VERSION.RELEASE);
        break;
      case "getDeviceInfoAndroid":

        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObjectBuildVersion = new JSONObject();

        try {
          jsonObjectBuildVersion.put("security_patch", Build.VERSION.SECURITY_PATCH);
          jsonObjectBuildVersion.put("release", Build.VERSION.RELEASE);
          jsonObjectBuildVersion.put("base_os", Build.VERSION.BASE_OS);
          jsonObjectBuildVersion.put("codename", Build.VERSION.CODENAME);
          jsonObjectBuildVersion.put("incremental", Build.VERSION.INCREMENTAL);
          jsonObjectBuildVersion.put("preview_sdk", Build.VERSION.PREVIEW_SDK_INT);
          jsonObjectBuildVersion.put("sdk", Build.VERSION.SDK_INT);
          jsonObject.put("version_details", jsonObjectBuildVersion);
          jsonObject.put("board", Build.BOARD);
          jsonObject.put("bootloader", Build.BOOTLOADER);
          jsonObject.put("brand", Build.BRAND);

//          JSONObject supportedJson = new JSONObject();
//          if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
//            String[] SUPPORTED_ABIS =   Build.SUPPORTED_ABIS;
//            for(int i = 0; i<SUPPORTED_ABIS.length; i++){
//              supportedJson.put(""+i,SUPPORTED_ABIS[i]);
//            }
//            jsonObject.put("supported_abis", supportedJson);
//          }
//          else{
//            jsonObject.put("supported_abis",supportedJson);
//          }

          jsonObject.put("brand", Build.BRAND);
          jsonObject.put("display", Build.DISPLAY);
          jsonObject.put("hardware", Build.HARDWARE);
          jsonObject.put("manufacturer", Build.MANUFACTURER);
          jsonObject.put("model", Build.MODEL);
          jsonObject.put("product", Build.PRODUCT);
          jsonObject.put("type", "android");

        }
        catch (Exception ex){
          ex.printStackTrace();
        }
        result.success(String.valueOf(jsonObject));

//        Map<String, Object> build = new HashMap<>();
//        build.put("board", Build.BOARD);
//        build.put("bootloader", Build.BOOTLOADER);
//        build.put("brand", Build.BRAND);
//        build.put("device", Build.DEVICE);
//        build.put("display", Build.DISPLAY);
//        build.put("fingerprint", Build.FINGERPRINT);
//        build.put("hardware", Build.HARDWARE);
//        build.put("host", Build.HOST);
//        build.put("id", Build.ID);
//        build.put("manufacturer", Build.MANUFACTURER);
//        build.put("model", Build.MODEL);
//        build.put("product", Build.PRODUCT);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//          build.put("supported32BitAbis", Arrays.asList(Build.SUPPORTED_32_BIT_ABIS));
//          build.put("supported64BitAbis", Arrays.asList(Build.SUPPORTED_64_BIT_ABIS));
//          build.put("supportedAbis", Arrays.asList(Build.SUPPORTED_ABIS));
//        }
//        build.put("tags", Build.TAGS);
//        build.put("type", Build.TYPE);
//        build.put("isPhysicalDevice", !isEmulator());
//
//
//        Map<String, Object> version = new HashMap<>();
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//          version.put("baseOS", Build.VERSION.BASE_OS);
//          version.put("previewSdkInt", Build.VERSION.PREVIEW_SDK_INT);
//          version.put("securityPatch", Build.VERSION.SECURITY_PATCH);
//        }
//        version.put("codename", Build.VERSION.CODENAME);
//        version.put("incremental", Build.VERSION.INCREMENTAL);
//        version.put("release", Build.VERSION.RELEASE);
//        version.put("sdkInt", Build.VERSION.SDK_INT);
//        build.put("version", version);

//        result.success(build);

        break;
      default:
        result.notImplemented();
        break;
    }
  }


  private boolean isEmulator() {
    return (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic"))
            || Build.FINGERPRINT.startsWith("generic")
            || Build.FINGERPRINT.startsWith("unknown")
            || Build.HARDWARE.contains("goldfish")
            || Build.HARDWARE.contains("ranchu")
            || Build.MODEL.contains("google_sdk")
            || Build.MODEL.contains("Emulator")
            || Build.MODEL.contains("Android SDK built for x86")
            || Build.MANUFACTURER.contains("Genymotion")
            || Build.PRODUCT.contains("sdk_google")
            || Build.PRODUCT.contains("google_sdk")
            || Build.PRODUCT.contains("sdk")
            || Build.PRODUCT.contains("sdk_x86")
            || Build.PRODUCT.contains("vbox86p")
            || Build.PRODUCT.contains("emulator")
            || Build.PRODUCT.contains("simulator");
  }

  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    channel.setMethodCallHandler(null);
  }
}
