package com.tes.eat.anywhere.roommanager.ui.people

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tes.eat.anywhere.roommanager.R
import com.tes.eat.anywhere.roommanager.data.model.people.People
import com.tes.eat.anywhere.roommanager.data.model.people.PeopleItem
import com.tes.eat.anywhere.roommanager.databinding.ItemPersonBinding

class PeopleAdapter(
    private val persons: People,
    val clickListner: (PeopleItem) -> Unit

) : RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>() {

    class PeopleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //private val binding = ItemPersonBinding.bind(itemView)
        private val binding = ItemPersonBinding.bind(itemView)

        val rootItem=binding.cItemView
        fun setupUI(fact: PeopleItem) {
            //binding.tvPersonFact.text = fact?.get(position)?.firstNameModel
            binding.tvName.text = "${fact?.firstNameModel} ${fact.lastNameModel}"
            binding.tvJob.text = "${fact?.jobtitleModel}"

            Glide.with(itemView.context)
                .load(fact.avatarModel)
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.ivUserImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleAdapter.PeopleViewHolder {
        return PeopleAdapter.PeopleViewHolder(
            //LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false)
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_person, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PeopleAdapter.PeopleViewHolder, position: Int) {
        holder.setupUI(persons[position])
        holder.rootItem.setOnClickListener {
            clickListner.invoke(persons[position])
        }
    }

    override fun getItemCount() = persons.size
}