package com.example.notes.ui.Fragments

import android.os.Bundle
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.notes.Entity.Notes
import com.example.notes.ViewModel.NotesViewModel
import com.example.notes.databinding.FragmentCreateNotesBinding
import java.lang.String.format
import java.util.*


class CreateNotesFragment : Fragment() {

    //Change ActionBar title in fragment class
    override fun onStart() {
        super.onStart()
        (activity as AppCompatActivity).supportActionBar?.title = ""
    }


    lateinit var binding : FragmentCreateNotesBinding
    val viewmodel : NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment

        binding = FragmentCreateNotesBinding.inflate(layoutInflater,container,false)

        binding.btnEditSaveNotes.setOnClickListener {
            createNotes(it)
        }

        return binding.root
    }

    private fun createNotes(it: View?) {

        val title = binding.editTitle.text.toString()
        val subtitle = binding.editSubtitle.text.toString()
        val notes = binding.editNotes.text.toString()

        val d = Date()
        val notesDate: CharSequence = DateFormat.format("MMMM d, yyyy ", d.time)

        val data = Notes(
            null,
            title =  title,
            subtitle = subtitle,
            notes = notes,
            date = notesDate as String
        )
        viewmodel.addNotes(data)

        Toast.makeText(requireContext(),"Notes Created ",Toast.LENGTH_SHORT).show()
    }

}