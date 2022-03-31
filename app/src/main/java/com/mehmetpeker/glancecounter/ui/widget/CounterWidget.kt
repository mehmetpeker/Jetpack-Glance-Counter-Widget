package com.mehmetpeker.glancecounter.ui.widget

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.glance.GlanceModifier
import androidx.glance.Image
import androidx.glance.ImageProvider
import androidx.glance.action.clickable
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.action.actionRunCallback
import androidx.glance.appwidget.appWidgetBackground
import androidx.glance.appwidget.background
import androidx.glance.appwidget.cornerRadius
import androidx.glance.currentState
import androidx.glance.layout.*
import androidx.glance.state.GlanceStateDefinition
import androidx.glance.state.PreferencesGlanceStateDefinition
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextAlign
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider
import com.mehmetpeker.glancecounter.R
import com.mehmetpeker.glancecounter.action.DecrementCounterClickAction
import com.mehmetpeker.glancecounter.action.IncrementCounterClickAction
import com.mehmetpeker.glancecounter.ui.widget.CounterWidget.Companion.COUNTER_WIDGET_COUNT_KEY

class CounterWidget : GlanceAppWidget() {
    companion object {
        val COUNTER_WIDGET_COUNT_KEY = intPreferencesKey("counter")
    }

    override val stateDefinition: GlanceStateDefinition<*> = PreferencesGlanceStateDefinition

    @Composable
    override fun Content() {
        CounterWidgetContent(
            modifier = GlanceModifier
                .fillMaxSize()
                .background(
                    day = Color.Blue,
                    night = Color.DarkGray
                )
                .appWidgetBackground()
                .cornerRadius(16.dp)
                .padding(8.dp),
        )
    }

}

@Composable
fun CounterWidgetContent(
    modifier: GlanceModifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val counter = currentState(COUNTER_WIDGET_COUNT_KEY) ?: 0

        Column {
            CounterWidgetText(
                counter = counter, modifier = GlanceModifier
                    .fillMaxWidth()
                    .defaultWeight()
            )
            CounterButtonLayout(
                modifier = GlanceModifier
                    .fillMaxWidth()
                    .defaultWeight()
            )
        }
    }
}

@Composable
fun CounterButtonLayout(
    modifier: GlanceModifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            provider = ImageProvider(
                resId = R.drawable.ic_baseline_exposure_neg_1_24
            ),
            contentDescription = null,
            modifier = GlanceModifier
                .clickable(
                    onClick = actionRunCallback<DecrementCounterClickAction>()
                )
                .defaultWeight()
        )
        Image(
            provider = ImageProvider(
                resId = R.drawable.ic_baseline_exposure_plus_1_24
            ),
            contentDescription = null,
            modifier = GlanceModifier
                .clickable(
                    onClick = actionRunCallback<IncrementCounterClickAction>()
                )
                .defaultWeight()
        )
    }

}

@Composable
fun CounterWidgetText(
    counter: Int,
    modifier: GlanceModifier
) {
    Text(
        text = counter.toString(),
        modifier = modifier,
        style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            color = ColorProvider(
                color = Color.White
            )
        ),
    )
}

