package cz.koubicl.notino.presentation.viewmodel

import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.koin.test.KoinTest
import org.mockito.Mockito

open class BaseTest : KoinTest {

    @Before
    open fun setUp() {
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setMainThreadSchedulerHandler { Schedulers.trampoline() }
    }

    fun once() = Mockito.times(1)!!
}