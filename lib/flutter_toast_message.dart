
import 'dart:async';
import 'dart:collection';
import 'dart:convert';
import 'dart:io';
import 'package:flutter_toast_message/IosAadhaarModel.dart';

import 'AndroidAadhaarModel.dart';

import 'package:flutter/services.dart';

class FlutterToastMessage {
  static const MethodChannel _channel =
      const MethodChannel('flutter_toast_message');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    // Map<dynamic, dynamic> userdata = json.decode(version);
    // print("IOS VERSION "+version);
    // print(userdata);
    return version;
  }


  static Future<Object> get getDeviceInfo async {

    if (Platform.isAndroid) {
      // Android-specific code
      var version = await _channel.invokeMethod('getDeviceInfoAndroid');

      Map<dynamic, dynamic> userdata = json.decode(version);

      print("Android Version "+version);
      print(userdata);

      return version;

    } else if (Platform.isIOS) {
      // iOS-specific code
      var version = await _channel.invokeMethod('getDeviceInfoIos');

      print(version);

      return version;
    }

  }


  static Future<dynamic> startSdk( String token, String env, String client) async {
    // HashMap map1 = new HashMap<dynamic, dynamic>();
    if (Platform.isAndroid) {
      // Android-specific code
      // map1 =  await _channel.invokeMethod('startSdk',{"token":token,"env":env,"client":client});
      // return  map1;

      return AndroidAadhaarModel.fromMap(await _channel.invokeMethod('startSdk',{"token":token,"env":env,"client":client})
          ?? <String, dynamic>{}
      );

      // return AndroidAadhaarModel.fromMap((await channel
      //     .invokeMapMethod<String, dynamic>('getAndroidDeviceInfo')) ??
      //     <String, dynamic>{});

    } else if (Platform.isIOS) {

      return IosAadhaarModel.fromMap(await _channel.invokeMethod('startSdk',{"token":token,"env":env,"client":client})
          ?? <String, dynamic>{}
      );

      // iOS-specific code
      // var version = await _channel.invokeMethod('startSdk');
      //
      // print(version);
      //
      // return version;
    }

  }

}


