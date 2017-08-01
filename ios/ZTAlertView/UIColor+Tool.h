//
//  UIColor+Tool.h
//  ZTAlertView
//
//  Created by zhuangzihao on 2017/7/31.
//  Copyright © 2017年 jinglan1212@icloud.com. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface UIColor (Tool)
// 透明度固定为1，以0x开头的十六进制转换成的颜色
+ (UIColor *)colorWithHex:(long)hexColor;
// 0x开头的十六进制转换成的颜色,透明度可调整
+ (UIColor *)colorWithHex:(long)hexColor alpha:(float)opacity;
// 颜色转换三：iOS中十六进制的颜色（以#开头）转换为UIColor
+ (UIColor *) colorWithHexString: (NSString *)color;
@end
