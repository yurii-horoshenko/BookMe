package com.gorosoft.bookme.now.android.ui.utils

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gorosoft.bookme.now.android.R
import com.gorosoft.bookme.now.android.ui.theme.AppTheme

@Composable
fun BackButtonToolbar(
    modifier: Modifier = Modifier,
    @StringRes title: Int,
    navigateBack: () -> Unit = {},
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 48.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.debounceClick { navigateBack.invoke() },
            painter = painterResource(R.drawable.ic_arrow_back),
            contentDescription = "back arrow",
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = stringResource(title),
            style = AppTheme.typography.heading.h4,
            color = AppTheme.colors.grayscale.gs900,
        )
    }
}

@Preview(showSystemUi = false, showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun BackButtonToolbarPreview() {
    AppTheme {
        BackButtonToolbar(title = R.string.login_button_text)
    }
}
