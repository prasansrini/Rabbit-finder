package com.rabbitclient.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rabbitclient.data.RabbitApi
import com.sample.backend.model.Rabbit
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "MainViewModel"

@HiltViewModel
class MainViewModel @Inject constructor(
	private val api: RabbitApi
) : ViewModel() {
	private val _state = mutableStateOf(RabbitState())
	val state: State<RabbitState> = _state

	init {
		getRandomRabbit()
	}

	fun getRandomRabbit() {
		viewModelScope.launch {
			try {
				_state.value = state.value.copy(isLoading = true)
				_state.value = state.value.copy(
					rabbit = api.getRandomRabbit(),
					isLoading = false
				)
			} catch (e: Exception) {
				Log.e(
					TAG,
					"getRandomRabbit: ",
					e
				)

				_state.value = state.value.copy(isLoading = false)
			}
		}
	}

	data class RabbitState(
		val rabbit: Rabbit? = null,
		val isLoading: Boolean = false
	)
}