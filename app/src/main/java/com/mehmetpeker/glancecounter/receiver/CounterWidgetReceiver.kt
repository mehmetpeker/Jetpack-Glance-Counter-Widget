package com.mehmetpeker.glancecounter.receiver

import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import com.mehmetpeker.glancecounter.ui.widget.CounterWidget

class CounterWidgetReceiver : GlanceAppWidgetReceiver(){
    override val glanceAppWidget: GlanceAppWidget = CounterWidget()

}
