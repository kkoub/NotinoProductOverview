package cz.koubicl.notino.ui.databinding

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

@BindingAdapter("app:imageUrl")
fun downloadAndSetImage(view: ImageView, imageUrl: String) {
    val url = "https://i.notino.com/detail_zoom/$imageUrl"

    val glideRequest =
        Glide
        .with(view.context)
        .load(url)
        .timeout(60000)
        .listener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                return false
                }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                return false
            }
        })
//        .placeholder(placeholderImage)
//        .error(placeholderImage)

    glideRequest.into(view)
}
