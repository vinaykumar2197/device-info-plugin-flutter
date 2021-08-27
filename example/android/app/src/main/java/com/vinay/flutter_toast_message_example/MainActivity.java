package com.vinay.flutter_toast_message_example;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugins.GeneratedPluginRegistrant;

public class MainActivity extends FlutterActivity {

    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
//        super.configureFlutterEngine(flutterEngine);
        GeneratedPluginRegistrant.registerWith(flutterEngine) ;// add this line

    }

}
