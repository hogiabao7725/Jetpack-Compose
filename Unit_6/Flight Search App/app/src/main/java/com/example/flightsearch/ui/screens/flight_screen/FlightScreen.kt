package com.example.flightsearch.ui.screens.flight_screen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.flightsearch.NavigationDestination

object FlightScreenDestination : NavigationDestination {
    override val route = "flight_screen"
    override val titleRes = "Flight Search"
    const val codeArg = "code"
    val routeWithArgs = "$route/{$codeArg}"

}

@Composable
fun FlightScreen() {
    val viewModel: FlightViewModel = viewModel(factory = FlightViewModel.Factory)
    val uiState = viewModel.uiState.collectAsState()

    val context = LocalContext.current
    // val scope = rememberCoroutineScope()
    Column {
            FlightResults(
                departureAirport = uiState.value.departureAirport,
                destinationList = uiState.value.destinationList,
                favoriteList = uiState.value.favoriteList,
                onFavoriteClick = { s1: String, s2: String ->
                        viewModel.addFavoriteFlight(s1, s2)
                    if(viewModel.flightAdded){
                        Toast.makeText(context,"ADDED", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(context,"DELETED", Toast.LENGTH_SHORT).show()
                    }
                }
            )
    }
}