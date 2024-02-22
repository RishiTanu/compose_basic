package com.example.jetpack_compose.ui.activity.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.NavHostController
import com.example.democompose.R
import com.example.jetpack_compose.ui.activity.home.widgets.Drawer
import com.example.jetpack_compose.ui.activity.home.widgets.TopBar

@Composable
fun DashboardScreen(navController: NavHostController) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()
    //If you want the open drawer from the right side, uncomment the following
  //  CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl)

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(scope = scope, scaffoldState = scaffoldState) },
       // drawerBackgroundColor = colorResource(id = R.color.blue),
        backgroundColor = colorResource(id = R.color.white),
        drawerContent = {
            Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)){

        }
    }
}