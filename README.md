# react-native-app-version

Get app version and build number of your React Native app

## Installation

```sh
npm install react-native-app-version
```

Run `pod install` in the iOS directory

```sh
cd ios && pod install
```

## Usage

```ts
import { getAppVersion, getBuildNumber } from 'react-native-app-version';

// ...

const appVersion: string = await getAppVersion(); // 1.0
const buildNumber: string = await getBuildNumber(); // 1
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
