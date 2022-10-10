package com.tes.eat.anywhere.roommanager.ui.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.tes.eat.anywhere.roommanager.model.data.news.News
import com.tes.eat.anywhere.roommanager.databinding.FragmentNewsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : Fragment() {

    lateinit var binding: FragmentNewsBinding

    private val viewModel by activityViewModels<NewsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNewsBinding.inflate(inflater)

        // observe the changes in viewmodel liveData
        viewModel.news.observe(viewLifecycleOwner) {
            setupUI(it)
        }
        viewModel.getNews()
        return binding.root
    }

    private fun setupUI(newsList: News) {
        binding.newsList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = NewsAdapter(
                newsList
            )
        }
    }
}