package com.ceosilvajr.starwars.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ceosilvajr.starwars.R
import com.ceosilvajr.starwars.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * @author ceosilvajr@gmail.com
 */
class HomeFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_view.setOnClickListener {
            navController.navigate(R.id.action_homeFragment_to_masterDetailFragment)
        }
    }
}
