package cz.koubicl.notino.presentation.viewmodel

import io.reactivex.Scheduler
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.functions.Function
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.koin.test.KoinTest
import org.mockito.Mockito
import java.util.concurrent.Callable

open class BaseTest : KoinTest {

    @Before
    open fun setUp() {
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setMainThreadSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setInitIoSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setInitComputationSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setInitNewThreadSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setInitSingleSchedulerHandler { Schedulers.trampoline() }
    }

    fun once() = Mockito.times(1)!!
}