import Flutter
import UIKit

public class SwiftFlutterToastMessagePlugin: NSObject, FlutterPlugin {
    let device = UIDevice.current
    
    public static func register(with registrar: FlutterPluginRegistrar) {
        let channel = FlutterMethodChannel(name: "flutter_toast_message", binaryMessenger: registrar.messenger())
        let instance = SwiftFlutterToastMessagePlugin()
        registrar.addMethodCallDelegate(instance, channel: channel)
    }
    
    public func handle(_ call: FlutterMethodCall, result: @escaping FlutterResult) {
        
        switch call.method {
        case "getPlatformVersion":
            result("iOS " + UIDevice.current.systemVersion)
            break
        case "getDeviceInfoIos":
            let device = UIDevice.current
            let model = device.model
            print(model) // e.g. "iPhone"
            
            //               let modelName = device.modelName
            //               print(modelName) // e.g. "iPhone 6"  /* see the extension */
            
            let deviceName = device.name
            print(deviceName) // e.g. "My iPhone"
            
            let systemName = device.systemName
            print(systemName) // e.g. "iOS"
            
            let systemVersion = device.systemVersion
            
            // "modelName":modelName,
            let para: [Any: Any] = [
                "model":model,
                "systemName":systemName,
                "systemVersion":systemVersion
            ]
            //               let para:NSMutableDictionary = NSMutableDictionary()
            //               para.setValue(model, forKey: "model")
            //               para.setValue(modelName, forKey: "modelName")
            //               para.setValue(systemName, forKey: "systemName")
            //               para.setValue(systemVersion, forKey: "systemVersion")
            //               let jsonData = try! NSJSONSerialization.dataWithJSONObject(para, options: NSJSONWritingOptions.allZeros)

            result(para)
            break
        default:
            result(FlutterMethodNotImplemented)
            break
        }
    }
}
