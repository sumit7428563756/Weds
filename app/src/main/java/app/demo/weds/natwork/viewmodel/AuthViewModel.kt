package app.demo.weds.natwork.viewmodel

import Repository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.demo.weds.natwork.repository.SignUpRepository
import app.demo.weds.natwork.resource.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
//
//class AuthViewModel(
//    private val loginRepository: Repository,
//    private val signUpRepository: SignUpRepository
//) : ViewModel() {
//
//
//    private val _loginState = MutableStateFlow<Resource<Unit>>(Resource.Idle)
//    val loginState: StateFlow<Resource<Unit>> = _loginState.asStateFlow()
//
//    private val _signUpState = MutableStateFlow<Resource<Unit>>(Resource.Idle)
//    val signUpState: StateFlow<Resource<Unit>> = _signUpState.asStateFlow()
//
//
//
////    fun login(email: String, password: String) {
////        viewModelScope.launch {
////            _loginState.value = Resource.Loading
////            val result = loginRepository.loginUser(email, password)
////            _loginState.value = result.fold(
////                onSuccess = { Resource.Success(Unit) },
////                onFailure = { Resource.Error(it.message ?: "Login failed") }
////            )
////        }
////    }
//
//    fun login(email: String, password: String) {
//        viewModelScope.launch {
//            _loginState.value = Resource.Loading
//            val result = loginRepository.loginUser(email, password)
//            _loginState.value = result.fold(
//                onSuccess = { (userId, name) ->
//                    println("UserId: $userId, Name: $name")
//                    Resource.Success(userId to name)
//                },
//                onFailure = { Resource.Error(it.message ?: "Login failed") }
//            )
//        }
//    }
//
//
//    fun signUp(name: String, email: String, password: String) {
//        viewModelScope.launch {
//            _signUpState.value = Resource.Loading
//            val result = signUpRepository.signUp(email, password, name)
//            _signUpState.value = result.fold(
//                onSuccess = { Resource.Success(Unit) },
//                onFailure = { Resource.Error(it.message ?: "Signup failed") }
//            )
//        }
//    }
//
//
//    fun verifyEmail(email: String, otp: String) {
//        viewModelScope.launch {
//            _signUpState.value = Resource.Loading
//            val result = signUpRepository.verifyEmail(email, otp)
//            _signUpState.value = result.fold(
//                onSuccess = { Resource.Success(Unit) },
//                onFailure = { Resource.Error(it.message ?: "Email verification failed") }
//            )
//        }
//    }
//}


class AuthViewModel(
    private val loginRepository: Repository,
    private val signUpRepository: SignUpRepository
) : ViewModel() {

    // State should hold Pair<String, String?> instead of Unit
    private val _loginState = MutableStateFlow<Resource<Pair<String, String?>>>(Resource.Idle)
    val loginState: StateFlow<Resource<Pair<String, String?>>> = _loginState.asStateFlow()

    private val _signUpState = MutableStateFlow<Resource<Unit>>(Resource.Idle)
    val signUpState: StateFlow<Resource<Unit>> = _signUpState.asStateFlow()

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _loginState.value = Resource.Loading
            val result = loginRepository.loginUser(email, password)
            _loginState.value = result.fold(
                onSuccess = { (userId, name) ->
                    println("UserId: $userId, Name: $name")
                    Resource.Success(userId to name)
                },
                onFailure = { Resource.Error(it.message ?: "Login failed") }
            )
        }
    }

    fun signUp(name: String, email: String, password: String) {
        viewModelScope.launch {
            _signUpState.value = Resource.Loading
            val result = signUpRepository.signUp(email, password, name)
            _signUpState.value = result.fold(
                onSuccess = { Resource.Success(Unit) },
                onFailure = { Resource.Error(it.message ?: "Signup failed") }
            )
        }
    }

    fun verifyEmail(email: String, otp: String) {
        viewModelScope.launch {
            _signUpState.value = Resource.Loading
            val result = signUpRepository.verifyEmail(email, otp)
            _signUpState.value = result.fold(
                onSuccess = { Resource.Success(Unit) },
                onFailure = { Resource.Error(it.message ?: "Email verification failed") }
            )
        }
    }
}

