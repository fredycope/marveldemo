package com.example.marveldemo

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.marveldemo.domain.usecase.GetMarvelIdUseCase
import com.example.marveldemo.ui.detailfragment.DetailFragment
import com.example.marveldemo.ui.detailfragment.DetailViewModel
import com.example.marveldemo.ui.listfragment.ListViewModel
import com.example.marveldemo.utils.Constants
import com.example.marveldemo.utils.Constants.API_KEY
import com.example.marveldemo.utils.Constants.HASH
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.util.FragmentTestUtil
import javax.inject.Inject

@ExperimentalCoroutinesApi
@Config(application = HiltTestApplication::class, sdk = [30])
@RunWith(RobolectricTestRunner::class)
@HiltAndroidTest
class DescriptionUnitTest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    lateinit var viewModel: DetailViewModel

    @Inject
    lateinit var getMarvelIdUseCase: GetMarvelIdUseCase

    @Before
    fun setUp(){
        hiltRule.inject()
    }


    @Test
    fun getMarvelIdUseCase(){
        testCoroutineRule.runBlockingTest {
            viewModel = DetailViewModel(getMarvelIdUseCase)
            viewModel.onCreate(1234,API_KEY, HASH)
            assertNotNull(viewModel.marvelId)
            assertEquals(false,viewModel.marvelId.hasObservers())
        }
    }

}