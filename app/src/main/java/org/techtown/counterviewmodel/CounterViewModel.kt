package org.techtown.counterviewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

// ViewModel이라는게 이름에 들어가야함 뷰와 모델의 관리여서
// ViewModel 자료형이 되어야함 - 어떻게 동작하고 어떤 메소드 그리고 속성이 있는지 정의
//
class CounterViewModel : ViewModel() {
    private val _repository: CounterRepository = CounterRepository()

    // _를 앞에 붙이면 클래스외부에서는 접근이 불가능하게 됨!
    private val _count = mutableStateOf(_repository.getCounter().count) // remember 없이도 가능하네

    // count는 밖에서도 접근이 가능해야함! - 이때는 불변인 상태로! immutable state
    // 외부에서 값 변경은 안됨! 하지만 state에 따라서는 유동적이다!
    val count: MutableState<Int> = _count

    fun increment() {
        _repository.incrementCounter()
        _count.value = _repository.getCounter().count
    }
    fun decrement() {
        _repository.decrementCounter()
        _count.value = _repository.getCounter().count
    }
}