package com.officegym.liftme.ui.onboarding

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.officegym.liftme.R
import com.officegym.liftme.ui.text_styles.Display_md
import com.officegym.liftme.ui.text_styles.Text_md
import com.officegym.liftme.ui.theme.Blue
import com.officegym.liftme.ui.theme.LightGray
import com.officegym.liftme.ui.theme.LocalLMTheme
import com.officegym.liftme.ui_components.ButtonWithArrow
import com.officegym.liftme.ui_components.ButtonWithShadow

@Composable
fun OnBoardingScreen() {

}

@Composable
fun WelcomeScreen() {
    BoxWithConstraints {
        val maxWidth = maxWidth
        val maxHeight = maxHeight
        val brush = Brush.radialGradient(
            colors = listOf(Blue, Color.Black),
            center = Offset(maxWidth.value, maxHeight.value / 2f),
            radius = maxHeight.value + maxHeight.value * 0.6f,
            tileMode = TileMode.Clamp
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(brush),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(0.6f)),
            )
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Display_md("LiftMe")
                Spacer(Modifier.height(8.dp))
                Text_md("Better your health every day.", textColor = Color.White)
            }

            Box(modifier = Modifier.align(Alignment.BottomCenter), contentAlignment = Alignment.Center) {
                Image(
                    painter = painterResource(R.drawable.doc),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.offset(y = 50.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    ButtonWithShadow(
                        text = "Log in",
                        onClick = {},
                        modifier = Modifier.weight(1f),
                        background = Color.Black,
                        arrowColor = Color.White,
                    )
                    ButtonWithShadow(
                        "Sign up",
                        onClick = {},
                        modifier = Modifier.weight(1f),
                        textColor = Color.Black,
                        borderColor = LightGray,
                    )
                }
            }
        }
    }
}