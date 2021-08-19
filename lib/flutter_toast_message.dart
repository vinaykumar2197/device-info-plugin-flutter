
import 'dart:async';
import 'dart:convert';
import 'dart:io';

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

}
