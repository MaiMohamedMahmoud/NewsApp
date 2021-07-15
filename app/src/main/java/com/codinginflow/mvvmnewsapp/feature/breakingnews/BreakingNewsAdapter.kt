package com.codinginflow.mvvmnewsapp.feature.breakingnews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codinginflow.mvvmnewsapp.data.network.NewsArticleDto
import com.codinginflow.mvvmnewsapp.databinding.FragmentBreakingNewsItemBinding

class BreakingNewsAdapter :
    ListAdapter<NewsArticleDto, BreakingNewsAdapter.BreakingNewsViewHolder>(DiffCallback()) {

    class BreakingNewsViewHolder(private val bind: FragmentBreakingNewsItemBinding) :
        RecyclerView.ViewHolder(bind.root) {

        fun bindView(newsArticleDto: NewsArticleDto) {
            bind.newsArticleObj = newsArticleDto
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreakingNewsViewHolder {
        val binding =
            FragmentBreakingNewsItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return BreakingNewsViewHolder(binding)

    }

    override fun onBindViewHolder(holder: BreakingNewsViewHolder, position: Int) {

        holder.bindView(getItem(position))
    }


    class DiffCallback : DiffUtil.ItemCallback<NewsArticleDto>() {
        override fun areItemsTheSame(oldItem: NewsArticleDto, newItem: NewsArticleDto): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: NewsArticleDto, newItem: NewsArticleDto): Boolean {
            return oldItem == newItem
        }


    }
}