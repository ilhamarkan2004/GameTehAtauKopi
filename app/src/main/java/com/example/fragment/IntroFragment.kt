package com.example.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.fragment.databinding.FragmentIntroBinding


class IntroFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Menambah judul dibar atas
        (activity as AppCompatActivity).supportActionBar?.title = "Game Teh Atau Kopi"
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_intro, container, false)

        val binding : FragmentIntroBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_intro,container,false)
        binding.startButton.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_introFragment_to_quizFragment)
            )


        // Menambahkan overflow menu
        setHasOptionsMenu(true)
        return binding.root


    }

    // Lanjutan untuk menambahkan overflow menu (Halaman about)
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu,menu)
    }

    // Lanjutan untuk menambahkan overflow menu (Halaman about)
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        // Kode program di sekolah koding tp eror
//        return NavigationUI.onNavDestinationSelected(item!!,view!!.findNavController())
//                || super.onOptionsItemSelected(item)

        return item?.let {
            view?.findNavController()?.let { navController ->
                NavigationUI.onNavDestinationSelected(it, navController)
            }
        } ?: super.onOptionsItemSelected(item)


    }

}