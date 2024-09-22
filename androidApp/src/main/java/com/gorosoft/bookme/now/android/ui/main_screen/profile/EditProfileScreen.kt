package com.gorosoft.bookme.now.android.ui.main_screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.DatePickerDialog
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gorosoft.bookme.now.android.R
import com.gorosoft.bookme.now.android.ui.account_setup.create_your_profile.composables.BirthDatePickerDialog
import com.gorosoft.bookme.now.android.ui.account_setup.create_your_profile.composables.GenderBottomSheetContent
import com.gorosoft.bookme.now.android.ui.theme.AppTheme
import com.gorosoft.bookme.now.android.ui.utils.BackButtonToolbar
import com.gorosoft.bookme.now.android.ui.utils.appThemeTextFieldColors
import com.gorosoft.bookme.now.android.ui.utils.debounceClick
import com.gorosoft.bookme.now.android.ui_models.title
import com.gorosoft.bookme.now.domain.models.UserGenderType
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun EditProfileScreen(
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit = { },
    onGenderSelected: (UserGenderType) -> Unit = {},
    onNewNameInputted: (String) -> Unit = {},
) {
    val coroutineScope = rememberCoroutineScope()
    val genderBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true,
    )
    val keyboardController = LocalSoftwareKeyboardController.current
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
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(AppTheme.colors.backgroundThemed.backgroundMain)
                    .statusBarsPadding()
                    .padding(vertical = 24.dp, horizontal = 24.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                BackButtonToolbar(
                    title = R.string.edit_profile,
                    navigateBack = onNavigateBack,
                )


                var text by remember { mutableStateOf("") }
                NameInput(
                    name = text,
                    onNewNameInputted = onNewNameInputted,
                )


                SecondNameInput(
                    secondName = text
                )

                var dateOfBirth by remember { mutableStateOf("") }
                var showDateDialog by remember { mutableStateOf(false) }
                DateOfBirthInput(
                    dateOfBirth = dateOfBirth,
                    onDateClick = { showDateDialog = true }
                )

                var email by remember { mutableStateOf("") }
                EmailInput(
                    email = email
                )

                CountryInput(
                    country = null,
                    onGenderFieldClick = {
                        keyboardController?.hide()
                        coroutineScope.launch { genderBottomSheetState.show() }
                    }
                )

                PhoneInput()

                GenderInput(
                    gender = null,
                    onGenderFieldClick = {
                        keyboardController?.hide()
                        coroutineScope.launch { genderBottomSheetState.show() }
                    }
                )

                var address by remember { mutableStateOf("") }
                AddressInput(
                    address = address
                )

                if (showDateDialog) {
                    BirthDatePickerDialog(
                        onBirthDateSelected = { selectedDate ->
                            dateOfBirth = selectedDate.toString()
                            showDateDialog = false
                        },
                        hideDialog = { showDateDialog = false }
                    )
                }
            }
        })
}

@Composable
private fun NameInput(
    modifier: Modifier = Modifier,
    name: String = "",
    onNewNameInputted: (String) -> Unit = {},
) {
    TextField(
        singleLine = true,
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp)),
        value = name,
        onValueChange = onNewNameInputted,
        placeholder = {
            Text(
                text = (stringResource(R.string.first_name)),
                style = AppTheme.typography.bodyMedium.regular,
                color = AppTheme.colors.grayscale.gs500,
            )
        },
        colors = TextFieldDefaults.appThemeTextFieldColors(),
        textStyle = AppTheme.typography.bodyMedium.semibold,
    )

}

@Composable
private fun SecondNameInput(
    modifier: Modifier = Modifier,
    secondName: String = "",
    onSecondNameInputted: (String) -> Unit = {},
) {
    TextField(
        singleLine = true,
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp)),
        value = secondName,
        onValueChange = onSecondNameInputted,
        placeholder = {
            Text(
                text = stringResource(R.string.second_name),
                style = AppTheme.typography.bodyMedium.regular,
                color = AppTheme.colors.grayscale.gs500,
            )
        },
        colors = TextFieldDefaults.appThemeTextFieldColors(),
        textStyle = AppTheme.typography.bodyMedium.semibold,
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
        colors = TextFieldDefaults.appThemeTextFieldColors(),
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
private fun EmailInput(
    modifier: Modifier = Modifier,
    email: String = "",
    onEmailInputted: (String) -> Unit = {},
) {
    TextField(
        singleLine = true,
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp)),
        value = email,
        onValueChange = onEmailInputted,
        placeholder = {
            Text(
                text = stringResource(R.string.email),
                style = AppTheme.typography.bodyMedium.regular,
                color = AppTheme.colors.grayscale.gs500,
            )
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Email
        ),
        colors = TextFieldDefaults.appThemeTextFieldColors(),
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
private fun CountryInput(
    modifier: Modifier = Modifier,
    country: UserGenderType? = null,
    onGenderFieldClick: () -> Unit = {},
) {
    val countryText = country?.title() ?: ""
    TextField(
        enabled = false,
        singleLine = true,
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .debounceClick { onGenderFieldClick.invoke() },
        value = countryText,
        onValueChange = {},
        placeholder = {
            Text(
                text = stringResource(R.string.choose_country),
                style = AppTheme.typography.bodyMedium.regular,
                color = AppTheme.colors.grayscale.gs500,
            )
        },
        colors = TextFieldDefaults.appThemeTextFieldColors(),
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
private fun PhoneInput(
    modifier: Modifier = Modifier,
    text: String = "",
    onPhoneInputted: (String) -> Unit = {},
) {
    TextField(
        singleLine = true,
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp)),
        value = text,
        onValueChange = onPhoneInputted,
        placeholder = {
            Text(
                text = stringResource(R.string.phone_number),
                style = AppTheme.typography.bodyMedium.regular,
                color = AppTheme.colors.grayscale.gs500,
            )
        },
        colors = TextFieldDefaults.appThemeTextFieldColors(),
        textStyle = AppTheme.typography.bodyMedium.semibold,
    )
}

@Composable
private fun GenderInput(
    modifier: Modifier = Modifier,
    gender: UserGenderType? = null,
    onGenderFieldClick: () -> Unit = {},
) {
    val genderText = gender?.title() ?: ""
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
        colors = TextFieldDefaults.appThemeTextFieldColors(),
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
private fun AddressInput(
    modifier: Modifier = Modifier,
    address: String = "",
    onAddressInputted: (String) -> Unit = {},
) {
    TextField(
        singleLine = true,
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp)),
        value = address,
        onValueChange = onAddressInputted,
        placeholder = {
            Text(
                text = stringResource(R.string.address),
                style = AppTheme.typography.bodyMedium.regular,
                color = AppTheme.colors.grayscale.gs500,
            )
        },
        colors = TextFieldDefaults.appThemeTextFieldColors(),
        textStyle = AppTheme.typography.bodyMedium.semibold,
    )
}

@Preview
@Composable
private fun EditProfileScreenPreview() {
    AppTheme {
        EditProfileScreen()
    }
}
