#import "FlutterToastMessagePlugin.h"
#if __has_include(<flutter_toast_message/flutter_toast_message-Swift.h>)
#import <flutter_toast_message/flutter_toast_message-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "flutter_toast_message-Swift.h"
#endif

@implementation FlutterToastMessagePlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftFlutterToastMessagePlugin registerWithRegistrar:registrar];
}
@end
