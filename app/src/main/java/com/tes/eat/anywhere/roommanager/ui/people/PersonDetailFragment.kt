package com.tes.eat.anywhere.roommanager.ui.people

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.tes.eat.anywhere.roommanager.R
import com.tes.eat.anywhere.roommanager.databinding.FragmentPersonDetailBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PersonDetailFragment : Fragment(R.layout.fragment_person_detail) {

    lateinit var binding: FragmentPersonDetailBinding
    val viewModel by activityViewModels<PeopleViewmodel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentPersonDetailBinding.inflate(inflater)
        // Inflate the layout for this fragment

        viewModel.currentData.let {
            binding.tvUserName.text="Full Name: ${it.firstNameModel}  ${it.lastNameModel}"
            binding.tvJobTitle.text="Job Title: ${it.jobtitleModel}"
            binding.tvEmail.text="Email: ${it.emailModel}"
            binding.tvFavoriteColor.text="Favorite Color: ${it.favouriteColorModel}"


            Glide.with(requireContext())
                .load(it.avatarModel)
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.tvProfilePicture)
        }
        return binding.root
    }


}