
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNBuildVersionSpec.h"

@interface BuildVersion : NSObject <NativeBuildVersionSpec>
#else
#import <React/RCTBridgeModule.h>

@interface BuildVersion : NSObject <RCTBridgeModule>
#endif

@end
