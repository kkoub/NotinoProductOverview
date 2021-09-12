package cz.koubicl.example.ui.databinding

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("app:imageUrl")
fun downloadAndSetImage(view: ImageView, imageUrl: String) {
    val url = "https://i.postimg.cc/$imageUrl"
    val glideRequest =
        Glide
        .with(view.context)
        .load(url)
        .timeout(60000)

    glideRequest.into(view)
}

@BindingAdapter("app:visible")
fun setVisible(view: View, visible: Boolean?) {
    view.visibility = if (visible == true) View.VISIBLE else View.GONE
}
