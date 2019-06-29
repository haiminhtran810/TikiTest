package com.hai.demo.ui.home

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.hai.demo.R
import com.hai.demo.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.viewmodel.ext.android.viewModel


class HomeFragment : BaseFragment() {

    private val viewModel by viewModel<HomeViewModel>()
    private var homeAdapter: HomeAdapter? = null

    override val layoutId: Int
        get() = R.layout.fragment_home

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getKeyWord()
    }

    override fun handlerEvent() {
        super.handlerEvent()
        homeAdapter = HomeAdapter()
        rcl_keyword?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = homeAdapter
        }
    }

    override fun observable() {
        super.observable()
        viewModel.listKeyWord.observe(this@HomeFragment, Observer {
            homeAdapter?.apply {
                submitList(it)
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onActivityDestroyed()
    }

    companion object {
        const val TAG = "HomeFragment"
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}
