package com.muhammaduzaer.recyclerviewprojectthree

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.muhammaduzaer.recyclerviewprojectthree.adapter.BlogAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var blogAdapter: BlogAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        addDataSet()
    }

    private fun addDataSet() {
        val data = DataSource.createDataSet()
        blogAdapter.submitList(data)

    }

    private fun initRecyclerView() {
        recyclerViewBlogPosts.apply{
            layoutManager = LinearLayoutManager(this@MainActivity)
            val topSpacingDecoration = TopSpacingDecoration(30)
            addItemDecoration(topSpacingDecoration)
            blogAdapter = BlogAdapter()
            adapter = blogAdapter
        }
    }
}