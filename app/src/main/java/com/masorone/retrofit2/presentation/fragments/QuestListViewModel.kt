package com.masorone.retrofit2.presentation.fragments

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.masorone.retrofit2.data.remote.quest.QuestApi
import com.masorone.retrofit2.data.remote.quest.QuestListItem
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class QuestListViewModel(application: Application) : AndroidViewModel(application) {

    private val compositeDisposable = CompositeDisposable()

    private val listMutable = MutableLiveData<List<QuestListItem>>()
    val list: LiveData<List<QuestListItem>> = listMutable

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun fetchQuestList(questApi: QuestApi) {
        questApi.let {
            compositeDisposable.add(
                questApi.getQuestList()
                    .subscribeOn(Schedulers.io())
                    .subscribeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        listMutable.postValue(it.domains)
                    }, {
                        Log.d("TAG", "QuestListViewModel ${it.message.toString()}")
                    })
            )
        }
    }
}