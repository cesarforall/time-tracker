package com.example.timetracker.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.FitnessCenter
import androidx.compose.material.icons.outlined.QueryStats
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.timetracker.R
import com.example.timetracker.data.RecordItem
import com.example.timetracker.ui.theme.TimeTrackerTheme

@Composable
fun HomeScreen(
    navigateToRecordNew: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = { TimeTrackerTopAppBar() },
        floatingActionButton = { NewRecordButton(onAddButtonClick = navigateToRecordNew) }
    ) { innerPadding ->
        HomeBody(
            modifier = modifier
                .padding(innerPadding)
        )
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeTrackerTopAppBar(
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = { Text(text = stringResource(R.string.app_name)) },
        modifier = modifier
    )
}
@Composable
fun HomeBody(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    ListRecordItem(
        recordItems = listRecordItem,
        modifier = modifier
            .padding(contentPadding)
    )
}

@Composable
fun ListRecordItem(
    recordItems: List<RecordItem>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
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
    Column(
        modifier = modifier
    ) {
        ListItem(
            headlineContent = { Text(text = recordItem.title) },
            supportingContent = {
                Column {
                    Text(text = recordItem.time)
                    Text(text = recordItem.date)
                }
            },
            leadingContent = {
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                ) {
                    Icon(
                        imageVector = Icons.Outlined.FitnessCenter,
                        contentDescription = "",
                        modifier = Modifier
                    )
                }
            },
            trailingContent = {
                IconButton(
                    onClick = { /*TODO*/ }
                ) {
                    Icon(
                        imageVector = Icons.Outlined.QueryStats,
                        contentDescription = "",
                        modifier = Modifier
                    )
                }
            }
        )
        HorizontalDivider()
    }


}

@Composable
fun NewRecordButton(
    onAddButtonClick: () -> Unit
) {
    FloatingActionButton(
        onClick = onAddButtonClick
    ) {
        Icon(imageVector = Icons.Default.Add , contentDescription = "Add new record")
    }
}

// Previews
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    TimeTrackerTheme {
        HomeScreen(navigateToRecordNew = {})
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
    RecordItem(
        RecordItem(
        id = 3,
        title = "Fondos",
        category = "Ejercicio",
        date = "20-12-1989",
        time = "00:00:00"
    )
    )
}