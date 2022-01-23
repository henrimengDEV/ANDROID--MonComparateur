package com.example.my_first_app.element

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.my_first_app.R
import com.example.my_first_app.model.Product
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.product_details.*

class ProductDetailsFragment : Fragment() {

    private var product: Product? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.product_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.product = arguments?.get("product") as Product?

        val args = bundleOf("product" to this.product)
        val navHostFragment = childFragmentManager.findFragmentById(R.id.product_details_nav_host) as NavHostFragment
        val navController = navHostFragment.navController

        navController.setGraph(R.navigation.nav_details, args)
        view.findViewById<BottomNavigationView>(R.id.product_details_bottom_nav).setupWithNavController(navController)
    }
}