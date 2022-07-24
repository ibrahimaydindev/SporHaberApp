package com.ibrahim.news_app.ui.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.ibrahim.news_app.R
import com.ibrahim.news_app.databinding.FragmentArticleBinding
import com.ibrahim.news_app.ui.NewsActivity
import com.ibrahim.news_app.ui.NewsViewModel

class ArticleFragment : Fragment(R.layout.fragment_article) {

    private lateinit var articleFragmentBinding: FragmentArticleBinding
    lateinit var viewModel: NewsViewModel
    val args: ArticleFragmentArgs by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentArticleBinding.bind(view)
        articleFragmentBinding = binding
        viewModel = (activity as NewsActivity).viewModel

        val article = args.article
        binding.webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url)

        }


    }
}