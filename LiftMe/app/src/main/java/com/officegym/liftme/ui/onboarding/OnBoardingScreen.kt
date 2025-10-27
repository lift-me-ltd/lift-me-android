package com.officegym.liftme.ui.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.officegym.liftme.R
import com.officegym.liftme.ui.constants.Spacings
import com.officegym.liftme.ui.signup.SignUpProgress
import com.officegym.liftme.ui.signup.SignUpSteps
import com.officegym.liftme.ui.text_styles.Display_md
import com.officegym.liftme.ui.text_styles.Text_md
import com.officegym.liftme.ui.theme.BabyBlue
import com.officegym.liftme.ui.theme.BabyBlue2
import com.officegym.liftme.ui.theme.Blue
import com.officegym.liftme.ui.theme.Green
import com.officegym.liftme.ui.theme.LightBlue
import com.officegym.liftme.ui.theme.LightGray
import com.officegym.liftme.ui.theme.LightMint
import com.officegym.liftme.ui.theme.RedOrange
import com.officegym.liftme.ui_components.ButtonWithShadow

@Composable
fun OnBoardingScreen() {

}

@Composable
fun StreamlineYourHealthUI() {
    BoxWithConstraints {
        val maxWidth = maxWidth
        val maxHeight = maxHeight
        val brush = Brush.radialGradient(
            colors = listOf(Green, LightBlue, BabyBlue),
            center = Offset(maxWidth.value, maxHeight.value / 4f),
            radius = maxHeight.value + maxHeight.value * 0.6f,
            tileMode = TileMode.Clamp
        )
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(brush)
        ) {
            val (topBar, bottomContent) = createRefs()

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(topBar) {
                        top.linkTo(parent.top)
                    }
                    .padding(horizontal = Spacings.SPACING_MD, vertical = Spacings.SPACING_XL)
            ) {
                SignUpProgress(
                    options = OnBoardingData.entries.map { it.ordinal },
                    selectedOption = 1,
                    width = ((maxWidth / OnBoardingData.entries.size) - (2 * SignUpSteps.entries.size).dp)
                )
                Spacer(Modifier.height(Spacings.SPACING_XXL))
                OnBoardingTitleDescription(
                    title = stringResource(R.string.streamline_your_health),
                    description = stringResource(R.string.streamline_your_health_description),
                    color = Color.Black,
                )
            }

            Box(
                modifier = Modifier
                    .constrainAs(bottomContent) {
                        bottom.linkTo(parent.bottom)
                    }
            ) {
                Image(
                    painter = painterResource(R.drawable.streamline_health_image),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = Spacings.SPACING_XXL, vertical = Spacings.SPACING_XL)
                        .align(Alignment.BottomCenter),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ArrowBox { }
                    ArrowBox(isLeft = false) { }
                }
            }
        }
    }
}

@Composable
fun ChallengeYourFriends() {
    BoxWithConstraints {
        val maxWidth = maxWidth
        val maxHeight = maxHeight
        val brush = Brush.radialGradient(
            colors = listOf(Blue, Color.Black),
            center = Offset(maxWidth.value, maxHeight.value / 2f),
            radius = maxHeight.value + maxHeight.value * 0.1f,
            tileMode = TileMode.Clamp
        )
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(brush)
        ) {
            val (topBar, bottomContent) = createRefs()

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(topBar) {
                        top.linkTo(parent.top)
                    }
                    .padding(horizontal = Spacings.SPACING_MD, vertical = Spacings.SPACING_XL)
            ) {
                SignUpProgress(
                    options = OnBoardingData.entries.map { it.ordinal },
                    selectedOption = 2,
                    width = ((maxWidth / OnBoardingData.entries.size) - (2 * SignUpSteps.entries.size).dp)
                )
                Spacer(Modifier.height(Spacings.SPACING_XXL))
                OnBoardingTitleDescription(
                    title = stringResource(R.string.challenge_your_friends),
                    description = stringResource(R.string.challenge_your_friends_description),
                    color = Color.White,
                )
            }

            Box(
                modifier = Modifier
                    .constrainAs(bottomContent) {
                        bottom.linkTo(parent.bottom)
                    }
            ) {
                Image(
                    painter = painterResource(R.drawable.dots_bg),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.height(maxHeight/1.5f).align(Alignment.TopCenter),
                )


                Image(
                    painter = painterResource(R.drawable.fusebox),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.height(maxHeight/2f).align(Alignment.BottomStart),
                )


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = Spacings.SPACING_XXL, vertical = Spacings.SPACING_XL)
                        .align(Alignment.BottomCenter),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ArrowBox { }
                    ArrowBox(isLeft = false) { }
                }
            }
        }
    }
}

