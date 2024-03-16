package com.gorosoft.bookme.now.managers

private const val IS_LOGGINED = "application.id.isLoggined"
private const val WAS_TUTORIAL = "application.id.wasTutorial"

class KMMUserDefaults(
    private val context: KMMContext,
) {
    var isLoggined: Boolean
        get() = context.getBool(IS_LOGGINED, false)
        set(value) = context.putBool(IS_LOGGINED, value)

    var wasTutorial: Boolean
        get() = context.getBool(WAS_TUTORIAL, false)
        set(value) = context.putBool(WAS_TUTORIAL, value)
}