package com.officegym.liftme.ui.signup

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.officegym.liftme.R
import com.officegym.liftme.ui.text_styles.Text_md
import com.officegym.liftme.ui.theme.LocalLMTheme

@Composable
fun SocialIcon(
    @DrawableRes socialRes: Int,
    socialTitle: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .border(1.dp, LocalLMTheme.current.colors.textSecondary)
            .padding(
                horizontal = dimensionResource(id = R.dimen.social_icon_horizontal_padding),
                vertical = dimensionResource(id = R.dimen.social_icon_vertical_padding)
            )
    ) {
        Image(painter = painterResource(id = socialRes), contentDescription = "social")
        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.spacing_xs)))
        Text_md(text = socialTitle, lineHeight = 22.sp)
    }
}