@Composable
fun TrainWithEveryone() {
    BoxWithConstraints {
        val maxWidth = maxWidth
        val maxHeight = maxHeight
        val brush = Brush.linearGradient(
            colors = listOf(BabyBlue2, LightMint, Color.White),
            tileMode = TileMode.Clamp
        )
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(brush)
        ) {
            val (topBar, bottomContent) = createRefs()

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(topBar) {
                        top.linkTo(parent.top)
                    }
                    .padding(horizontal = Spacings.SPACING_MD, vertical = Spacings.SPACING_XL)
            ) {
                SignUpProgress(
                    options = OnBoardingData.entries.map { it.ordinal },
                    selectedOption = 2,
                    width = ((maxWidth / OnBoardingData.entries.size) - (2 * SignUpSteps.entries.size).dp)
                )
                Spacer(Modifier.height(Spacings.SPACING_XXL))
                OnBoardingTitleDescription(
                    title = stringResource(R.string.train_with_everyone),
                    description = stringResource(R.string.train_with_everyone_description),
                    color = Color.Black,
                )
            }

            Column(
                modifier = Modifier
                    .constrainAs(bottomContent) {
                        bottom.linkTo(parent.bottom)
                    }
            ) {
                Image(
                    painter = painterResource(R.drawable.train_with_everyone),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                )


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(horizontal = Spacings.SPACING_XXL, vertical = Spacings.SPACING_XL),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ArrowBox { }
                    ArrowBox(isLeft = false) { }
                }
            }
        }
    }
}

@Composable
fun TurnUpTheVolume() {
    BoxWithConstraints {
        val maxWidth = maxWidth
        val maxHeight = maxHeight
        val brush = Brush.radialGradient(
            colors = listOf(RedOrange, Color.Black),
            center = Offset(maxWidth.value, maxHeight.value / 2f),
            radius = maxHeight.value + maxHeight.value * 0.2f,
            tileMode = TileMode.Clamp
        )
        val bottomBrush = Brush.linearGradient(
            colors = listOf(Color.Transparent, Color.Black)
        )
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(brush)
        ) {
            val (topBar, bottomContent) = createRefs()

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(topBar) {
                        top.linkTo(parent.top)
                    }
                    .padding(horizontal = Spacings.SPACING_MD, vertical = Spacings.SPACING_XL)
            ) {
                SignUpProgress(
                    options = OnBoardingData.entries.map { it.ordinal },
                    selectedOption = 2,
                    width = ((maxWidth / OnBoardingData.entries.size) - (2 * SignUpSteps.entries.size).dp)
                )
                Spacer(Modifier.height(Spacings.SPACING_XXL))
                OnBoardingTitleDescription(
                    title = stringResource(R.string.turn_up_volume),
                    description = stringResource(R.string.turn_up_volume_description),
                    color = Color.White,
                )
            }

            Box(
                modifier = Modifier
                    .constrainAs(bottomContent) {
                        bottom.linkTo(parent.bottom)
                    }
            ) {
                Image(
                    painter = painterResource(R.drawable.volume),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.align(Alignment.BottomStart),
                )


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
//                        .background(bottomBrush)
                        .padding(horizontal = Spacings.SPACING_XXL, vertical = Spacings.SPACING_XL)
                        .align(Alignment.BottomCenter),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ArrowBox { }
                    ArrowBox(isLeft = false) { }
                }
            }
        }
    }
}