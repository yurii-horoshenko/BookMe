package com.gorosoft.bookme.now.android.ui.main_screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.gorosoft.bookme.now.android.R
import com.gorosoft.bookme.now.android.ui.theme.AppTheme
import com.gorosoft.bookme.now.android.ui.utils.PrimaryButton
import com.gorosoft.bookme.now.android.ui.utils.appThemeTextFieldColors

@Composable
fun EnableFeedbackDialog(
    modifier: Modifier = Modifier,
    onEnableFeedback: () -> Unit = { },
    onDismiss: () -> Unit = { },
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .clip(RoundedCornerShape(20.dp))
                .background(AppTheme.colors.backgroundThemed.backgroundMain),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            EnableFeedbackDialog(onEnableFeedback)
            PrimaryButton(
                modifier = Modifier
                    .padding(start = 32.dp, end = 32.dp, bottom = 32.dp)
                    .fillMaxWidth(),
                text = stringResource(R.string.ok),
                onClick = onDismiss,
            )
        }
    }
}

@Composable
fun ColumnScope.EnableFeedbackDialog(onEnableLocation: () -> Unit) {
    Image(
        modifier = Modifier.padding(top = 40.dp),
        painter = painterResource(R.drawable.image_location_permission),
        contentDescription = "location permission image"
    )
    Text(
        modifier = Modifier.padding(top = 16.dp, start = 32.dp, end = 32.dp),
        text = stringResource(R.string.you_have_done_using_barber_salon_service),
        style = AppTheme.typography.heading.h4,
        color = AppTheme.colors.mainColors.primary500,
        textAlign = TextAlign.Center,

        )
    Text(
        modifier = Modifier.padding(top = 16.dp, start = 32.dp, end = 32.dp),
        text = stringResource(R.string.please_leave_your_review_so_others_people_can_know_your_opinion),
        style = AppTheme.typography.bodyLarge.regular,
        color = AppTheme.colors.grayscale.gs900,
        textAlign = TextAlign.Center,
    )
    var rating by remember{mutableDoubleStateOf(3.5)}
    RatingBar(modifier = Modifier
        .size(50.dp),
        rating = rating,
        onRatingChanged = {
            rating = it
        },
        starsColor = Color.Yellow)
    FeedbackInput(
    )
}

@Composable
private fun FeedbackInput(
    modifier: Modifier = Modifier,
    name: String = "",
    onNewNameInputted: (String) -> Unit = {},
) {
    TextField(
        singleLine = true,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp, vertical = 32.dp)
            .border(1.dp, AppTheme.colors.mainColors.primary500, RoundedCornerShape(20.dp))
            .clip(RoundedCornerShape(20.dp)),
        value = name,
        onValueChange = onNewNameInputted,
        placeholder = {
            androidx.compose.material.Text(
                text = (stringResource(R.string.first_name)),
                style = AppTheme.typography.bodyMedium.regular,
                color = AppTheme.colors.grayscale.gs500,
            )
        },
        textStyle = AppTheme.typography.bodyMedium.semibold,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = AppTheme.colors.mainColors.primary500.copy(alpha = 0.08f),
        ),
    )
}

@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    rating: Double = 0.0,
    stars: Int = 5,
    onRatingChanged: (Double) -> Unit,
    starsColor: Color = Color.Yellow
) {

    var isHalfStar = (rating % 1) != 0.0

    Row {
        for (index in 1..stars) {
            Icon(
                imageVector =
                if (index <= rating) {
                    Icons.Rounded.Star
                } else {
                    if (isHalfStar) {
                        isHalfStar = false
                        Icons.Rounded.Star
                    } else {
                        Icons.Rounded.Star
                    }
                },
                contentDescription = null,
                tint = starsColor,
                modifier = modifier
                    .clickable { onRatingChanged(index.toDouble()) }
            )
        }
    }
}

@Preview
@Composable
private fun EnableFeedbackDialogPreview() {
    AppTheme {
        EnableFeedbackDialog {}
    }
}
