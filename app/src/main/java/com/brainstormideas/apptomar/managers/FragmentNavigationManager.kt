package com.brainstormideas.apptomar.managers

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.brainstormideas.apptomar.ui.screens.INPUT_DATA

class FragmentNavigationManager(
    container: Int,
    fragmentManager: FragmentManager,
) : Fragment() {

    private val container = container
    private val actualFragmentManager = fragmentManager
    private val bundle = Bundle()

    fun goToFragment(fragment: Fragment) {
        val transaction = actualFragmentManager.beginTransaction()
        transaction.replace(container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun goToFragmentWithData(fragment: Fragment, data: Any?) {
        bundle.putString(INPUT_DATA, data.toString())
        val transaction = actualFragmentManager.beginTransaction()
        fragment.arguments = bundle
        transaction.replace(container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}