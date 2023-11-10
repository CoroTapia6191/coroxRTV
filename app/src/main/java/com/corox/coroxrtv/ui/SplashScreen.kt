package com.corox.coroxrtv.ui

import android.content.pm.PackageInfo
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.corox.coroxrtv.R
import com.corox.coroxrtv.navigation.AppScreens


@Composable
fun SplashScreen(navController: NavController, mainViewModel: MainViewModel) {
//        LaunchedEffect(key1 = true) {
//            delay(5000)
//            navController.popBackStack();
//            navController.navigate(AppScreens.MainScreen.route)
//        }
    mainViewModel.getVErsionAppControl();
    Splash();
    val updateVersionApp: Int? by mainViewModel.versionAppVerify.observeAsState(initial = null)

    if (updateVersionApp != null) {
        if (updateVersionApp == 1) {
            Toast.makeText(
                LocalContext.current,
                stringResource(id = R.string.minVersionAlert),
                Toast.LENGTH_LONG
            ).show()
        } else {
            navController.popBackStack();
            navController.navigate(AppScreens.MainScreen.route)
        }
    }

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