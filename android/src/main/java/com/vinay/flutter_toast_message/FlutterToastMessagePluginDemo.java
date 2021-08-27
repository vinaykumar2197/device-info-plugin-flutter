package com.vinay.flutter_toast_message;


import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.karza.aadhaarsdk.AadharActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import io.flutter.app.FlutterActivity;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;

/** FlutterToastMessagePlugin */
public class FlutterToastMessagePluginDemo extends FlutterActivity  {
  /// The MethodChannel that will the communication between Flutter and native Android
  ///
  /// This local reference serves to register the plugin with the Flutter Engine and unregister it
  /// when the Flutter Engine is detached from the Activity
  private MethodChannel channel;
  private String karzaToken, clientName;
  private  String env;
  private static final String TAG = "FlutterToast";
//  private Activity activity;
  private  Result result;


  @Override
  public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
    super.onCreate(savedInstanceState, persistentState);
    channel = new MethodChannel(getFlutterView(), "flutter_toast_message");
    channel.setMethodCallHandler(new MethodCallHandler() {
      @Override
      public void onMethodCall(@NonNull MethodCall call, @NonNull MethodChannel.Result resultCustom) {
        result = resultCustom;
//    channel.setMethodCallHandler(
//            new MethodChannel.MethodCallHandler() {
//              @Override
//              public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
////                String url = call.argument("url");

        switch (call.method){
          case "getPlatformVersion":
            result.success("Android " + Build.VERSION.RELEASE);
            break;
          case "startSdk":
            karzaToken =call.argument("token").toString();
            env =   call.argument("env").toString();
            clientName =  call.argument("client").toString();

//                    karzaToken ="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJyZXF1ZXN0X2lkIjoiMDRiOTA1YjMtY2YzMi00OWI0LTg1NTMtOWVjNWZjMTYxMmFjIiwidXNlcl9pZCI6MzkwNzUwLCJzY29wZSI6WyJhYWRoYWFyX3htbCIsInZpZGVvX2t5YyIsImxpdmVuZXNzIl0sImVudiI6InRlc3QiLCJjbGllbnRfaWQiOiJSYWluX0luY19iTTVCNXMiLCJzdGFnZSI6InRlc3QiLCJ1c2VyX3R5cGUiOiJjdXN0b21lciIsImV4cGlyeV90aW1lIjoiMjMtMDgtMjAyMVQxNzoxNDoyNSIsInRyYW5zYWN0aW9uSWQiOiI1ZWM3ZDkzMjA0MzExMWVjOThiMWNhNTU2N2JmMGUyNyJ9.-qXWZU9D9SkZlpSEq-AGXrzW67B1X3UqTVSkygvH1AM";
//                    env =  EnvType.TEST.env;
//                    clientName =  "";
            startSdk();

//                    AadhaarXMLDatas aadhaarXMLDatas = new AadhaarXMLDatas();
//                    HashMap<String, Object> map = new Gson().fromJson(jsonObj.toString(), HashMap.class);
//                    Map map = new HashMap<>();
//                    Map<Object, Object> map = new HashMap<>();
//
//                    map.put("name","Vinay");
//                    map.put("dob","21/03/1997");
//                    result.success(map);
//        result.success("Android " + android.os.Build.VERSION.RELEASE);
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
    });
  }




  public enum EnvType {
    PRODUCTION("prod"),
    ALPHA("alpha"),
    BETA("beta"),
    DEV("dev"),
    TEST("test");
    public String env;
    EnvType(String env) {
      this.env = env;
    }
  }


  private void startSdk() {
//    Intent intent = new Intent(activity, AadharActivity.class);
    Intent intent = new Intent(FlutterToastMessagePluginDemo.this, AadharActivity.class);
    intent.putExtra("KARZA-TOKEN", karzaToken);
    intent.putExtra("ENV", env);
    intent.putExtra("CLIENT", clientName);
    startActivityForResult(intent, 100);
  }

  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (resultCode == RESULT_OK && requestCode == 100) {

      Bundle bundle = data.getExtras();
      if (bundle != null) {
        Gson gson = new Gson();
        try {
          JSONObject jsonObj = new JSONObject(getJson(bundle));
//          final AadhaarXMLDatas aadhaarXMLDatas = gson.fromJson(jsonObj.toString(), AadhaarXMLDatas.class);
//          Map<Object, Object> map = new HashMap<>();
          Log.e("data_fetched",jsonObj.toString());
          Map<Object, Object> map = new Gson().fromJson(jsonObj.toString(), HashMap.class);
          Log.e("data_fetched",map.toString());
          result.success(map);

//          Intent intent = new Intent(MainActivity.this, AadhaarXMLOutputActivity.class);
//          intent.putExtra("AADHAARxml", aadhaarXMLDatas);
//          startActivity(intent);
//          finish();
        } catch (Exception ex) {
          ex.printStackTrace();
        }


      }
    }
  }


  /* get bundle to json data (Start)*/
  public static String getJson(final Bundle bundle) {
    if (bundle == null) return null;
    JSONObject jsonObject = new JSONObject();

    for (String key : bundle.keySet()) {
      Object obj = bundle.get(key);
      try {
        jsonObject.put(key, wrap(bundle.get(key)));
      } catch (JSONException e) {
        e.printStackTrace();
      }
    }
    return jsonObject.toString();
  }

  private static Object wrap(Object object) {
    if (object == null) {
      return JSONObject.NULL;
    }
    if (object instanceof JSONArray || object instanceof JSONObject) {
      return object;
    }
    if (object.equals(JSONObject.NULL)) {
      return object;
    }
    try {
      if (object instanceof Collection) {
        return new JSONArray((Collection) object);
      } else if (object.getClass().isArray()) {
        return toJSONArray(object);
      }
      if (object instanceof Map) {
        return new JSONObject((Map) object);
      }
      if (object instanceof Boolean ||
              object instanceof Byte ||
              object instanceof Character ||
              object instanceof Double ||
              object instanceof Float ||
              object instanceof Integer ||
              object instanceof Long ||
              object instanceof Short ||
              object instanceof String) {
        return object;
      }
      if (object.getClass().getPackage().getName().startsWith("java.")) {
        return object.toString();
      }
    } catch (Exception ignored) {
    }
    return null;
  }


  private static JSONArray toJSONArray(Object array) throws JSONException {
    JSONArray result = new JSONArray();
    if (!array.getClass().isArray()) {
      throw new JSONException("Not a primitive array: " + array.getClass());
    }
    final int length = Array.getLength(array);
    for (int i = 0; i < length; ++i) {
      result.put(wrap(Array.get(array, i)));
    }
    return result;
  }




//  @Override
//  public void onAttachedToActivity(ActivityPluginBinding binding) {
//    activity = (FlutterActivity) binding.getActivity();
//  }
//
//  @Override
//  public void onDetachedFromActivityForConfigChanges() {
//
//  }
//
//  @Override
//  public void onReattachedToActivityForConfigChanges(ActivityPluginBinding binding) {
////    activity =(FlutterActivity) binding.getActivity();
//  }
//
//  @Override
//  public void onDetachedFromActivity() {
//    activity = null;
//  }

}
