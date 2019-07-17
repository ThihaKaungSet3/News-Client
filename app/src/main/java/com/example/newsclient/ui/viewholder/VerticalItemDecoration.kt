package com.example.newsclient.ui.viewholder

import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class VerticalItemDecoration(divider : Drawable?) : RecyclerView.ItemDecoration() {

    private val divider : Drawable? = divider

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)

        if (parent.getChildAdapterPosition(view) == 0){
            outRect.top = divider?.intrinsicHeight!!
        }

    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)

        var dividerLeft = parent.width - 10  - parent.paddingLeft
        var dividerRight = parent.right - parent.paddingRight

        var childCount = parent.childCount

        for (i in 0 until childCount){
            val view = parent.getChildAt(i)

            val layoutparam  =  view.layoutParams as RecyclerView.LayoutParams

            val dividerTop = view.bottom + layoutparam.bottomMargin
            val dividerBottom = dividerTop + divider?.intrinsicHeight!!

            divider.bounds = Rect(dividerLeft,dividerTop,dividerRight,dividerBottom)
            divider.draw(c)
        }

    }

}