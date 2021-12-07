package com.example.marveldemo.ui.detailfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.marveldemo.R
import com.example.marveldemo.databinding.FragmentDetailBinding
import com.example.marveldemo.utils.Constants.API_KEY
import com.example.marveldemo.utils.Constants.HASH
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    lateinit var binding: FragmentDetailBinding
    val viewModel: DetailViewModel by viewModels()
    var obj: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            obj = it.get("obj").toString().toInt()
            viewModel.onCreate(obj, API_KEY, HASH)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail, container, false)
         binding.viewModel = viewModel
         return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.marvelId.observe(viewLifecycleOwner, Observer {
            if(it.data.results.first().images.isNullOrEmpty()){
                Glide.with(binding.ivImg).load(it.data.results.first().thumbnail.path.plus(".${it.data.results.first().thumbnail.extension}")).into(binding.ivImg)
            }else{
                Glide.with(binding.ivImg).load(it.data.results.first().images.first().path.plus(".${it.data.results.first().images.first().extension}")).into(binding.ivImg)
            }

            binding.tvId.text = "Id: ${it.data.results.first().id}"
            binding.tvTitle.text = "Titulo:\n${it.data.results.first().title}"
            binding.tvOverview.text = "Descripción:\n${if(it.data.results.first().description.isNullOrEmpty()) "No disponible" else it.data.results.first().description }"
            binding.tvTxt.text= "Url: ${it.data.results.first().resourceURI}"

        })
    }
}