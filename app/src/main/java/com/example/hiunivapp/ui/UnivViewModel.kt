package com.example.hiunivapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiunivapp.network.Univ
import com.example.hiunivapp.network.UnivApi
import kotlinx.coroutines.launch
import java.lang.Exception

enum class UnivApiStatus { LOADING, ERROR, DONE }

class UnivViewModel : ViewModel() {

    private var _status = MutableLiveData<UnivApiStatus>()
    val status = _status
    private var _univList = MutableLiveData<List<Univ>>()
    val univList = _univList
    private var _selectedUniv = MutableLiveData<Univ>()
    val selectedUniv = _selectedUniv

    init {
        getUnivList()
    }
    private fun getUnivList(){
        viewModelScope.launch {
            _status.value = UnivApiStatus.LOADING
            try {
                _univList.value = UnivApi.retrofitService.getUniv()
                _status.value = UnivApiStatus.DONE
            }
            catch (e : Exception) {
                _status.value = UnivApiStatus.ERROR
                _univList.value = listOf()
            }
        }
    }

    fun onUnivClicked(univ: Univ){
        _selectedUniv.value = univ
    }
}