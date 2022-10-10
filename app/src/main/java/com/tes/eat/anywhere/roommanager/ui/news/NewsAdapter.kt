package com.tes.eat.anywhere.roommanager.ui.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tes.eat.anywhere.roommanager.R
import com.tes.eat.anywhere.roommanager.model.data.news.Article
import com.tes.eat.anywhere.roommanager.model.data.news.News
import com.tes.eat.anywhere.roommanager.databinding.ItemNewsBinding


class NewsAdapter(
    private val news: News
): RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {


    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemNewsBinding.bind(itemView)

        fun setupUI(arcticle: Article) {
            binding.article.text = "Title : ${arcticle.titleModel}. \n" +

                    "Source:${arcticle.sourceModel.nameModel}"

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewsAdapter.NewsViewHolder {
        return NewsAdapter.NewsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_news, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NewsAdapter.NewsViewHolder, position: Int) {
        holder.setupUI(news.articlesModel[position])
    }

    override fun getItemCount()=news.articlesModel.size

}