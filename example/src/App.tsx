import * as React from 'react';

import { StyleSheet, View, Text } from 'react-native';
import { getAppVersion, getBuildNumber } from 'react-native-app-version';

export default function App() {
  const [appVersion, setAppVersion] = React.useState<string | undefined>();
  const [buildNumber, setBuildNumber] = React.useState<string | undefined>();

  React.useEffect(() => {
    getAppVersion().then(setAppVersion);
    getBuildNumber().then(setBuildNumber);
  }, []);

  return (
    <View style={styles.container}>
      <Text>App Version: {appVersion}</Text>
      <Text>Build Number: {buildNumber}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
});
