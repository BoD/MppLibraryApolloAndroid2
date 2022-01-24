//
//  MySuperAppApp.swift
//  MySuperApp
//
//  Created by BoD on 09/11/2021.
//

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
