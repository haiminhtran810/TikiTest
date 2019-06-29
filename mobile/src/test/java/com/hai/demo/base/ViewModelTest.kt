package com.hai.demo.base

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Ignore
import org.junit.Rule
@Ignore
open class ViewModelTest : BaseUnitTest() {
    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()
}