package com.corox.coroxrtv

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.corox.coroxrtv.navigation.AppScreens
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(key1 = true) {
        delay(5000)
        navController.popBackStack();
        navController.navigate(AppScreens.MainScreen.route)
    }
    Splash();
}

@Composable
fun Splash() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                colorResource(id = R.color.black_splash)
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        //Image pendiente
        Image(
            painterResource(id = R.mipmap.cxsplash),
            contentDescription = "splash",
            Modifier.size(250.dp, 250.dp)
        )

        Text(
            text = stringResource(R.string.welcome),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold, color = colorResource(id = R.color.white)
        )

    }
}

@Composable
@Preview(showBackground = true)
fun SplashScreenPreview() {
    Splash();
}