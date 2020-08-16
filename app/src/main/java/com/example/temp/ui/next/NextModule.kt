package com.example.temp.ui.next

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.temp.di.ByFactory
import com.example.temp.di.ViewModelKey
import com.example.temp.di.get
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class NextModule {

    @Binds
    @IntoMap
    @ViewModelKey(NextViewModel::class)
    abstract fun bindsNextViewModel(viewModel: NextViewModel): ViewModel


    @Module
    companion object {

        @JvmStatic
        @Provides
        @ByFactory
        fun providesNextViewModel(
            fragment: NextFragment,
            viewModelFactory: ViewModelProvider.Factory
        ): NextViewModel = viewModelFactory.get(fragment)
    }
}
