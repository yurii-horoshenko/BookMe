package com.gorosoft.bookme.now.android.ui.main_screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.gorosoft.bookme.now.android.R
import com.gorosoft.bookme.now.android.ui.main_screen.explore.EnableLocationContent
import com.gorosoft.bookme.now.android.ui.theme.AppTheme
import com.gorosoft.bookme.now.android.ui.utils.PrimaryButton
import com.gorosoft.bookme.now.android.ui.utils.SecondaryButton
import com.gorosoft.bookme.now.android.ui.utils.debounceClick

@Preview
@Composable
fun Logout(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit = { },
) {

    Box(
        modifier = Modifier
            .width(428.dp)
            .height(266.dp)
            .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
            .background(AppTheme.colors.backgroundThemed.backgroundMain)
            .border(1.dp, Color(0xF5F5F5))


    ) {

        Text(
            modifier = Modifier
                .padding(40.dp)
                .align(Alignment.TopCenter),
            text = "Logout",
            style = AppTheme.typography.heading.h4,
            color = Color(0xFFF75555)
        )
        HorizontalDivider(
            modifier =Modifier
                .align(Alignment.TopCenter)
                .width(380.dp)
                .padding(top = 95.dp)
            ,
            color = AppTheme.colors.grayscale.gs200,
            thickness = 1.dp,
        )


        Text(
            modifier = Modifier
                .align(Alignment.Center),
            text = "Are you sure you want to log out?",
            style = AppTheme.typography.heading.h5,
            color = Color.Black,
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .padding(24.dp)
                .align(Alignment.BottomCenter)


        ) {
            SecondaryButton(
                modifier = Modifier
                    .padding(top = 32.dp, start = 1.dp, end = 3.dp)
                    .fillMaxWidth()
                    .weight(1f),
                text = stringResource(R.string.cancel),
                onClick = {},
            )
            PrimaryButton(
                modifier = Modifier
                    .padding(top = 32.dp, start = 1.dp, end = 3.dp)
                    .fillMaxWidth()
                    .weight(1f),
                text = "Yes, Logout",
                onClick = {},
            )

        }

    }
}




