package com.wjdgh823.audiorecorder

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageButton
import androidx.appcompat.widget.AppCompatImageButton

class RecordButton (
    context: Context,
    attrs: AttributeSet
): AppCompatImageButton(context, attrs) {

    // 각 상황에 맞게 아이콘을 바꿀 수 있게 아이콘을 상태처리를 한다.

    fun updateIconWithState(state: State) {
        when (state) {
            State.BEFORE_RECORDING -> {
                setImageResource(R.drawable.ic_record)
            }
            State.ON_RECORDING -> {
                setImageResource(R.drawable.ic_stop)
            }
            State.AFTER_RECODING -> {
                setImageResource(R.drawable.ic_play)
            }
            State.ON_PLAYING -> {
                setImageResource(R.drawable.ic_stop)
            }
        }
    }
}