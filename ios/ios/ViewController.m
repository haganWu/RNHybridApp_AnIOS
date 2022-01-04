//
//  ViewController.m
//  ios
//
//  Created by 吴海恒 on 2021/12/31.
//

#import "ViewController.h"
#import "RNPageController.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
}
- (IBAction)jump:(id)sender {
    NSString *inputString=[self.FComponentName text];
    NSString *inputParams=[self.FInitParams text];
    
    RNPageController *next = [[self storyboard] instantiateViewControllerWithIdentifier:@"RNPage"];
    next.moduleName=inputString;
    next.paramsInit=inputParams;
    [self presentViewController:next animated:true completion:nil];
}


@end
