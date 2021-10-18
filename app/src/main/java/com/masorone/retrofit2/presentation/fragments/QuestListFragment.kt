package com.masorone.retrofit2.presentation.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.masorone.retrofit2.QuestApp
import com.masorone.retrofit2.R


class QuestListFragment : Fragment(R.layout.fragment_quest_list) {

    private lateinit var textL: TextView
    private lateinit var vm: QuestListViewModel

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textL = view.findViewById(R.id.list) as TextView
        vm = ViewModelProvider(this)[QuestListViewModel::class.java]

        vm.fetchQuestList((activity?.application as QuestApp).questApi)

        vm.list.observe(viewLifecycleOwner, {
            textL.text =
                "${it.first().domain} \n${it.first().create_date} \n${it.first().update_date}"
        })
    }
}