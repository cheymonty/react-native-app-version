
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNAppVersionSpec.h"

@interface AppVersion : NSObject <NativeAppVersionSpec>
#else
#import <React/RCTBridgeModule.h>

@interface AppVersion : NSObject <RCTBridgeModule>
#endif

@end
