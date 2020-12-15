package com.muhammaduzaer.recyclerviewprojectthree.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.muhammaduzaer.recyclerviewprojectthree.R
import com.muhammaduzaer.recyclerviewprojectthree.models.BlogPost
import kotlinx.android.synthetic.main.blog_list_item.view.*

class BlogAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<BlogPost> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BlogViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.blog_list_item, parent, false))

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is BlogViewHolder -> {holder.bind(items.get(position))}
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(blogList: List<BlogPost>) {
        items = blogList
    }

    class BlogViewHolder constructor(
        itemView: View) : RecyclerView.ViewHolder(itemView) {
            val blogImage = itemView.imageViewBlogPost
            val blogTitle = itemView.textViewBlogPostTitle
            val blogAuther = itemView.textViewBlogPostAuther

        fun bind(blogPost: BlogPost) {
            blogTitle.setText(blogPost.title)
            blogAuther.setText(blogPost.username)

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(blogPost.image)
                .into(blogImage)
        }

        }

}