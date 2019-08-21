package com.ceosilvajr.starwars.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ceosilvajr.starwars.R
import com.ceosilvajr.starwars.base.BaseFragment

/**
 * @author ceosilvajr@gmail.com
 */
class MasterDetailFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_master_detail, container, false)
    }

}
