# react-native-alert
React Native Alert module which matchs pilipa UI style in native code
The api is same as React Native offical Alert API.

**Change made to iOS version:**

by default, all buttons text color is `#EF0C35`.

To made a cancel button:

```javascript
Alert.alert('标题', '确定退出\n退出后将重新登录', [
    {
        text: "取消",
        onPress: ()=>{
            console.log('you clicked cancel');
        },
        style: 'cancel'
    }
    ]);
```

To override default color, just specify your own color:

```javascript
Alert.alert('标题', '确定退出\n退出后将重新登录', [
    {
        text: "取消",
        onPress: ()=>{
            console.log('you clicked cancel');
        },
        color: "#009696",
        style: 'cancel'
    }]);
```

**Android**

The first button is always cancel and second one always means ok, so far the button color can't be changed.

By default the alert can't be cancel, means can't press empty area to dismiss the alert dialog.

```javascript
Alert.alert('', '',[ ... ], {cancelable: true});
```

**TODO**

Android support override default button color.