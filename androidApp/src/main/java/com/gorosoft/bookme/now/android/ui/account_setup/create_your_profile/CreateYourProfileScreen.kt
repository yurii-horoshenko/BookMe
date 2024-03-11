package com.gorosoft.bookme.now.android.ui.account_setup.create_your_profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.gorosoft.bookme.now.android.R
import com.gorosoft.bookme.now.android.ui.theme.AppTheme
import com.gorosoft.bookme.now.android.ui.utils.BackButtonToolbar
import com.gorosoft.bookme.now.android.ui.utils.CancelButton
import com.gorosoft.bookme.now.android.ui.utils.DateUtils
import com.gorosoft.bookme.now.android.ui.utils.PrimaryButton
import com.gorosoft.bookme.now.android.ui.utils.SecondaryButton
import com.gorosoft.bookme.now.android.ui.utils.debounceClick
import com.gorosoft.bookme.now.android.ui_models.CreateProfileUiModel
import com.gorosoft.bookme.now.android.ui_models.UserGender
import com.ramcosta.composedestinations.annotation.Destination
import kotlinx.coroutines.launch
import java.time.LocalDate

@Destination
@Composable
fun CreateYourProfileScreen(
    viewModel: CreateYourProfileViewModel = hiltViewModel(),
) {
    val profileState by viewModel.profileState.collectAsStateWithLifecycle()
    CreateYourProfileContent(
        profileState = profileState,
        onNewNameInputted = viewModel::updateName,
        onGenderSelected = viewModel::updateGender,
        onBirthDateSelected = viewModel::updateDateOfBirth,
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun CreateYourProfileContent(
    profileState: CreateProfileUiModel,
    onNewNameInputted: (String) -> Unit = {},
    onGenderSelected: (UserGender) -> Unit = {},
    onBirthDateSelected: (selectedDate: LocalDate) -> Unit = {},
) {
    val coroutineScope = rememberCoroutineScope()
    val genderBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true,
    )
    var showDateDialog by remember { mutableStateOf(false) }
    ModalBottomSheetLayout(
        sheetContentColor = AppTheme.colors.backgroundThemed.backgroundMain,
        sheetShape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
        sheetState = genderBottomSheetState,
        sheetContent = {
            GenderBottomSheetContent(
                onCancelGenderSelection = {
                    coroutineScope.launch { genderBottomSheetState.hide() }
                },
                onGenderSelected = {
                    onGenderSelected.invoke(it)
                    coroutineScope.launch { genderBottomSheetState.hide() }
                },
            )
        },
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(AppTheme.colors.backgroundThemed.backgroundMain)
                    .systemBarsPadding()
            ) {
                Column(
                    modifier = Modifier.padding(vertical = 24.dp, horizontal = 24.dp),
                    verticalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    BackButtonToolbar(title = R.string.create_your_profile)
                    NameInput(
                        text = profileState.fullName,
                        onNewNameInputted = onNewNameInputted,
                    )
                    DateOfBirthInput(
                        dateOfBirth = profileState.dateOfBirthText,
                        onDateClick = { showDateDialog = true }
                    )
                    GenderInput(
                        gender = profileState.gender,
                        onGenderFieldClick = {
                            coroutineScope.launch { genderBottomSheetState.show() }
                        }
                    )
                }
            }
            if (showDateDialog) {
                BirthDatePickerDialog(
                    onBirthDateSelected = {
                        onBirthDateSelected.invoke(it)
                        showDateDialog = false
                    },
                    hideDialog = { showDateDialog = false }
                )
            }
        },
    )
}

@Composable
private fun GenderBottomSheetContent(
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
                text = stringResource(it.titleRes),
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun BirthDatePickerDialog(
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

@Composable
private fun GenderInput(
    modifier: Modifier = Modifier,
    gender: UserGender? = null,
    onGenderFieldClick: () -> Unit = {},
) {
    val genderText = gender?.titleRes?.let { stringResource(it) } ?: ""
    TextField(
        enabled = false,
        singleLine = true,
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .debounceClick { onGenderFieldClick.invoke() },
        value = genderText,
        onValueChange = {},
        placeholder = {
            Text(
                text = stringResource(R.string.choose_gender),
                style = AppTheme.typography.bodyMedium.regular,
                color = AppTheme.colors.grayscale.gs500,
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = AppTheme.colors.grayscale.gs900,
            backgroundColor = AppTheme.colors.grayscale.gs50,
            cursorColor = AppTheme.colors.mainColors.primary500,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            disabledTextColor = AppTheme.colors.grayscale.gs900,
        ),
        textStyle = AppTheme.typography.bodyMedium.semibold,
        trailingIcon = {
            Image(
                painter = painterResource(R.drawable.ic_arrow_selector),
                contentDescription = "selector arrow",
            )
        }
    )
}

@Composable
private fun DateOfBirthInput(
    modifier: Modifier = Modifier,
    dateOfBirth: String,
    onDateClick: () -> Unit = {},
) {
    TextField(
        enabled = false,
        singleLine = true,
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .debounceClick { onDateClick.invoke() },
        value = dateOfBirth,
        onValueChange = {},
        placeholder = {
            Text(
                text = stringResource(R.string.date_of_birth),
                style = AppTheme.typography.bodyMedium.regular,
                color = AppTheme.colors.grayscale.gs500,
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = AppTheme.colors.grayscale.gs900,
            backgroundColor = AppTheme.colors.grayscale.gs50,
            cursorColor = AppTheme.colors.mainColors.primary500,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            disabledTextColor = AppTheme.colors.grayscale.gs900,
        ),
        textStyle = AppTheme.typography.bodyMedium.semibold,
        trailingIcon = {
            Image(
                painter = painterResource(R.drawable.ic_calendar),
                contentDescription = "selector arrow",
            )
        }
    )
}

@Composable
private fun NameInput(
    modifier: Modifier = Modifier,
    text: String = "",
    onNewNameInputted: (String) -> Unit = {},
) {
    TextField(
        singleLine = true,
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp)),
        value = text,
        onValueChange = onNewNameInputted,
        placeholder = {
            Text(
                text = stringResource(R.string.full_name),
                style = AppTheme.typography.bodyMedium.regular,
                color = AppTheme.colors.grayscale.gs500,
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = AppTheme.colors.grayscale.gs900,
            backgroundColor = AppTheme.colors.grayscale.gs50,
            cursorColor = AppTheme.colors.mainColors.primary500,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        textStyle = AppTheme.typography.bodyMedium.semibold,
    )
}

@Preview
@Composable
private fun BirthDatePickerDialogPreview() {
    AppTheme {
        BirthDatePickerDialog()
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun GenderBottomSheetContentPreview() {
    AppTheme {
        GenderBottomSheetContent()
    }
}

@Preview
@Composable
private fun CreateYourProfileScreenPreview() {
    AppTheme {
        CreateYourProfileContent(
            profileState = CreateProfileUiModel(
                fullName = "Joseph Gordon Levit",
            )
        )
    }
}
