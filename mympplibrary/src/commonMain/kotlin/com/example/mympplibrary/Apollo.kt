@file:OptIn(ApolloExperimental::class, ExperimentalCoroutinesApi::class)

package com.example.mympplibrary

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.ApolloExperimental
import com.apollographql.apollo.network.http.ApolloHttpNetworkTransport
import kotlinx.coroutines.ExperimentalCoroutinesApi

private var instance: ApolloClient? = null

fun getApolloClient(): ApolloClient {
    if (instance != null) {
        return instance!!
    }

    instance = ApolloClient(
        networkTransport = ApolloHttpNetworkTransport(
            serverUrl = "https://apollo-fullstack-tutorial.herokuapp.com/graphql",
            headers = emptyMap()
        )
    )

    return instance!!
}
