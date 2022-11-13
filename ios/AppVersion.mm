#import "AppVersion.h"

@implementation AppVersion
RCT_EXPORT_MODULE()

RCT_REMAP_METHOD(getAppVersion,
                 appVersionResolver:(RCTPromiseResolveBlock)resolve
                 appVersionRejecter:(RCTPromiseRejectBlock)reject)
{
    NSString *version = [[NSBundle mainBundle] objectForInfoDictionaryKey: @"CFBundleShortVersionString"];
    resolve(version);
}

RCT_REMAP_METHOD(getBuildNumber,
                 buildNumberResolver:(RCTPromiseResolveBlock)resolve
                 buildNumberRejecter:(RCTPromiseRejectBlock)reject)
{
    NSString *buildNumber = [[NSBundle mainBundle] objectForInfoDictionaryKey: @"CFBundleVersion"];
    resolve(buildNumber);
}

// Don't compile this code when we build for the old architecture.
#ifdef RCT_NEW_ARCH_ENABLED
- (std::shared_ptr<facebook::react::TurboModule>)getTurboModule:
    (const facebook::react::ObjCTurboModule::InitParams &)params
{
    return std::make_shared<facebook::react::NativeAppVersionSpecJSI>(params);
}
#endif

@end
