package com.example.my_first_app.element

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.my_first_app.R
import com.example.my_first_app.data.InMemoryProducts
import android.content.Intent
import android.net.Uri
import com.example.my_first_app.MainActivity
import com.google.zxing.integration.android.IntentIntegrator


class ProductsListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.product_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.product_recycler).apply {
            adapter = ProductRecyclerAdapter(InMemoryProducts.findAll().values.toList())
            layoutManager = LinearLayoutManager(activity)
        }

        view.findViewById<Button>(R.id.products_start_scan).setOnClickListener {
            // TODO Lancer l'Intent (étape 1)
            val intent = Intent("com.google.zxing.client.android.SCAN")
            intent.putExtra(
                "SCAN_FORMATS",
                "EAN_13"
            )
            startActivity(intent)


        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == 100 && data != null) {
            // TODO A compléter
            data.getStringExtra("")
        }

    }

}