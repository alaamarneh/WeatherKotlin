package com.ala.weather_kotlin.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ala.weather_kotlin.utils.runOnMain
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.internal.operators.single.SingleDoOnSuccess

open class BaseViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    val isLoading = MutableLiveData<Boolean>()

    protected fun addDisposable(disposable: Disposable) = compositeDisposable.add(disposable)

    private fun dispose() = compositeDisposable.dispose()

    override fun onCleared() {
        dispose()
        super.onCleared()
    }

    protected fun <T> Single<T>.subscribeWithLoading(onSuccess: (T) -> Unit, onError: (throwable:Throwable) -> Unit = { throw  it}) : Disposable {
        return runOnMain()
            .doOnSubscribe { isLoading.value = true }
            .doOnSuccess { onSuccess(it) }
            .doOnError{ onError(it) }
            .doFinally{ isLoading.value = false}
            .subscribe()
    }




}