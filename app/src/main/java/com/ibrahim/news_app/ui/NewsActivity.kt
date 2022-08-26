package com.ibrahim.news_app.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.core.content.pm.ShortcutManagerCompat
import androidx.core.graphics.drawable.IconCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.ibrahim.news_app.R
import kotlinx.android.synthetic.main.activity_news.*
import com.ibrahim.news_app.databinding.ActivityNewsBinding
import com.ibrahim.news_app.db.ArticleDatabase
import com.ibrahim.news_app.repository.NewsRepository


class NewsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsBinding
    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)
        binding.bottomNavigationView.setupWithNavController(newNavHostFragment.findNavController())

        val shortcut = ShortcutInfoCompat.Builder(this, "news1")
            .setShortLabel("İnternetten Haberlere Bak")
            .setIcon(IconCompat.createWithResource(this, R.drawable.ic_search))
            .setIntent(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.haberler.com/"))
            )
            .build()
        ShortcutManagerCompat.pushDynamicShortcut(this, shortcut)
    }

}