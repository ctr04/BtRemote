package com.ctr04.touchpad.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ctr04.touchpad.R
import com.ctr04.touchpad.ui.components.AppScaffold
import com.ctr04.touchpad.ui.components.MaterialButton
import com.ctr04.touchpad.ui.components.SettingsIconButton
import com.ctr04.touchpad.ui.components.TextMedium
import com.ctr04.touchpad.ui.components.TextNormalSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActivationView(
    topBarTitle: String,
    image: ImageVector,
    title: String,
    message: String,
    buttonIcon: ImageVector,
    buttonText: String,
    buttonOnClick: () -> Unit,
    hideButton: Boolean,
    navigateToSettings: () -> Unit,
    modifier: Modifier = Modifier
) {
    AppScaffold(
        title = topBarTitle,
        modifier = modifier,
        scrollBehavior = null,
        topBarActions = {
            SettingsIconButton(navigateToSettings)
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        horizontal = dimensionResource(id = R.dimen.padding_max),
                        vertical = dimensionResource(id = R.dimen.padding_small)
                    ),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier)

                Content(
                    image = image,
                    title = title,
                    message = message,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding( // Permet de centrer verticalement, indépendamment du inner Padding.
                            top = innerPadding.calculateBottomPadding() / 2f,
                            bottom = innerPadding.calculateTopPadding() / 2f
                        )
                )

                if(!hideButton) {
                    MaterialButton(
                        onClick = buttonOnClick,
                        modifier = Modifier.fillMaxWidth(),
                        text = buttonText,
                        icon = buttonIcon,
                    )
                } else {
                    Spacer(modifier = Modifier)
                }
            }
        }
    }
}

@Composable
private fun Content(
    image: ImageVector,
    title: String,
    message: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            imageVector = image,
            contentDescription = null,
            modifier = Modifier
                .size(96.dp)
                .aspectRatio(1f),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface)
        )

        TextMedium(
            text = title,
            Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_medium)),
            textAlign = TextAlign.Center
        )

        TextNormalSecondary(
            text = message,
            textAlign = TextAlign.Center
        )
    }
}