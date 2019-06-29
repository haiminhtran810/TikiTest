package com.hai.demo.ui

import android.os.Bundle
import com.hai.demo.R
import com.hai.demo.base.BaseActivity
import com.hai.demo.ui.home.HomeFragment

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, HomeFragment.newInstance(), HomeFragment.TAG).commit()
        }
    }
}
