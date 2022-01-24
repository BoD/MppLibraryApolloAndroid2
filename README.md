# Kotlin Multiplatform Library With Apollo Android 2 Sample

This is a minimalist sample of a Kotlin Multiplatform Library using [Apollo Android 2](https://www.apollographql.com/docs/kotlin/v2).

It contains 2 modules:

- `utils`
  - Defines a `Platform` class with `expect`/`actual` for iOS and Android
  - Contains GraphQL schema (for https://apollo-fullstack-tutorial.herokuapp.com/) + one operation
- `mympplibrary`
  - Defines a `MyMppLibrary` class, with one function using `Platform` and one function making a GraphQL 
  call using the generated code from `utils`

To use:
- `./gradlew assemble`
- Have an XCode project
- Drag and drop `mympplibrary/build/fat-framework/debug/MyMppLibrary.framework` from the Finder to the XCode project
  in the `Frameworks` folder of your project in the left pane
- In the `yourproject.xcodeproj` of your app, in `Frameworks, Libraries and Embedded Content`, for 
  `MyMppLibrary.framework`, choose `Embed without Signing`

Here's an example of a minimalist Swift app using the library:

```swift
// MySuperAppApp.swift

import SwiftUI

import MyMppLibrary

@main
struct MySuperAppApp: App {
    init() {
        useMyMppLibrary()
    }
    
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}

func useMyMppLibrary()  {
    setbuf(__stdoutp, nil)
    
    let library = MyMppLibrary()
    library.printPlatform()
    library.executeSampleQuery { result, _ in
        print(result)
    }
}
```

To make things easier, an XCode project is available in the `XCode` folder.
