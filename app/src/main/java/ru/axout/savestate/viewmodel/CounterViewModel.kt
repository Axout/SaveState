package ru.axout.savestate.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.axout.savestate.parcelable.CounterState
import timber.log.Timber

class CounterViewModel: ViewModel() {

    private val mutableState = MutableLiveData(CounterState(count = 0))

    val state: LiveData<CounterState>
        get() = mutableState

    init {
        Timber.d("CounterViewModel init ${hashCode()}")
    }

    fun incrementCount() {
        mutableState.value = CounterState(mutableState.value!!.count + 1)
    }

    fun decrementCount() {
        mutableState.value = CounterState(mutableState.value!!.count - 1)
    }

    override fun onCleared() {
        super.onCleared()
        Timber.d("CounterViewModel onCleared ${hashCode()}")
    }
}