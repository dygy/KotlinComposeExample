package components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.dp

@Composable
fun MyTable(
    modifier: Modifier = Modifier,
    rowModifier: Modifier = Modifier
        .border(width = 2.dp, color = Color.White),
    verticalLazyListState: LazyListState = rememberLazyListState(),
    horizontalScrollState: ScrollState = rememberScrollState(),
    columnCount: Int,
    rowCount: Int,
    beforeRow: (@Composable (rowIndex: Int) -> Unit)? = null,
    afterRow: (@Composable (rowIndex: Int) -> Unit)? = null,
    cellContent: @Composable (columnIndex: Int, rowIndex: Int) -> Unit
) {
    val columnWidths = remember { mutableStateMapOf<Int, Int>() }

    Box(modifier = modifier.then(Modifier.horizontalScroll(horizontalScrollState))) {
        LazyColumn(state = verticalLazyListState) {
            items(rowCount) { rowIndex ->
                Column {
                    beforeRow?.invoke(rowIndex)

                    Row(modifier = rowModifier) {
                        (0 until columnCount).forEach { columnIndex ->
                            Box(modifier = Modifier
                                .border(width = 2.dp, color = Color.White)
                                .background(Color.LightGray.takeIf { rowIndex == 0 } ?: Color.Gray )
                                .padding(4.dp)
                                .layout { measurable, constraints ->
                                    val placeable = measurable.measure(constraints)

                                    val existingWidth = columnWidths[columnIndex] ?: 0
                                    val maxWidth = maxOf(existingWidth, placeable.width)

                                    if (maxWidth > existingWidth) {
                                        columnWidths[columnIndex] = maxWidth
                                    }

                                    layout(width = maxWidth, height = placeable.height) {
                                        placeable.placeRelative(0, 0)
                                    }
                                }) {
                                cellContent(columnIndex, rowIndex)
                            }
                        }
                    }
                    afterRow?.invoke(rowIndex)
                }
            }
        }
    }
}