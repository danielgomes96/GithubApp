package com.daniel.githubapp.widget

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.constraintlayout.widget.Group
import androidx.core.content.ContextCompat
import com.daniel.githubapp.commons.extension.visible

class ErrorView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var errorImageView: ImageView
    private var errorTitleTextView: TextView
    private var errorBodyTextView: TextView
    private var errorActionButton: Button
    private var errorActionText: TextView
    private var errorActionGroup: Group

    init {
        LayoutInflater.from(context).inflate(R.layout.error_view, this, true)
        errorImageView = findViewById(R.id.generic_error_img)
        errorTitleTextView = findViewById(R.id.generic_error_title_txt)
        errorBodyTextView = findViewById(R.id.generic_error_body_txt)
        errorActionButton = findViewById(R.id.generic_error_action_btn)
        errorActionText = findViewById(R.id.generic_error_action_txt)
        errorActionGroup = findViewById(R.id.generic_error_action_group)
    }

    fun setImageId(resourceId: Int) {
        errorImageView.background = ContextCompat.getDrawable(context, resourceId)
    }

    fun setTitleText(@StringRes textId: Int) {
        errorTitleTextView.text = context.getString(textId)
    }

    fun setBodyText(@StringRes textId: Int) {
        errorBodyTextView.text = context.getString(textId)
    }

    fun setButtonBehavior(@StringRes textId: Int, callback: (() -> Unit)) {
        errorActionGroup.visible()
        errorActionText.text = context.getString(textId)
        errorActionButton.setOnClickListener {
            callback.invoke()
        }
    }
}
