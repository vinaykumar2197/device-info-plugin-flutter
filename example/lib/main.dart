import 'dart:collection';
import 'dart:io';

import 'package:flutter/material.dart';
import 'dart:async';

import 'package:flutter/services.dart';
import 'package:flutter_toast_message/AndroidAadhaarModel.dart';
import 'package:flutter_toast_message/IosAadhaarModel.dart';
import 'package:flutter_toast_message/flutter_toast_message.dart';


void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  String _platformVersion = 'Unknown';
  Object _object;

  @override
  void initState() {
    super.initState();
    initPlatformState();
  }


  // Platform messages are asynchronous, so we initialize in an async method.
  Future<void> initPlatformState() async {
    // HashMap map1 = new HashMap<dynamic, dynamic>();

    // String platformVersion;
    // Object deviceObject;
    // Platform messages may fail, so we use a try/catch PlatformException.
    try {
      String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJyZXF1ZXN0X2lkIjoiZmJkODhmYTgtMzI5ZS00NGU3LWE1NmItOGJhYzQ0ZTAwYzA1IiwidXNlcl9pZCI6MzkwNzUwLCJzY29wZSI6WyJhYWRoYWFyX3htbCIsInZpZGVvX2t5YyIsImxpdmVuZXNzIl0sImVudiI6InRlc3QiLCJjbGllbnRfaWQiOiJSYWluX0luY19iTTVCNXMiLCJzdGFnZSI6InRlc3QiLCJ1c2VyX3R5cGUiOiJjdXN0b21lciIsImV4cGlyeV90aW1lIjoiMjctMDgtMjAyMVQxMDo1NDo0OCIsInRyYW5zYWN0aW9uSWQiOiIwMWIwMzE2NjA3MjExMWVjODk5MDdlZDU1OGRmNmJlOSJ9.UI0tti-zft-bxSjaYjvQDtHw2BLt02zOZUDzk2vxXc0";
      String env = "test";
      String client = "";
      AndroidAadhaarModel androidMap;
      String finalVal = "";
      IosAadhaarModel iosMap;
      if (Platform.isAndroid) {
        androidMap = await FlutterToastMessage.startSdk(token, env, client);
        String name = androidMap.name;
        String dob = androidMap.dob;
        print("name is ${name} and dob is ${dob}");
        finalVal = "name is ${name} and dob is ${dob}";
      }
      else if (Platform.isIOS) {
        iosMap = await FlutterToastMessage.startSdk(token, env, client);
        String name = iosMap.name;
        String dob = iosMap.dob;
        print("name is ${name} and dob is ${dob}");
        finalVal = "name is ${name} and dob is ${dob}";
      }


      setState(() {
        _platformVersion = finalVal;
      });
      // return map1;
    } on PlatformException {
      // platformVersion = 'Failed to get platform version.';

      // If the widget was removed from the tree while the asynchronous platform
      // message was in flight, we want to discard the reply rather than calling
      // setState to update our non-existent appearance.
      if (!mounted) return;

    }
    //
    // try {
    //   platformVersion = await FlutterToastMessage.platformVersion;
    // } on PlatformException {
    //   platformVersion = 'Failed to get platform version.';
    //
    //   // If the widget was removed from the tree while the asynchronous platform
    //   // message was in flight, we want to discard the reply rather than calling
    //   // setState to update our non-existent appearance.
    //   if (!mounted) return;
    //
    // }
    //
    // try{
    //   deviceObject = await FlutterToastMessage.getDeviceInfo;
    // }
    //
    // on PlatformException {
    //   // platformVersion = 'Failed to get platform version.';
    //
    //   // If the widget was removed from the tree while the asynchronous platform
    //   // message was in flight, we want to discard the reply rather than calling
    //   // setState to update our non-existent appearance.
    //   if (!mounted) return;
    //
    // }
    //

  }
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
          child: Text('Running on: $_platformVersion\n'),
        ),
      ),
    );
  }
}

enum EnumEnv {
  prod,
beta,
test}
