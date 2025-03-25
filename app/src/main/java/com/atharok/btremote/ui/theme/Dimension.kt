package com.atharok.btremote.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import com.atharok.btremote.R

@Composable
@ReadOnlyComposable
fun dimensionElevation1(): Dp = when(MaterialTheme.colorScheme.background) {
    Color.Black -> dimensionResource(id = R.dimen.elevation_2)
    else -> dimensionResource(id = R.dimen.elevation_1)
}

@Composable
@ReadOnlyComposable
fun dimensionElevation2(): Dp = when(MaterialTheme.colorScheme.background) {
    Color.Black -> dimensionResource(id = R.dimen.elevation_3)
    else -> dimensionResource(id = R.dimen.elevation_2)
}

@Composable
@ReadOnlyComposable
fun dimensionElevation3(): Dp = when(MaterialTheme.colorScheme.background) {
    Color.Black -> dimensionResource(id = R.dimen.elevation_4)
    else -> dimensionResource(id = R.dimen.elevation_3)
}