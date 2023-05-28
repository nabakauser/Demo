package com.example.demo

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class EmergencyViewModel: ViewModel() {}
//    private val totalTime: Long = 10L * 1000L
//    private val initialValue: Float = 1f
//
//    private val _currentTime = remember{ MutableState<Long>(totalTime)}
//    val currentTime: MutableState<Long> = _currentTime
//
//    private val _initialValue = mutableStateOf(initialValue)
//    val value: MutableState<Float> = _initialValue
//
//        private var job: Job? = null
//
//
//
//    fun startTimer() {
//        job = viewModelScope.launch {
//            _currentTime.value = totalTime
//            while (_currentTime.value > 0) {
//                delay(100L)
//                _currentTime.value -= 100L
//                _initialValue.value = _currentTime.value / totalTime.toFloat()
//
//            }
//        }
//    }
//}

