package com.gorosoft.bookme.now.android.ui.account_setup.create_your_profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.gorosoft.bookme.now.android.NavGraphDestination
import com.gorosoft.bookme.now.android.R
import com.gorosoft.bookme.now.android.ui.account_setup.create_your_profile.composables.BirthDatePickerDialog
import com.gorosoft.bookme.now.android.ui.account_setup.create_your_profile.composables.GenderBottomSheetContent
import com.gorosoft.bookme.now.android.ui.theme.AppTheme
import com.gorosoft.bookme.now.android.ui.utils.BackButtonToolbar
import com.gorosoft.bookme.now.android.ui.utils.ButtonDefaultBottomPadding
import com.gorosoft.bookme.now.android.ui.utils.PrimaryButton
import com.gorosoft.bookme.now.android.ui.utils.appThemeTextFieldColors
import com.gorosoft.bookme.now.android.ui.utils.debounceClick
import com.gorosoft.bookme.now.android.ui_models.CreateProfileUiModel
import com.gorosoft.bookme.now.android.ui_models.title
import com.gorosoft.bookme.now.domain.models.ProfileGenderType
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import java.time.LocalDate

@Composable
fun CreateYourProfileScreen(
    navController: NavController,
    viewModel: CreateYourProfileViewModel = koinViewModel(),
) {
    val profileState by viewModel.profileState.collectAsStateWithLifecycle()
    val buttonEnabledState by viewModel.buttonEnablingState.collectAsStateWithLifecycle()
    CreateYourProfileContent(
        profileState = profileState,
        isButtonEnabledState = buttonEnabledState,
        onNewNameInputted = viewModel::updateName,
        onGenderSelected = viewModel::updateGender,
        onBirthDateSelected = viewModel::updateDateOfBirth,
        navigateForward = {
            navController.navigate(
                route = NavGraphDestination.EnterOtp.route.replace(
                    "{phoneNumber}",
                    "+380 63 111 22 33"
                )
            )
        },
        navigateBack = { navController.popBackStack() },
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun CreateYourProfileContent(
    profileState: CreateProfileUiModel,
    isButtonEnabledState: Boolean,
    onNewNameInputted: (String) -> Unit = {},
    onGenderSelected: (ProfileGenderType) -> Unit = {},
    onBirthDateSelected: (selectedDate: LocalDate) -> Unit = {},
    navigateForward: () -> Unit = {},
    navigateBack: () -> Unit = {},
) {
    val coroutineScope = rememberCoroutineScope()
    val genderBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true,
    )
    val keyboardController = LocalSoftwareKeyboardController.current
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
                    BackButtonToolbar(
                        title = R.string.create_your_profile,
                        navigateBack = navigateBack,
                    )
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
                            keyboardController?.hide()
                            coroutineScope.launch { genderBottomSheetState.show() }
                        }
                    )
                }
                PrimaryButton(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                        .padding(bottom = ButtonDefaultBottomPadding)
                        .imePadding(),
                    text = stringResource(R.string.continue_text),
                    onClick = navigateForward,
                    enabled = isButtonEnabledState
                )
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
private fun GenderInput(
    modifier: Modifier = Modifier,
    gender: ProfileGenderType? = null,
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
        colors = TextFieldDefaults.appThemeTextFieldColors(),
        textStyle = AppTheme.typography.bodyMedium.semibold,
    )
}

@Preview
@Composable
private fun CreateYourProfileScreenPreview() {
    AppTheme {
        CreateYourProfileContent(
            profileState = CreateProfileUiModel(
                fullName = "Joseph Gordon Levit",
            ),
            isButtonEnabledState = true,
        )
    }
}
