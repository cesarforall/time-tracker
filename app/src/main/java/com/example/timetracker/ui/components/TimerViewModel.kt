package com.example.timetracker.ui.components

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class TimerViewModel: ViewModel() {
    private val _timer: MutableStateFlow<Long> = MutableStateFlow(0)
    val timer = _timer.asStateFlow()
}