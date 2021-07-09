package cz.koubicl.notino.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Rule

open class ViewModelTest : BaseTest() {

    @get:Rule
    val rule = InstantTaskExecutorRule()
}