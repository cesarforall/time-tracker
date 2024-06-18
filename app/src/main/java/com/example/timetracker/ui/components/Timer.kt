package com.example.timetracker.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.timetracker.R
import com.example.timetracker.ui.theme.TimeTrackerTheme

@Composable
fun Timer(
    timerViewModel: TimerViewModel,
    modifier: Modifier = Modifier
) {
    val timerValue by timerViewModel.timer.collectAsState()
    TimerUi(
        timeValue = timerValue,
        onStartClick = { /*TODO*/ },
        onPauseClick = { /*TODO*/ },
        onStopClick = { /*TODO*/ },
        modifier = modifier
        )
}

@Composable
fun TimerUi(
    timeValue: Long,
    onStartClick: () -> Unit,
    onPauseClick: () -> Unit,
    onStopClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = timeValue.formatTime(),
            style = MaterialTheme.typography.displayLarge
        )
        Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.extra_small)))
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Button(
                onClick = onStartClick,
                modifier = Modifier
                    .weight(1F)
            ) {
                Text(
                    text = stringResource(R.string.start)
                )
            }
            Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.extra_small)))
            Button(
                onClick = onPauseClick,
                modifier = Modifier
                    .weight(1F)
            ) {
                Text(
                    text = stringResource(R.string.pause)
                )
            }
            Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.extra_small)))
            Button(
                onClick = onStopClick,
                modifier = Modifier
                    .weight(1F)
            ) {
                Text(
                    text = stringResource(R.string.stop)
                )
            }
        }
    }
}

@SuppressLint("DefaultLocale")
private fun Long.formatTime(): String {
    val hours = this / 3600
    val minutes = (this % 3600) / 60
    val seconds = this % 60

    return String.format("%02d:%02d:%02d", hours, minutes, seconds)
}

@Preview(showBackground = true)
@Composable
fun TimerPreview() {
    TimeTrackerTheme {
        TimerUi(
            timeValue = 3700,
            onStartClick = { },
            onPauseClick = { },
            onStopClick = { }
        )
    }
}