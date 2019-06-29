package com.hai.data.remote

import com.hai.data.base.BaseUnitTest
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before

open class TikiApiTest : BaseUnitTest() {
    protected lateinit var mockServer: MockWebServer

    @Before
    override fun setUp() {
        mockServer = MockWebServer()
    }

    @After
    override fun tearDown() {
        mockServer.shutdown()
    }
}