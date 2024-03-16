package com.gorosoft.bookme.now.android.ui.account_setup.enter_otp

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import com.gorosoft.bookme.now.android.ui.theme.AppTheme

const val OtpLength = 4

@Composable
fun OtpInputField(
    modifier: Modifier = Modifier,
    text: String,
    onValueChanged: (String) -> Unit = {},
) {
    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current
    val shape = remember { RoundedCornerShape(12.dp) }
    val focusedBorderColor = AppTheme.colors.mainColors.primary500
    val unfocusedBorderColor = AppTheme.colors.grayscale.gs200
    val focusedBackground = AppTheme.colors.mainColors.primary500.copy(alpha = 0.2f)
    val unfocusedBackground = AppTheme.colors.grayscale.gs50

    LaunchedEffect(key1 = Unit) {
        focusRequester.requestFocus()
        keyboardController?.show()
    }

    BasicTextField(
        modifier = modifier.focusRequester(focusRequester),
        value = text,
        onValueChange = {
            if (it.isDigitsOnly()) {
                onValueChanged.invoke(it)
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.NumberPassword,
            autoCorrect = false,
        ),
        decorationBox = {
            Row(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                repeat(OtpLength) { index ->
                    val char = when {
                        index >= text.length -> ""
                        else -> text[index].toString()
                    }
                    val isFocused = text.length == index
                    Box(
                        modifier = Modifier
                            .height(height = 60.dp)
                            .weight(1f / OtpLength)
                            .background(
                                color = if (isFocused) focusedBackground else unfocusedBackground,
                                shape = shape,
                            )
                            .border(
                                width = 1.dp,
                                color = if (isFocused) focusedBorderColor else unfocusedBorderColor,
                                shape = shape
                            )
                    ) {
                        Text(
                            modifier = Modifier.align(Alignment.Center),
                            text = char,
                            style = AppTheme.typography.heading.h4,
                            color = AppTheme.colors.grayscale.gs900,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun OtpInputFieldPreview() {
    AppTheme {
        OtpInputField(text = "12")
    }
}
