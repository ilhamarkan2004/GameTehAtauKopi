package com.example.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.fragment.databinding.FragmentFinishBinding


class FinishFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.title = "Finish"
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_finish, container, false)
        val binding : FragmentFinishBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_finish,container,false)


       //Dari sumber tp eror
//        var args =  FinishFragmentArgs.fromBundle(arguments)
//        binding.explainText.text = args.result

        val args = arguments?.let { FinishFragmentArgs.fromBundle(it) }
        binding.explainText.text = args?.result

        return binding.root
    }
}