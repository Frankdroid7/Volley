package com.example.franklin.trende

import android.accessibilityservice.AccessibilityService
import android.content.ContentValues.TAG
import android.view.accessibility.AccessibilityEvent
import android.text.TextUtils
import java.util.Collections.singletonList
import android.support.v4.view.MotionEventCompat.getSource
import android.util.Log
import android.view.accessibility.AccessibilityNodeInfo
import android.accessibilityservice.AccessibilityServiceInfo
import android.os.Build
import android.support.annotation.RequiresApi
import java.util.*


//class USSDService : AccessibilityService() {
//    override fun onInterrupt() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
//    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
//
//        Log.d(TAG, "onAccessibilityEvent")
//
//        val source = event?.source
//        /* if (event.getEventType() == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED && !event.getClassName().equals("android.app.AlertDialog")) { // android.app.AlertDialog is the standard but not for all phones  */
//        if (event?.eventType === AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED && !String.valueOf(event.className).contains("AlertDialog")) {
//            return
//        }
//        if (event?.eventType === AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED && (source == null || source.className != "android.widget.TextView")) {
//            return
//        }
//        if (event?.eventType === AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED && TextUtils.isEmpty(source!!.text)) {
//            return
//        }
//
//        val eventText: List<CharSequence>
//
//        if (event?.eventType === AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
//            eventText = event.text
//        } else {
//            eventText = Collections.singletonList(source!!.text)
//        }
//
//        val text = processUSSDText(eventText)
//
//        if (TextUtils.isEmpty(text)) return
//
//        // Close dialog
//        performGlobalAction(AccessibilityService.GLOBAL_ACTION_BACK) // This works on 4.1+ only
//
//        Log.d(TAG, text)
//        // Handle USSD response here
//
//    }
//
//
//    private fun processUSSDText(eventText: List<CharSequence>): String? {
//        for (s in eventText) {
//            val text = s.toString()
//            // Return text if text is the expected ussd response
//            if (true) {
//                return text
//            }
//        }
//        return null
//    }
//
//
//    override fun onServiceConnected() {
//        super.onServiceConnected()
//        Log.d(TAG, "onServiceConnected")
//        val info = AccessibilityServiceInfo()
//        info.flags = AccessibilityServiceInfo.DEFAULT
//        info.packageNames = arrayOf("com.android.phone")
//        info.eventTypes = AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED or AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED
//        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC
//        serviceInfo = info
//    }
//
//
//}