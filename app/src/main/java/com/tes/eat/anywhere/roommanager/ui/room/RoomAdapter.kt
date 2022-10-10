package com.tes.eat.anywhere.roommanager.ui.room

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tes.eat.anywhere.roommanager.R
import com.tes.eat.anywhere.roommanager.data.model.room.Room
import com.tes.eat.anywhere.roommanager.data.model.room.RoomItem
import com.tes.eat.anywhere.roommanager.databinding.ItemRoomBinding

class RoomAdapter(
    private val rooms: Room
): RecyclerView.Adapter<RoomAdapter.RoomViewHolder>() {


    class RoomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemRoomBinding.bind(itemView)

        fun setupUI(room: RoomItem) {
            //binding.tvPersonFact.text = fact?.get(position)?.firstNameModel

            binding.tvID.text = "Room: ${room.idModel} Can Occupy  ${room.maxOccupancyModel}"

            if(room.isOccupiedModel){
                Glide.with(itemView.context)
                    .load(R.drawable.occupied)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(binding.isOccupied)
            }
            else {
                Glide.with(itemView.context)
                    .load(R.drawable.free)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(binding.isOccupied)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RoomAdapter.RoomViewHolder {
        return RoomAdapter.RoomViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_room, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        holder.setupUI(rooms[position])
    }

    override fun getItemCount()=rooms.size
}