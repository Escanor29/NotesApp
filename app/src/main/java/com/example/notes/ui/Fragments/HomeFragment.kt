package com.example.notes.ui.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.notes.R
import com.example.notes.ViewModel.NotesViewModel
import com.example.notes.databinding.FragmentHomeBinding
import com.example.notes.ui.Adapter.NotesAdapter

class HomeFragment : Fragment() {

    //Change ActionBar title in fragment class
    override fun onStart() {
        super.onStart()
        (activity as AppCompatActivity).supportActionBar?.title = ""
    }

    lateinit var binding: FragmentHomeBinding
    val viewmodel : NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)

        val staggeredGridLayoutManager =
            StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)

        binding.rcvNotes.layoutManager = staggeredGridLayoutManager

        viewmodel.getNotes().observe(viewLifecycleOwner,{   notesList ->
            binding.rcvNotes.adapter = NotesAdapter(requireContext(),notesList)
        })

        binding.btnAddNotes.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_createNotesFragment)
        }

        return binding.root
    }


}