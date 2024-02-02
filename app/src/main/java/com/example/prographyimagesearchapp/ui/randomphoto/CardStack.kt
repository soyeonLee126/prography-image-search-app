//package com.example.prographyimagesearchapp.ui.randomphoto
//
//import androidx.compose.material3.Text
//import androidx.compose.foundation.*
//import androidx.compose.foundation.gestures.AnchoredDraggableState
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.*
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.*
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.compose.ui.graphics.graphicsLayer
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.layout.layout
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.Dp
//import androidx.constraintlayout.compose.ConstraintLayout
//import coil.compose.AsyncImage
//import kotlin.math.roundToInt
//
//@Composable
//fun CardStack(
//    modifier: Modifier = Modifier,
//    items: MutableList<Item>,
//    thresholdConfig: (Float, Float) -> ThresholdConfig = { _, _ -> FractionalThreshold(0.2f)},
//    velocityThreshold: Dp = 125.dp,
//    onSwipeLeft: (item: Item) -> Unit = {},
//    onSwipeRight: (item: Item) -> Unit = {},
//    onEmptyStack: (lastItem: Item) -> Unit = {}
//) {
//    var i by remember {
//        mutableStateOf(items.size - 1)
//    }
//
//    if (i == -1) {
//        onEmptyStack(items.last())
//    }
//
//    val cardStackController = rememberCardStackController()
//
//    cardStackController.onSwipeLeft = {
//        onSwipeLeft(items[i])
//        i--
//    }
//
//    cardStackController.onSwipeRight = {
//        onSwipeRight(items[i])
//        i--
//    }
//
//    ConstraintLayout(
//        modifier = modifier
//            .fillMaxSize()
//            .padding(0.dp)
//    ) {
//        val stack = createRef()
//
//        Box(
//            modifier = modifier
//                .constrainAs(stack) {
//                    top.linkTo(parent.top)
//                }
//                .draggableStack(
//                    controller = cardStackController,
//                    anchoredDraggableState = anchoredDraggableState,
//                    velocityThreshold = velocityThreshold
//                )
//                .fillMaxHeight()
//        ) {
//            items.asReversed().forEachIndexed { index, item ->
//                Card(
//                    modifier = Modifier.moveTo(
//                        x = if (index == i) cardStackController.offsetX.value else 0f,
//                        y = if (index == i) cardStackController.offsetY.value else 0f
//                    )
//                        .visible(visible = index == i || index == i -1)
//                        .graphicsLayer(
//                            rotationZ = if (index == i) cardStackController.rotation.value else 0f,
//                            scaleX = if (index < i) cardStackController.scale.value else 1f,
//                            scaleY = if (index < i) cardStackController.scale.value else 1f
//                        ),
//                    item,
//                    cardStackController
//                )
//            }
//        }
//    }
//}
//
//@Composable
//fun Card(
//    modifier: Modifier = Modifier,
//    item: Item,
//    cardStackController: CardStackController
//) {
//    Box(modifier = modifier) {
//        if (item.url != null) {
//            AsyncImage(
//                model = item.url,
//                contentDescription = "",
//                contentScale = ContentScale.Crop,
//                modifier = modifier.fillMaxSize()
//            )
//        }
//
//        Column(
//            modifier = modifier
//                .align(Alignment.BottomStart)
//                .padding(10.dp)
//        ) {
//            Text(text = item.text, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 25.sp)
//            Text(text = item.subText, color = Color.White, fontSize = 20.sp)
//        }
//    }
//}
//
//data class Item(
//    val url: String? = null,
//    val text: String = "",
//    val subText: String = ""
//)
//
//fun Modifier.moveTo(
//    x: Float,
//    y: Float
//) = this.then(Modifier.layout { measurable, constraints ->
//    val placeable = measurable.measure(constraints)
//
//    layout(placeable.width, placeable.height) {
//        placeable.placeRelative(x.roundToInt(), y.roundToInt())
//    }
//})
//
//fun Modifier.visible(
//    visible: Boolean = true
//) = this.then(Modifier.layout{ measurable, constraints ->
//    val placeable = measurable.measure(constraints)
//
//    if (visible) {
//        layout(placeable.width, placeable.height) {
//            placeable.placeRelative(0, 0)
//        }
//    } else {
//        layout(0, 0) {}
//    }
//})
