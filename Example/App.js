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
        Alert.alert('', '确定退出', [
            {
                text: "取消",
                onPress: ()=>{}
            }
            ,
            {
                text: "确定",
                onPress: ()=>{}
            }
        ]);
    }

  render() {
    return (
      <View style={styles.container}>
        <TouchableOpacity onPress={this.showAlert.bind(this)}>
          <View style={[styles.avatar, styles.avatarContainer]}>
            <Text>显示提示框</Text>
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
