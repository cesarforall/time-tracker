package com.example.timetracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material.icons.outlined.QueryStats
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.timetracker.data.RecordItem
import com.example.timetracker.ui.theme.TimeTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TimeTrackerTheme {
                HomeScreen()
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Scaffold(
        topBar = { HomeScreenTopAppBar() },
        floatingActionButton = { NewRecordButton() }
    ) { innerPadding ->
        ListRecordItem(
            recordItems = listRecordItem,
            modifier = Modifier
                .padding(innerPadding)
        )
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenTopAppBar(
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = stringResource(R.string.time).uppercase(),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.displayMedium
                )
                Spacer(modifier = Modifier.size(8.dp))
                Icon(
                    imageVector = Icons.Outlined.AccessTime,
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxHeight()
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = stringResource(R.string.tracker).uppercase(),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.displayMedium
                )
            }
        }
    )
}

@Composable
fun ListRecordItem(
    recordItems: List<RecordItem>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.small)),
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = dimensionResource(R.dimen.small),
                end = dimensionResource(R.dimen.small),
                bottom = dimensionResource(R.dimen.small)
            )
    ) {
        items(recordItems) { recordItem ->
            RecordItem(recordItem)
        }
    }
}

@Composable
fun RecordItem(
    recordItem: RecordItem,
    modifier: Modifier = Modifier
) {
    OutlinedCard {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            //verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.small))
        ) {
            Column {
                Text(
                    text = recordItem.title,
                    style = MaterialTheme.typography.headlineMedium
                )
                Spacer(modifier = Modifier.size(dimensionResource(R.dimen.small)))
                Text(text = recordItem.time)
                Text(text = recordItem.date)
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.medium)),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = recordItem.category,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .clickable {  }
                )
                Icon(
                    imageVector = Icons.Outlined.QueryStats,
                    contentDescription = "",
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.extra_large))
                )
            }
        }
    }
}

@Composable
fun NewRecordButton() {
    FloatingActionButton(
        onClick = { /*TODO*/ }
    ) {
        Icon(imageVector = Icons.Default.Add , contentDescription = "Add new record")
    }
}

// Previews
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    TimeTrackerTheme {
        HomeScreen()
    }
}

private val listRecordItem: List<RecordItem> =
    listOf(
        RecordItem(
            id = 1,
            title = "Push ups",
            category = "Ejercicio",
            date = "20-12-1989",
            time = "00:00:00"
        ),
        RecordItem(
            id = 2,
            title = "Kotlin",
            category = "Estudio",
            date = "20-12-1989",
            time = "00:00:00"
        ),
        RecordItem(
            id = 2,
            title = "Kotlin",
            category = "Estudio",
            date = "20-12-1989",
            time = "00:00:00"
        ),
        RecordItem(
            id = 2,
            title = "Kotlin",
            category = "Estudio",
            date = "20-12-1989",
            time = "00:00:00"
        ),
        RecordItem(
            id = 2,
            title = "Kotlin",
            category = "Estudio",
            date = "20-12-1989",
            time = "00:00:00"
        ),
        RecordItem(
            id = 2,
            title = "Kotlin",
            category = "Estudio",
            date = "20-12-1989",
            time = "00:00:00"
        ),
        RecordItem(
            id = 2,
            title = "Kotlin",
            category = "Estudio",
            date = "20-12-1989",
            time = "00:00:00"
        ),
        RecordItem(
            id = 2,
            title = "Kotlin",
            category = "Estudio",
            date = "20-12-1989",
            time = "00:00:00"
        )
    )

@Preview(showBackground = true)
@Composable
fun ListRecordItemPreview() {
    ListRecordItem(recordItems = listRecordItem)
}

@Preview(showBackground = true)
@Composable
fun RecordItemPreview() {
    RecordItem(RecordItem(
        id = 3,
        title = "Fondos",
        category = "Ejercicio",
        date = "20-12-1989",
        time = "00:00:00"
    )
    )
}