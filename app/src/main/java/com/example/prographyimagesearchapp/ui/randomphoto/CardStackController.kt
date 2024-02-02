//package com.example.prographyimagesearchapp.ui.randomphoto
//
//import androidx.compose.animation.core.Animatable
//import androidx.compose.animation.core.AnimationSpec
//import androidx.compose.foundation.ExperimentalFoundationApi
//import androidx.compose.foundation.gestures.AnchoredDraggableState
//import androidx.compose.foundation.gestures.detectDragGestures
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.rememberCoroutineScope
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.composed
//import androidx.compose.ui.geometry.Offset
//import androidx.compose.ui.input.pointer.pointerInput
//import androidx.compose.ui.platform.LocalConfiguration
//import androidx.compose.ui.platform.LocalDensity
//import androidx.compose.ui.unit.Dp
//import androidx.compose.ui.unit.dp
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.launch
//import java.lang.Math.abs
//import kotlin.math.sign
//
//open class CardStackController @OptIn(ExperimentalFoundationApi::class) constructor(
//    val scope: CoroutineScope,
//    private val screenWidth: Float,
//    internal val animationSpec: AnimationSpec<Float> = AnchoredDraggableState.Saver<Float>()
//) {
//    val right = Offset(screenWidth, 0f)
//    val left = Offset(-screenWidth, 0f)
//    val center = Offset(0f, 0f)
//
//    var threshold = 0.0f
//
//    val offsetX = Animatable(0f)
//    val offsetY = Animatable(0f)
//    val rotation = Animatable(0f)
//    val scale = Animatable(0.8f)
//
//    var onSwipeLeft: () -> Unit = {}
//    var onSwipeRight: () -> Unit = {}
//
//    fun swipeLeft() {
//        scope.apply {
//            launch {
//                offsetX.animateTo(-screenWidth, animationSpec)
//
//                onSwipeLeft()
//
//                launch {
//                    offsetX.snapTo(center.x)
//                }
//
//                launch {
//                    offsetY.snapTo(0f)
//                }
//
//                launch {
//                    rotation.snapTo(0f)
//                }
//
//                launch {
//                    scale.snapTo(0.8f)
//                }
//            }
//
//            launch {
//                scale.animateTo(1f, animationSpec)
//            }
//        }
//    }
//
//    fun swipeRight() {
//        scope.apply {
//            launch {
//                offsetX.animateTo(screenWidth, animationSpec)
//
//                onSwipeRight()
//
//                launch {
//                    offsetX.snapTo(center.x)
//                }
//
//                launch {
//                    offsetY.snapTo(0f)
//                }
//
//                launch {
//                    scale.snapTo(0.8f)
//                }
//
//                launch {
//                    rotation.snapTo(0f)
//                }
//            }
//
//            launch {
//                scale.animateTo(1f, animationSpec)
//            }
//        }
//    }
//
//    fun returnCenter() {
//        scope.apply {
//            launch {
//                offsetX.animateTo(center.x, animationSpec)
//            }
//
//            launch {
//                offsetY.animateTo(center.y, animationSpec)
//            }
//
//            launch {
//                rotation.animateTo(0f, animationSpec)
//            }
//
//            launch {
//                scale.animateTo(0.8f, animationSpec)
//            }
//        }
//    }
//}
//
//@Composable
//fun rememberCardStackController(
//    animationSpec: AnimationSpec<Float> = SwipeableDefaults.AnimationSpec
//): CardStackController {
//    val scope = rememberCoroutineScope()
//    val screenWidth = with(LocalDensity.current) {
//        LocalConfiguration.current.screenWidthDp.dp.toPx()
//    }
//
//    return remember {
//        CardStackController(
//            scope = scope,
//            screenWidth = screenWidth,
//            animationSpec = animationSpec
//        )
//    }
//}
//
//@OptIn(ExperimentalFoundationApi::class)
//fun Modifier.draggableStack(
//    controller: CardStackController,
//    anchoredDraggableState: (Float, Float) -> AnchoredDraggableState,
//    velocityThreshold: Dp = 125.dp
//): Modifier = composed {
//    val scope = rememberCoroutineScope()
//    val density = LocalDensity.current
//
//    val velocityThresholdPx = with(density) {
//        velocityThreshold.toPx()
//    }
//
//    val thresholds = { a: Float, b: Float ->
//        with(anchoredDraggableState(a, b)) {
//            density.computeThreshold(a, b)
//        }
//    }
//
//    controller.threshold = thresholds(controller.center.x, controller.right.x)
//
//    Modifier.pointerInput(Unit) {
//        detectDragGestures(
//            onDragEnd = {
//                if (controller.offsetX.value <= 0f) {
//                    if (controller.offsetX.value > -controller.threshold) {
//                        controller.returnCenter()
//                    } else {
//                        controller.swipeLeft()
//                    }
//                } else {
//                    if (controller.offsetX.value < controller.threshold) {
//                        controller.returnCenter()
//                    } else {
//                        controller.swipeRight()
//                    }
//                }
//            },
//            onDrag = { change, dragAmount ->
//                controller.scope.apply {
//                    launch {
//                        controller.offsetX.snapTo(controller.offsetX.value + dragAmount.x)
//                        controller.offsetY.snapTo(controller.offsetY.value + dragAmount.y)
//
//                        val targetRotation = normalize(
//                            controller.center.x,
//                            controller.right.x,
//                            abs(controller.offsetX.value),
//                            0f,
//                            10f
//                        )
//
//                        controller.rotation.snapTo(targetRotation * -controller.offsetX.value.sign)
//
//                        controller.scale.snapTo(
//                            normalize(
//                                controller.center.x,
//                                controller.right.x / 3,
//                                abs(controller.offsetX.value),
//                                0.8f
//                            )
//                        )
//                    }
//                }
//                change.consume()
//            }
//        )
//    }
//}
//
//private fun normalize(
//    min: Float,
//    max: Float,
//    v: Float,
//    startRange: Float = 0f,
//    endRange: Float = 1f
//): Float {
//    require(startRange < endRange) {
//        "Start range is greater than end range"
//    }
//    val value = v.coerceIn(min, max)
//    return (value - min) / (max - min) * (endRange + startRange) + startRange
//}