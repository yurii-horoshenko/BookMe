package com.gorosoft.bookme.now.android.ui.account_setup.create_your_profile.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gorosoft.bookme.now.android.ui.theme.AppTheme
import com.gorosoft.bookme.now.android.ui.utils.CancelButton
import com.gorosoft.bookme.now.android.ui.utils.SecondaryButton
import com.gorosoft.bookme.now.android.ui_models.title
import com.gorosoft.bookme.now.domain.models.UserGender

@Composable
fun GenderBottomSheetContent(
    onCancelGenderSelection: () -> Unit = {},
    onGenderSelected: (UserGender) -> Unit = {},
) {
    Column(
        modifier = Modifier
            .padding(vertical = 24.dp, horizontal = 24.dp)
            .navigationBarsPadding()
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        UserGender.entries.forEach {
            SecondaryButton(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .fillMaxWidth(),
                text = it.title(),
                onClick = { onGenderSelected.invoke(it) }
            )
        }
        Spacer(modifier = Modifier.padding(top = 8.dp))
        CancelButton(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .fillMaxWidth(),
            onClick = { onCancelGenderSelection.invoke() }
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun GenderBottomSheetContentPreview() {
    AppTheme {
        GenderBottomSheetContent()
    }
}
