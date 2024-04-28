package com.gorosoft.bookme.now.android.ui.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gorosoft.bookme.now.android.R
import com.gorosoft.bookme.now.android.ui.theme.AppTheme

@Composable
fun SearchInput(
    modifier: Modifier = Modifier,
    searchText: String,
    onClick: () -> Unit = {},
    onValueChanged: (String) -> Unit = {},
) {
    TextField(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .debounceClick(onClick = onClick),
        value = searchText,
        onValueChange = onValueChanged,
        placeholder = {
            Text(
                text = stringResource(R.string.search),
                style = AppTheme.typography.bodyMedium.regular,
                color = AppTheme.colors.grayscale.gs400
            )
        },
        leadingIcon = {
            Image(
                painter = painterResource(R.drawable.ic_search),
                contentDescription = "Search image",
                colorFilter = ColorFilter.tint(AppTheme.colors.grayscale.gs400)
            )
        },
        trailingIcon = {
            Image(
                painter = painterResource(R.drawable.ic_filter),
                contentDescription = "Filter image",
                colorFilter = ColorFilter.tint(AppTheme.colors.mainColors.primary500),
            )
        },
        textStyle = AppTheme.typography.bodyMedium.semibold.copy(
            color = AppTheme.colors.grayscale.gs900
        ),
        colors = TextFieldDefaults.colors().copy(
            focusedContainerColor = AppTheme.colors.grayscale.gs100,
            unfocusedContainerColor = AppTheme.colors.grayscale.gs100,
            focusedTextColor = AppTheme.colors.grayscale.gs900,
            unfocusedTextColor = AppTheme.colors.grayscale.gs900,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
        )
    )
}

@Preview
@Composable
fun SearchInputPreview() {
    AppTheme {
        SearchInput(searchText = "")
    }
}
