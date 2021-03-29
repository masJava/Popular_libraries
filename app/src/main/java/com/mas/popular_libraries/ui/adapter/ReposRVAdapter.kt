package com.mas.popular_libraries.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mas.popular_libraries.databinding.ItemRepoBinding
import com.mas.popular_libraries.mvp.presenter.list.IRepoListPresenter
import com.mas.popular_libraries.mvp.view.list.IRepoItemView

class ReposRVAdapter(val presenter: IRepoListPresenter) :
    RecyclerView.Adapter<ReposRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemRepoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ).apply {
            itemView.setOnClickListener { presenter.itemClickListener?.invoke(this) }
        }

    override fun getItemCount() = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        presenter.bindView(holder.apply { pos = position })

    inner class ViewHolder(val vb: ItemRepoBinding) : RecyclerView.ViewHolder(vb.root),
        IRepoItemView {
        override var pos = -1

        override fun setName(text: String) {
            vb.tvName.text = text
        }
    }


}