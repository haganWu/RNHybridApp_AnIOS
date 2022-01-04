//
//  DataToJSPresenter.m
//  ios
//
//  Created by 吴海恒 on 2022/1/4.
//

#import "DataToJSPresenter.h"

@implementation DataToJSPresenter

RCT_EXPORT_MODULE();

- (NSArray<NSString *> *)supportedEvents
{
    return @[@"testData"];
}
- (instancetype)init {
    if (self = [super init]) {//在module初始化的时候注册fireData广播
        [[NSNotificationCenter defaultCenter] addObserver:self selector:@selector(fireData:) name:@"fireData" object:nil];
    }
    return self;
}
- (void)fireData:(NSNotification *)notification{//发送数据给RN
    NSString *eventName = notification.object[@"name"];
    NSDictionary *params = notification.object[@"params"];
    [self sendEventWithName:eventName body:params];
}

@end
