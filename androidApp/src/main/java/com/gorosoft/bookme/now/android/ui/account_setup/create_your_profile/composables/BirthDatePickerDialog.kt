package com.gorosoft.bookme.now.android.ui.account_setup.create_your_profile.composables

import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.gorosoft.bookme.now.android.R
import com.gorosoft.bookme.now.android.ui.theme.AppTheme
import com.gorosoft.bookme.now.android.ui.utils.CancelButton
import com.gorosoft.bookme.now.android.ui.utils.DateUtils
import com.gorosoft.bookme.now.android.ui.utils.PrimaryButton
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BirthDatePickerDialog(
    onBirthDateSelected: (selectedDate: LocalDate) -> Unit = {},
    hideDialog: () -> Unit = {},
) {
    val pickerState = rememberDatePickerState()
    DatePickerDialog(
        colors = DatePickerDefaults.colors(
            containerColor = AppTheme.colors.backgroundThemed.backgroundMain,
        ),
        onDismissRequest = hideDialog,
        confirmButton = {
            PrimaryButton(
                text = stringResource(R.string.ok),
                onClick = {
                    onBirthDateSelected.invoke(
                        DateUtils.convertMillisToLocalDate(pickerState.selectedDateMillis)
                    )
                },
            )
        },
        dismissButton = { CancelButton(onClick = hideDialog) }
    ) {
        DatePicker(
            state = pickerState,
            showModeToggle = true,
            colors = DatePickerDefaults.colors(
                titleContentColor = AppTheme.colors.grayscale.gs900,
                headlineContentColor = AppTheme.colors.grayscale.gs900,
                navigationContentColor = AppTheme.colors.grayscale.gs900,
                dayContentColor = AppTheme.colors.grayscale.gs900,
                subheadContentColor = AppTheme.colors.grayscale.gs900,
                dividerColor = AppTheme.colors.grayscale.gs900,
                currentYearContentColor = AppTheme.colors.grayscale.gs900,
                selectedDayContentColor = Color.White,
                selectedDayContainerColor = AppTheme.colors.mainColors.primary500,
                todayContentColor = AppTheme.colors.grayscale.gs900,
                todayDateBorderColor = Color.Transparent,
                containerColor = AppTheme.colors.backgroundThemed.backgroundMain,
                weekdayContentColor = AppTheme.colors.grayscale.gs900,
                yearContentColor = AppTheme.colors.grayscale.gs900,
                selectedYearContentColor = AppTheme.colors.grayscale.gs900,
                selectedYearContainerColor = AppTheme.colors.mainColors.primary500,
            ),
        )
    }
}

@Preview
@Composable
private fun BirthDatePickerDialogPreview() {
    AppTheme {
        BirthDatePickerDialog()
    }
}
