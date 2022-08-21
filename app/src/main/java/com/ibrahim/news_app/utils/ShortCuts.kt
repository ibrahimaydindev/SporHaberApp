package com.ibrahim.news_app.utils

import android.content.Context
import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon.createWithResource
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.ibrahim.news_app.R
import com.ibrahim.news_app.ui.NewsActivity
import com.ibrahim.news_app.ui.fragments.SearchNewsFragment

object ShortCuts {

    const val NewsId = "News"
    const val searchNewsId="SearchNews"

    @RequiresApi(Build.VERSION_CODES.N_MR1)
    fun setUp(context: Context) {
        val shortcutManager: ShortcutManager? =
            ContextCompat.getSystemService(
                context,
                ShortcutManager::class.java
            )
        val searchNews:ShortcutInfo = ShortcutInfo.Builder(context, searchNewsId)
            .setShortLabel("Haber Ara")
            .setIcon(createWithResource(context,R.drawable.ic_search))
            .setIntent(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.haberler.com")))
            .build()

        val intents = arrayOf(
            Intent(Intent.ACTION_VIEW, null, context, NewsActivity::class.java),
            Intent(Intent.ACTION_VIEW, null, context, SearchNewsFragment::class.java)
        )
        val shortcutNews = ShortcutInfo.Builder(context, NewsId)
            .setShortLabel("Haberleri Görüntüle")
            .setIcon(createWithResource(context,R.mipmap.commentator))
            .setIntents(intents)
            .build()

        shortcutManager!!.dynamicShortcuts = listOf(shortcutNews, searchNews)
    }
}
