package com.example.cleanarchitecturemvvm.di.artist

import com.example.cleanarchitecturemvvm.domain.usecase.GetArtistsUseCase
import com.example.cleanarchitecturemvvm.domain.usecase.UpdateArtistsUseCase
import com.example.cleanarchitecturemvvm.presentation.artist.ArtistViewModel
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideTvArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModel.ArtistViewModelFactory =
        ArtistViewModel.ArtistViewModelFactory(
            getArtistsUseCase,
            updateArtistsUseCase,
        )
}