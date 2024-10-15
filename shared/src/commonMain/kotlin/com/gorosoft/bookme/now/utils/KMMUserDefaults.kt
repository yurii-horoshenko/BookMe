package com.gorosoft.bookme.now.utils

private const val WAS_TUTORIAL = "application.id.wasTutorial"

class KMMUserDefaults(
    private val context: KMMContext,
) {

    var wasTutorial: Boolean
        get() = context.getBool(WAS_TUTORIAL, false)
        set(value) = context.putBool(WAS_TUTORIAL, value)
}
