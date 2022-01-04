//
//  RNPageController.h
//  ios
//
//  Created by 吴海恒 on 2022/1/4.
//

#import <UIKit/UIKit.h>

NS_ASSUME_NONNULL_BEGIN

@interface RNPageController : UIViewController
@property(strong,nonatomic)NSString*moduleName;
@property(strong,nonatomic)NSString*paramsInit;

@property(nonatomic, strong) UILabel *titleLabel;
@property(nonatomic, strong) UILabel *showLabel;
@property(nonatomic, strong) UITextField *inputView;
@end

NS_ASSUME_NONNULL_END
