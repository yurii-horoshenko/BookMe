package com.gorosoft.bookme.now.android.ui.main_screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.gorosoft.bookme.now.android.R
import com.gorosoft.bookme.now.android.ui.theme.AppTheme
import com.gorosoft.bookme.now.android.ui.utils.debounceClick

@Composable
fun NearByLocationItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    ElevatedCard(
        shape = RoundedCornerShape(20.dp),
        modifier = modifier,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 12.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = AppTheme.colors.backgroundThemed.backgroundMain,
        ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(112.dp)
                .background(AppTheme.colors.backgroundThemed.backgroundMain)
                .debounceClick(onClick = onClick)
                .padding(16.dp)
        ) {
            if (LocalInspectionMode.current) {
                Image(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    painter = painterResource(id = R.drawable.barber_image_example),
                    contentDescription = "place image",
                )
            } else {
                AsyncImage(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Crop,
                    model = "https://images.pexels.com/photos/2881253/pexels-photo-2881253.jpeg?" +
                            "cs=srgb&dl=pexels-thgusstavo-2881253.jpg",
                    contentDescription = "small location image",
                )
            }
            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "Belle Curls",
                    style = AppTheme.typography.heading.h6,
                    color = AppTheme.colors.grayscale.gs900,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    text = "0993 Novick Parkway",
                    style = AppTheme.typography.bodyMedium.medium,
                    color = AppTheme.colors.grayscale.gs600,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Row {
                    Image(
                        painter = painterResource(R.drawable.ic_location),
                        contentDescription = "location image"
                    )
                    Text(
                        modifier = Modifier.padding(start = 6.dp),
                        text = "0.5 km",
                        style = AppTheme.typography.bodyMedium.medium,
                        color = AppTheme.colors.grayscale.gs800,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Image(
                        painter = painterResource(R.drawable.ic_rating_star),
                        contentDescription = "location image"
                    )
                    Text(
                        modifier = Modifier.padding(start = 6.dp),
                        text = "4.5",
                        style = AppTheme.typography.bodyMedium.medium,
                        color = AppTheme.colors.grayscale.gs800,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun NearByLocationItemPreview() {
    AppTheme {
        NearByLocationItem()
    }
}
