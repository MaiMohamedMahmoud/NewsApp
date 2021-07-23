package com.codinginflow.mvvmnewsapp.feature.breakingnews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codinginflow.mvvmnewsapp.databinding.FragmentBreakingNewsItemBinding
import com.codinginflow.mvvmnewsapp.domain.model.Article

class BreakingNewsAdapter :
    ListAdapter<Article, BreakingNewsAdapter.BreakingNewsViewHolder>(DiffCallback()) {

    class BreakingNewsViewHolder(private val bind: FragmentBreakingNewsItemBinding) :
        RecyclerView.ViewHolder(bind.root) {

        fun bindView(article: Article) {
            bind.newsArticleObj = article
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


    class DiffCallback : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(
            oldItem: Article,
            newItem: Article
        ): Boolean {
            return oldItem.thumbnailUrl == newItem.thumbnailUrl
        }

        override fun areContentsTheSame(
            oldItem: Article,
            newItem: Article
        ): Boolean {
            return oldItem == newItem
        }


    }
}