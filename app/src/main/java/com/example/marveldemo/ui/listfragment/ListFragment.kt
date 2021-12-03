package com.example.marveldemo.ui.listfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.marveldemo.R
import com.example.marveldemo.utils.Nav
import com.example.marveldemo.utils.OnClickList
import com.example.marveldemo.databinding.FragmentListBinding
import com.example.marveldemo.ui.placeholder.PlaceholderContent
import com.example.marveldemo.utils.Constants.API_KEY
import com.example.marveldemo.utils.Constants.HASH
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Exception
import java.math.BigInteger
import java.security.MessageDigest
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class ListFragment : Fragment(), OnClickList {
    lateinit var binding: FragmentListBinding
    private val viewModel: ListViewModel by viewModels()
    lateinit var adapter : MyItemRecyclerViewAdapter
    @Inject
    lateinit var navigation: Nav

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = MyItemRecyclerViewAdapter(this)
        viewModel.onCreate(API_KEY, HASH)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_list, container, false)
        binding.viewModel = viewModel
        binding.list.apply{
            binding.list.layoutManager = GridLayoutManager(requireContext(),2)
        }
        binding.list.adapter = adapter


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onResume() {
        super.onResume()
        viewModel.marvel.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            adapter.addData(it)
        })
    }
    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            ListFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }

    override fun goToFragement(result: Any, view: View) {
        val bundle = bundleOf("obj" to result.toString())
        navigation.goToFragment(view,R.id.action_itemFragment_to_detailFragment,bundle)
    }
}