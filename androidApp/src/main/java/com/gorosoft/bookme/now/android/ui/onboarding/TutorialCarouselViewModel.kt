package com.gorosoft.bookme.now.android.ui.onboarding

import androidx.lifecycle.ViewModel
import com.gorosoft.bookme.now.domain.usecase.SetHadTutorialUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TutorialCarouselViewModel @Inject constructor(
    private val setHadTutorialUseCase: SetHadTutorialUseCase,
) : ViewModel() {

    fun setHadTutorial() {
        setHadTutorialUseCase.execute()
    }
}
