package com.gorosoft.bookme.now.android.ui.onboarding

import androidx.lifecycle.ViewModel
import com.gorosoft.bookme.now.domain.usecase.SetHadTutorialUseCase

class TutorialCarouselViewModel(
    private val setHadTutorialUseCase: SetHadTutorialUseCase,
) : ViewModel() {

    fun setHadTutorial() {
        setHadTutorialUseCase.execute()
    }
}
