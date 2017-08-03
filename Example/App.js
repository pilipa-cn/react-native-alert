import React from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
  PixelRatio,
  TouchableOpacity,
  Image,
} from 'react-native';

import Alert from "react-native-alert";

export default class App extends React.Component {

    showAlert() {
        Alert.alert('标题', '确定退出\n退出后将重新登录', [
            {
                text: "取消",
                onPress: ()=>{
                    console.log('you clicked cancel');
                },
                // color: "#969696", // 可选, 可以不设置
                style: 'cancel'
            }
            ,
            {
                text: "确定",
                onPress: ()=>{
                    console.log('you clicked ok');
                },
                // color: "#EF0C35"
            }
        ]);
    }

    showSingleAlert() {
        Alert.alert('标题', '确定退出\n退出后将重新登录', [
            {
                text: "确定",
                onPress: ()=>{
                    console.log('you clicked ok');
                }
            }
        ]);
    }

    showMsgAlert() {
        Alert.alert('标题', '确定退出\n退出后将重新登录');
    }

  render() {
    return (
      <View style={styles.container}>
        <TouchableOpacity onPress={this.showAlert.bind(this)}>
          <View style={[styles.avatar, styles.avatarContainer]}>
              <Text>显示双按钮提示框</Text>
          </View>
        </TouchableOpacity>

          <TouchableOpacity onPress={this.showSingleAlert.bind(this)}>
              <View style={[styles.avatar, styles.avatarContainer]}>
                  <Text>显示单按钮提示框</Text>
              </View>
          </TouchableOpacity>

          <TouchableOpacity onPress={this.showMsgAlert.bind(this)}>
              <View style={[styles.avatar, styles.avatarContainer]}>
                  <Text>显示文本无按钮定义提示框</Text>
              </View>
          </TouchableOpacity>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF'
  },
  avatarContainer: {
    borderColor: '#9B9B9B',
    borderWidth: 1 / PixelRatio.get(),
    justifyContent: 'center',
    alignItems: 'center'
  },
  avatar: {
    borderRadius: 75,
    width: 150,
    height: 150
  }
});
