package com.example.notes.ui.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.notes.R
import com.example.notes.databinding.FragmentCreateNotesBinding


class CreateNotesFragment : Fragment() {

    //Change ActionBar title in fragment class
    override fun onStart() {
        super.onStart()
        (activity as AppCompatActivity).supportActionBar?.title = ""
    }


    lateinit var binding : FragmentCreateNotesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment

        binding = FragmentCreateNotesBinding.inflate(layoutInflater,container,false)

        return binding.root
    }

}