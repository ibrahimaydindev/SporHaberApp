package com.ibrahim.news_app.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ibrahim.news_app.models.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun upsert(article: Article): Long

    @Query("SELECT * FROM articles")
    fun getAllArticles(): LiveData<List<Article>>

    @Delete
     fun deleteArticle(article: Article)
}