//
//  ZTAlertView.m
//  ZTAlertView
//
//  Created by jinglan1212@icloud.com on 2017/7/31.
//  Copyright © 2017年 jinglan1212@icloud.com. All rights reserved.
//

#import "ZTAlertView.h"
#import "UIColor+Tool.h"
@implementation ZTAlertView
@synthesize bridge = _bridge;
RCT_EXPORT_MODULE();

RCT_EXPORT_METHOD(showAlert:(NSDictionary *)params resolve:(RCTPromiseResolveBlock)resolve reject:(RCTPromiseRejectBlock)reject)
{

  NSString * title = params[@"title"] ? params[@"title"]: @"title";
  NSString * message = params[@"message"] ? params[@"message"] : @"message";

  UIAlertControllerStyle style = UIAlertControllerStyleAlert;
  if ([params[@"style"] isEqualToString:@"sheet"]) {
    style = UIAlertControllerStyleActionSheet;
  }

  UIAlertController *alert = [UIAlertController alertControllerWithTitle:title message:message preferredStyle:style];
  //修改title
  if (params[@"titleColor"]) {
    NSMutableAttributedString *alertControllerStr = [[NSMutableAttributedString alloc] initWithString:title];

    [alertControllerStr addAttribute:NSForegroundColorAttributeName value:[UIColor colorWithHexString:params[@"titleColor"]] range:NSMakeRange(0, [title length])];
    [alert setValue:alertControllerStr forKey:@"attributedTitle"];

  }
  //修改message
  if (params[@"messageColor"]) {
    NSMutableAttributedString *alertControllerMessageStr = [[NSMutableAttributedString alloc] initWithString:message];

    [alertControllerMessageStr addAttribute:NSForegroundColorAttributeName value:[UIColor colorWithHexString:params[@"messageColor"]] range:NSMakeRange(0, [message length])];
    [alert setValue:alertControllerMessageStr forKey:@"attributedMessage"];

  }
  //修改背景颜色和圆角
  //修改按钮
  for (NSDictionary * dic in params[@"btnArr"]) {

    NSString * btnName = dic[@"name"] ? dic[@"name"] : @"按钮";

    UIAlertAction *action = [UIAlertAction actionWithTitle:btnName style:UIAlertActionStyleDefault handler:^(UIAlertAction *action) {
        resolve(btnName);
    }];
    if (dic[@"color"]) {
      [action setValue:[UIColor colorWithHexString:dic[@"color"]] forKey:@"titleTextColor"];
    }
    [alert addAction:action];
  }

  [[UIApplication sharedApplication].keyWindow.rootViewController presentViewController:alert animated:YES completion:nil];
}
@end
