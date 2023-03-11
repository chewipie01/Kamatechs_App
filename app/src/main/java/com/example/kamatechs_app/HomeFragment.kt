package com.example.kamatechs_app

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.kamatechs_app.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (activity as AppCompatActivity).supportActionBar?.title = "HOME"

        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater, R.layout.fragment_home, container, false
        )
        binding.btnStorage.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_homeFragment_to_storageActivity)
        }
        binding.btnWeather.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_homeFragment_to_weatherActivity)
        }

        setHasOptionsMenu(true)

        binding.bottomNavigation.setSelectedItemId(R.id.homeFragment)
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.aboutFragment-> {
                    replaceFragment(AboutFragment())
                    true
                }
                R.id.homeFragment -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.FAQFragment -> {
                    replaceFragment(FAQFragment())
                    true
                }
                else -> false
            }
        }

        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    private  fun replaceFragment(fragment: Fragment){
        val fragmentManager = childFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.homelayout,fragment)
        fragmentTransaction.addToBackStack(null).commit()
    }
}