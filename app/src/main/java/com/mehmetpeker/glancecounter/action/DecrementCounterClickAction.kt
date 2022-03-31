package com.mehmetpeker.glancecounter.action

import android.content.Context
import androidx.glance.GlanceId
import androidx.glance.action.ActionParameters
import androidx.glance.appwidget.action.ActionCallback
import androidx.glance.appwidget.state.updateAppWidgetState
import androidx.glance.state.PreferencesGlanceStateDefinition
import com.mehmetpeker.glancecounter.ui.widget.CounterWidget

class DecrementCounterClickAction : ActionCallback {
    override suspend fun onRun(context: Context, glanceId: GlanceId, parameters: ActionParameters) {
        updateAppWidgetState(context, PreferencesGlanceStateDefinition, glanceId) {
            it.toMutablePreferences()
                .apply {
                    val counter = this[CounterWidget.COUNTER_WIDGET_COUNT_KEY] ?: 0
                    this[CounterWidget.COUNTER_WIDGET_COUNT_KEY] = counter - 1
                }
        }
        CounterWidget().update(context, glanceId)
    }
}