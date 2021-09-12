package cz.koubicl.example.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cz.koubicl.example.presentation.extensions.map
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

abstract class BaseViewModel : ViewModel() {

    val state: MutableLiveData<out ViewModelState> = MutableLiveData<ViewModelState>().apply { value = ViewModelState.Initial }
    val isLoading = state.map { it == ViewModelState.Loading }

    protected val compositeDisposable = CompositeDisposable()

    protected fun <T> Single<T>.onSuccess(onSuccess: (T) -> Unit) =
        RxSingleObserveBuilder(this, onSuccess, {})

    protected fun <T> Single<T>.onError(onError: (Throwable) -> Unit) =
        RxSingleObserveBuilder(this, {}, onError)

    protected fun <T> RxSingleObserveBuilder<T>.onSuccess(onSuccess: (T) -> Unit) =
        RxSingleObserveBuilder(this.single, onSuccess, this.onError)

    protected fun <T> RxSingleObserveBuilder<T>.onError(onError: (Throwable) -> Unit) =
        RxSingleObserveBuilder(this.single, this.onSuccess, onError)

    protected class RxSingleObserveBuilder<T>(
        val single: Single<T>,
        val onSuccess: ((T) -> Unit),
        val onError: ((t: Throwable) -> Unit)
    )

    protected fun <T> RxSingleObserveBuilder<T>.observe(): Disposable =
        single.observeInternal(onSuccess = onSuccess, onError = onError).addTo(compositeDisposable)

    private fun <T> Single<T>.observeInternal(
        onError: ((t: Throwable) -> Unit) = {},
        onSuccess: ((t: T) -> Unit) = {},
    ): Disposable {

        val observable = subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

        return observable
            .doOnError{
                state.value = ViewModelState.Ready
            }
            .doOnSubscribe {
                state.value = ViewModelState.Loading
            }
            .doOnSuccess {
                state.value = ViewModelState.Ready
            }
            .subscribe(onSuccess, onError)
    }
}