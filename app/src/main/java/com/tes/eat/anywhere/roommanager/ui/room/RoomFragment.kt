package com.tes.eat.anywhere.roommanager.ui.room

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.tes.eat.anywhere.roommanager.R
import com.tes.eat.anywhere.roommanager.data.model.room.Room
import com.tes.eat.anywhere.roommanager.databinding.FragmentRoomBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RoomFragment : Fragment() {

    lateinit var binding: FragmentRoomBinding

    private val viewModel by activityViewModels<RoomViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRoomBinding.inflate(inflater)

        // observe the changes in viewmodel liveData
        viewModel.room.observe(viewLifecycleOwner) {
            setupUI(it)
        }
        viewModel.getRoom()

        return binding.root
    }

    private fun setupUI(roomList: Room) {
        binding.roomList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = RoomAdapter(
                roomList
            )
        }
    }
}