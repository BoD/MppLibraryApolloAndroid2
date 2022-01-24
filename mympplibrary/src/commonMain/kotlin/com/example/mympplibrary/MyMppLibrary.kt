@file:OptIn(ApolloExperimental::class)

package com.example.mympplibrary

import com.apollographql.apollo.api.ApolloExperimental
import com.example.utils.LaunchListQuery
import com.example.utils.Platform
import kotlinx.coroutines.flow.single

class MyMppLibrary {
    fun printPlatform() {
        println("MyMppLibrary on ${Platform().platform}")
    }

    suspend fun executeSampleQuery(): List<LaunchListQuery.Launch?> {
        return getApolloClient()
            .query(LaunchListQuery())
            .execute()
            .single()
            .data!!
            .launches
            .launches
    }
}
