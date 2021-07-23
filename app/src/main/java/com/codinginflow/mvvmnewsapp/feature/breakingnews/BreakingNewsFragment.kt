package com.codinginflow.mvvmnewsapp.feature.breakingnews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.codinginflow.mvvmnewsapp.R
import com.codinginflow.mvvmnewsapp.databinding.FragmentBreakingNewsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class BreakingNewsFragment : Fragment(R.layout.fragment_breaking_news) {
    private lateinit var binding: FragmentBreakingNewsBinding
    private lateinit var breakingNewsAdapter: BreakingNewsAdapter
    private val breakingNewsViewModel: BreakingNewsViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBreakingNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecycleView()
        setObservables()
    }

    private fun setObservables() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            breakingNewsViewModel.breakingNewsFlow.collect { articles ->
                breakingNewsAdapter.submitList(articles)
            }
        }
    }

    private fun setRecycleView() {
        breakingNewsAdapter = BreakingNewsAdapter()
        val manager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.layoutManager = manager
        binding.recyclerView.adapter = breakingNewsAdapter
    }
}