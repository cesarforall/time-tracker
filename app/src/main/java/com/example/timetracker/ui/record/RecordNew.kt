package com.example.timetracker.ui.record

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.timetracker.R
import com.example.timetracker.ui.theme.TimeTrackerTheme

@Composable
fun RecordNewScreen(
    onArrowBackClicked: () -> Unit
) {
    Scaffold(
        topBar = { TimeTrackerTopAppBar(onArrowBackClicked) }
    ) { innerPadding ->
        RecordNewBody(
            contentPadding = innerPadding,
            modifier = Modifier
        )
    }
}

@Composable
fun RecordNewBody(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
        Column(
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.extra_large)),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxWidth()
                .padding(contentPadding)
        ) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text(text = stringResource(R.string.title)) }
            )
            Text(
                text = "00:00:00",
                style = MaterialTheme.typography.displayLarge
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.small)),
                modifier = Modifier
            ) {
                Button(
                    onClick = { /*TODO*/ }
                ) {
                    Text(
                        text = stringResource(R.string.start),
                        modifier = Modifier
                            .padding(dimensionResource(R.dimen.extra_small))
                    )
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(
                        text = stringResource(R.string.pause),
                        modifier = Modifier
                            .padding(dimensionResource(R.dimen.extra_small))
                    )
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(
                        text = stringResource(R.string.stop),
                        modifier = Modifier
                            .padding(dimensionResource(R.dimen.extra_small))
                        )
                }
            }
        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeTrackerTopAppBar(
    onArrowBackClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = { Text(text = stringResource(R.string.new_record)) },
        navigationIcon = {
            IconButton(onClick = onArrowBackClicked) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Localized description"
                )
            }
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun RecordNewScreenPreview() {
    TimeTrackerTheme {
        RecordNewScreen({})
    }
}