package com.corox.coroxrtv.ui

import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.corox.coroxrtv.navigation.AppScreens
import com.corox.coroxrtv.util.UtilDataStorage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class MainViewModel @Inject constructor(private val utilDataStorage: UtilDataStorage) :
    ViewModel() {

    private val _firstTimeApp = MutableLiveData<Boolean>();
    val firstTimeApp: LiveData<Boolean> = _firstTimeApp;

    private val _isLoading = MutableLiveData<Boolean>();
    val isLoading: LiveData<Boolean> = _isLoading;

    private val _versionAppVerify = MutableLiveData<Int>();
    val versionAppVerify: LiveData<Int> = _versionAppVerify;


    fun setFirstTimeFalse() {
        _isLoading.value = true;
        viewModelScope.launch {
            utilDataStorage.saveBooleanPreference("FIRST_VIEW", true)
            _firstTimeApp.value = true;
        }

        _isLoading.value = false;
    }


    fun getFirstTime() {
        viewModelScope.launch {
            _firstTimeApp.value = utilDataStorage.getBooleanPrefence("FIRST_VIEW").first()
        }
    }

    fun showLoading() {
        _isLoading.value = true;
    }

    fun removeLoading() {
        _isLoading.value = false;
    }

    fun getVErsionAppControl() {
        viewModelScope.launch {
            delay(5000)
            _versionAppVerify.value = 0
        }
    }
}