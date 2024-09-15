package com.gorosoft.bookme.now.android.ui.utils

import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gorosoft.bookme.now.android.ui.theme.AppTheme

@Composable
fun Loader(modifier: Modifier = Modifier) {
    CircularProgressIndicator(
        modifier = modifier
            .size(46.dp),
        color = AppTheme.colors.mainColors.primary500,
    )
}
