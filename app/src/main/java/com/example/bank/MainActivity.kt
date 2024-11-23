package com.example.bank

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bank.ui.theme.BankTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BankTheme {
                val scope = rememberCoroutineScope()
                val snackbarHostState = remember { SnackbarHostState() }
                Scaffold(modifier = Modifier.fillMaxSize(),
                    bottomBar = {BottomNavigation()},
                            snackbarHost = {
                        SnackbarHost(hostState = snackbarHostState)
                    },
                    floatingActionButton = {
                        ExtendedFloatingActionButton(
                            text = { null },
                            icon = { Icon(Icons.Filled.CheckCircle, contentDescription = null) },
                            onClick = {
                                scope.launch {
                                    snackbarHostState.showSnackbar("Snackbar")
                                }
                            }
                        )
                    }
                    ) { innerPadding ->


                WalletSection()

                }
            }
        }
    }
}


@Composable
fun BottomNavigation(){
    NavigationBar {
        Row (
        ) {
            NavigationBarItem(
                selected = true,
                onClick = {},
               icon = {
                   Icon(
                       imageVector = Icons.Default.Home,
                       contentDescription = null
                   )
               },
                label={
                    Text(text="Home")
                }
            )
            NavigationBarItem(
                selected = true,
                onClick = {},
                icon = {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = null
                    )
                },
                label={
                    Text(text="Favourite")
                }
            )
            NavigationBarItem(
                selected = true,
                onClick = {},
                icon = {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = null
                    )
                },
                label={
                    Text(text="Settings")
                }
            )
            NavigationBarItem(
                selected = true,
                onClick = {},
                icon = {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = null
                    )
                },
                label={
                    Text(text="Account")
                }
            )

        }
    }
}

//@Preview
@Composable
fun WalletSection(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Cyan)
    ) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp, start = 5.dp, end = 5.dp)

    ){
        Column {
            Text(text = "Wallet", color = Color.White)
            Text(text = "KES 56,788", color = Color.White, fontSize = 23.sp)
        }
        Box(){
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        }

    }
}}