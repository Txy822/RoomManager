package com.tes.eat.anywhere.roommanager.ui.people

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tes.eat.anywhere.roommanager.R
import com.tes.eat.anywhere.roommanager.data.model.people.People
import com.tes.eat.anywhere.roommanager.databinding.FragmentPeopleBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint  // make sure it is also set in Activity
class PeopleFragment : Fragment(R.layout.fragment_people) {

    lateinit var binding: FragmentPeopleBinding

    //view model for current fragment
    // val viewModel by viewModels<PeopleViewmodel>()
    //activity view model
    val viewModel by activityViewModels<PeopleViewmodel>()

//    @Inject  // make sure the AndroidEntryPoint is set
//    lateinit var api: EmployeeApi

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPeopleBinding.inflate(inflater)

        // observe the changes in viewmodel liveData
        viewModel.people.observe(viewLifecycleOwner) {

            setupUI(it)
        }
        //setupUI(it)
        // call the API for result
        viewModel.getPeople()

        return binding.root
    }

    private fun setupUI(peopleList: People) {
        binding.peopleList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = PeopleAdapter(
                peopleList
            ) {item->


                viewModel.currentData=item
                //if the second parameter it mpve ot the function
//                findNavController().navigate(R.id.action_peopleFragment_to_detailFragment, bundleOf(Pair("FName", item.f)))
                findNavController().navigate(R.id.action_peopleFragment_to_detailFragment)
            }

        }


    }
}