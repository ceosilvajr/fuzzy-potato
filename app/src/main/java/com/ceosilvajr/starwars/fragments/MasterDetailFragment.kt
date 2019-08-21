package com.ceosilvajr.starwars.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ceosilvajr.starwars.R

/**
 * @author ceosilvajr@gmail.com
 */
class MasterDetailFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_master_detail, container, false)
    }

}
