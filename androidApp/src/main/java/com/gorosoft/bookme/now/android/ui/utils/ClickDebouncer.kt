package com.gorosoft.bookme.now.android.ui.utils

import androidx.compose.foundation.Indication
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.semantics.Role

const val DEFAULT_THRESHOLD: Long = 350

internal class ClickDebouncer(
    private val thresholdDuration: Long = DEFAULT_THRESHOLD
) {
    private var lastClickTime: Long = 0

    fun processClick(click: () -> Unit) {
        if (System.currentTimeMillis() - lastClickTime >= thresholdDuration) {
            click.invoke()
        }
        lastClickTime = System.currentTimeMillis()
    }
}

fun Modifier.debounceClick(
    enabled: Boolean = true,
    onClickLabel: String? = null,
    role: Role? = null,
    thresholdDuration: Long = DEFAULT_THRESHOLD,
    hasRipple: Boolean = true,
    customRippleColor: Indication? = null,
    onClick: () -> Unit
) = this.composed(
    inspectorInfo = debugInspectorInfo {
        name = "clickable"
        properties["enabled"] = enabled
        properties["onClickLabel"] = onClickLabel
        properties["role"] = role
        properties["onClick"] = onClick
    }
) {
    val debouncer = remember { ClickDebouncer(thresholdDuration) }
    val indication = if (hasRipple) {
        customRippleColor ?: LocalIndication.current
    } else {
        null
    }
    Modifier.clickable(
        enabled = enabled,
        onClickLabel = onClickLabel,
        onClick = { debouncer.processClick(onClick) },
        role = role,
        indication = indication,
        interactionSource = remember { MutableInteractionSource() },
    )
}