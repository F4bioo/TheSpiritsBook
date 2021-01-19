package fbo.costa.thespiritsbook.ui

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fbo.costa.thespiritsbook.data.model.QueAns
import fbo.costa.thespiritsbook.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListViewModel
@ViewModelInject
constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    private val _queAnsListEvent = MutableLiveData<ArrayList<QueAns>>()
    val queAnsListEvent: LiveData<ArrayList<QueAns>>
        get() = _queAnsListEvent

    fun queAnsListCoroutine() = viewModelScope.launch {
        try {
            val queAnsList = withContext(Dispatchers.IO) {
                mainRepository.queAnsList()
            }
            _queAnsListEvent.postValue(queAnsList)

        } catch (e: Exception) {
            Log.v("ListViewModel", "Exception: ${e.message}")
        }
    }
}
