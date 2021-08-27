import Flutter
import UIKit
import OfflineAadhaar

extension SwiftFlutterToastMessagePlugin: KAadhaarVerificationDelegate {

    public func getAadhaarData(aadhaarData: [String : Any]) {
        print(aadhaarData)
        if result != nil {
        result!(aadhaarData)
            
            UIApplication.shared.keyWindow!.rootViewController = flutterController
            
            UIApplication.shared.keyWindow!.makeKeyAndVisible()
            
            
//        navigationController.popViewController(animated: true)
        }
  }

}

public class SwiftFlutterToastMessagePlugin: NSObject, FlutterPlugin  {
    
    
    let device = UIDevice.current
    
    var result: FlutterResult?
    var flutterController : FlutterViewController!
    private let rootViewController: UIViewController

    let navigationController = UINavigationController()
    
    init(_ rootViewController: UIViewController) {
            self.rootViewController = rootViewController
    }

    
//    let flutterViewController: FlutterViewController = window?.rootViewController as! FlutterViewController

    

    
    public static func register(with registrar: FlutterPluginRegistrar) {
        let channel = FlutterMethodChannel(name: "flutter_toast_message", binaryMessenger: registrar.messenger())
        let rootViewController = UIApplication.shared.delegate!.window!!.rootViewController!

        let instance = SwiftFlutterToastMessagePlugin(rootViewController)
        registrar.addMethodCallDelegate(instance, channel: channel)
    }
    
    
    
    
    public func handle(_ call: FlutterMethodCall, result resultVal: @escaping FlutterResult) {
        result = resultVal
        
        switch call.method {
        case "startSdk":
            guard let args = call.arguments else {
                   return
                 }
            let myArgs = args as? [String: Any]
            let token  = myArgs?["token"] as? String
            let env = myArgs?["env"] as? String
            let client  = myArgs?["client"] as? String
            
            let vc = OfflineAadhaarViewController(karzaToken: token!, environmentString: env!, clientCode: client!)

            vc.delegate = self
            
            
//
//
//
            flutterController = UIApplication.shared.keyWindow?.rootViewController as! FlutterViewController
            
//
//
//            let navigationController = UINavigationController(rootViewController: vc)
//            UIApplication.shared.keyWindow?.rootViewController = navigationController
//            UIApplication.shared.keyWindow?.makeKeyAndVisible()
//
            
//            navigationController.pushViewController(vc, animated: true)

//
//            UIApplication.shared.keyWindow?.rootViewController?.present(vc, animated: true)
            
            
            
//
//            let navigationController = UINavigationController(rootViewController: vc)
//            (rootViewController as! UINavigationController).pushViewController(navigationController, animated: true)
            
            
            
            
            

            UIApplication.shared.keyWindow!.rootViewController = navigationController
            
//            navigationController.navigationBar.isHidden = true
            navigationController.setNavigationBarHidden(true, animated: true)
            navigationController.pushViewController(vc, animated: true)


            UIApplication.shared.keyWindow!.makeKeyAndVisible()

//
//            DispatchQueue.main.async {
//
//            let rootViewController:UIViewController! = UIApplication.shared.keyWindow?.rootViewController
//
//
//            if (rootViewController is UINavigationController) {
//                              (rootViewController as! UINavigationController).pushViewController(vc,animated:true)
//                          } else {
//                              let navigationController:UINavigationController! = UINavigationController(rootViewController:vc)
//                            rootViewController.present(navigationController, animated:true, completion:nil)
//                          }
//                    }
            
            
            
//            self.present(vc, animated: true)
//            result("iOS " + UIDevice.current.systemVersion)
            break
        case "getPlatformVersion":
            if result != nil {
                result!("iOS " + UIDevice.current.systemVersion)
            }
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
//            let para: [Any: Any] = [
//                "model":model,
//                "systemName":systemName,
//                "systemVersion":systemVersion
//            ]
            //               let para:NSMutableDictionary = NSMutableDictionary()
            //               para.setValue(model, forKey: "model")
            //               para.setValue(modelName, forKey: "modelName")
            //               para.setValue(systemName, forKey: "systemName")
            //               para.setValue(systemVersion, forKey: "systemVersion")
            //               let jsonData = try! NSJSONSerialization.dataWithJSONObject(para, options: NSJSONWritingOptions.allZeros)

//            result(para)
            break
        default:
            if result != nil {
            result!(FlutterMethodNotImplemented)
            }
            break
        }
    }
}
