/*
 * SPDX-License-Identifier: GPL-3.0-or-later
 *
 * This file is part of XiaomiHelper project
 * Copyright (C) 2023 HowieHChen, howie.dev@outlook.com

 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */


package dev.lackluster.mihelper.hook.rules.miuihome.gesture

import android.content.Context
import android.os.SystemClock
import android.view.MotionEvent
import android.view.ViewConfiguration
import kotlin.math.abs

class DoubleTapController internal constructor(mContext: Context)  {
    private val maxDuration: Long = 500
    private var mActionDownRawX: Float = 0f
    private var mActionDownRawY: Float = 0f
    private var mClickCount: Int = 0
    private var mFirstClickRawX: Float = 0f
    private var mFirstClickRawY: Float = 0f
    private var mLastClickTime: Long = 0
    private val mTouchSlop: Float = (ViewConfiguration.get(mContext).scaledTouchSlop * 2).toFloat()

    fun isDoubleTapEvent(motionEvent: MotionEvent): Boolean {
        val action = motionEvent.actionMasked
        return when(action) {
            MotionEvent.ACTION_DOWN -> {
                mActionDownRawX = motionEvent.rawX
                mActionDownRawY = motionEvent.rawY
                false
            }
            MotionEvent.ACTION_UP -> {
                val rawX = motionEvent.rawX
                val rawY = motionEvent.rawY
                if (abs(rawX - mActionDownRawX) <= mTouchSlop && abs(rawY - mActionDownRawY) <= mTouchSlop) {
                    if (
                        SystemClock.elapsedRealtime() - mLastClickTime > maxDuration ||
                        rawY - mFirstClickRawY > mTouchSlop ||
                        rawX - mFirstClickRawX > mTouchSlop
                    ) {
                        mClickCount = 0
                    }
                    mClickCount++
                    if (mClickCount == 1) {
                        mFirstClickRawX = rawX
                        mFirstClickRawY = rawY
                        mLastClickTime = SystemClock.elapsedRealtime()
                        return false
                    } else if (
                        abs(rawY - mFirstClickRawY) <= mTouchSlop &&
                        abs(rawX - mFirstClickRawX) <= mTouchSlop &&
                        SystemClock.elapsedRealtime() - mLastClickTime <= maxDuration
                    ) {
                        mClickCount = 0
                        return true
                    }
                }
                mClickCount = 0
                false
            }
            else -> false
        }
    }
}