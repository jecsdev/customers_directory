package com.jcampusano.customersdirectory.ui.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import com.jcampusano.customersdirectory.R
import com.jcampusano.customersdirectory.databinding.FragmentCreateBusinessBinding


class CreateBusinessFragment : Fragment() {

   private lateinit var binding: FragmentCreateBusinessBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCreateBusinessBinding.inflate(layoutInflater)
        val view = binding.root

        val fab = binding.saveBusinessFab


        fab.setOnClickListener{
            parentFragmentManager.commit {
                setCustomAnimations(
                    androidx.appcompat.R.anim.abc_popup_enter,
                    com.google.android.material.R.anim.abc_popup_exit,
                )
                remove(this@CreateBusinessFragment)
                addToBackStack(null)
            }
        }
        return view
    }


}