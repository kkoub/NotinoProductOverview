package cz.koubicl.notino.ui.views

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import cz.koubicl.notino.R

class ProductRatingView : LinearLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.ProductRatingView)

        drawableFilled = attributes.getDrawable(R.styleable.ProductRatingView_drawableFilled)
        drawableEmpty = attributes.getDrawable(R.styleable.ProductRatingView_drawableEmpty)
        maxRating = attributes.getInt(R.styleable.ProductRatingView_maxRating, MAX_RATING)
        rating = attributes.getInt(R.styleable.ProductRatingView_rating, 0)
        attributes.recycle()
    }

    companion object {
        private const val MAX_RATING = 5
    }

    private var view: LinearLayout

    var drawableFilled: Drawable? = ContextCompat.getDrawable(context, R.drawable.ic_star)
    var drawableEmpty: Drawable? = ContextCompat.getDrawable(context, R.drawable.ic_star_empty)
    var maxRating: Int? = MAX_RATING
    var rating: Int? = 0
        set(value) {
            field = value
            setRating()
        }

    init {
        inflate(context, R.layout.item_product_rating, this)
        view = findViewById(R.id.notino_product_rating_stars_view)
    }

    private fun setRating() {
        for(i in 1..rating!!) {
            val starImageView = ImageView(context)
            starImageView.setImageDrawable(drawableFilled)

            view.addView(starImageView)
        }
        for(x in rating!! + 1..maxRating!!) {
            val starImageView = ImageView(context)
            starImageView.setImageDrawable(drawableEmpty)

            view.addView(starImageView)
        }
    }
}