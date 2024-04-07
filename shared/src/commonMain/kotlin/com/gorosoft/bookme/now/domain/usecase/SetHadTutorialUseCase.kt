package com.gorosoft.bookme.now.domain.usecase

import com.gorosoft.bookme.now.managers.KMMUserDefaults

class SetHadTutorialUseCase(private val defaults: KMMUserDefaults) {

    fun execute() {
        defaults.wasTutorial = true
    }
}