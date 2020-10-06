package com.example.temp.data

import com.example.temp.data.api.NetworkModule
import dagger.Module

@Module(
    includes = [
        NetworkModule::class
    ]
)
class DataModule {}