package com.gorosoft.bookme.now.managers

private const val IS_LOGGED_IN = "application.id.isLoggined"
private const val WAS_TUTORIAL = "application.id.wasTutorial"

class KMMUserDefaults(
    private val context: KMMContext,
) {
    var isLoggedIn: Boolean
        get() = context.getBool(IS_LOGGED_IN, false)
        set(value) = context.putBool(IS_LOGGED_IN, value)

    var wasTutorial: Boolean
        get() = context.getBool(WAS_TUTORIAL, false)
        set(value) = context.putBool(WAS_TUTORIAL, value)
}