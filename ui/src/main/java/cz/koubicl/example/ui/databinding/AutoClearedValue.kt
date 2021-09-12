package cz.koubicl.example.ui.databinding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

/**
 * A value holder that automatically clears the reference if the Fragment's view is destroyed.
 *
 * @param callback optional callback to perform additional actions on value clear
 */
class AutoClearedValue<VALUE>(fragment: Fragment, private var value: VALUE?, callback: (() -> Unit)?) {

    constructor(fragment: Fragment, value: VALUE?) : this(fragment, value, null)

    init {
        val fragmentManager = fragment.childFragmentManager
        fragmentManager.registerFragmentLifecycleCallbacks(
            object : FragmentManager.FragmentLifecycleCallbacks() {
                override fun onFragmentViewDestroyed(fm: FragmentManager, f: Fragment) {
                    if (f === fragment) {
                        callback?.invoke()
                        this@AutoClearedValue.value = null
                        fragmentManager.unregisterFragmentLifecycleCallbacks(this)
                    }
                }
            }, false)
    }

    fun get(): VALUE? {
        return value
    }

}