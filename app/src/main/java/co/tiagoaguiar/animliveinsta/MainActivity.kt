package co.tiagoaguiar.animliveinsta

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

  private val handler = Handler()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    handler.post(runnable)
  }

  private val runnable: Runnable
    get() = Runnable {
      anim_1.animate()
        .scaleX(2f)
        .scaleY(2f)
        .alpha(.1f)
        .setDuration(950)
        .withEndAction {
          with(anim_1) {
            scaleX = .3f
            scaleY = .3f
            alpha = 1f
          }
        }

     anim_2.animate()
        .scaleX(1.5f)
        .scaleY(1.5f)
        .alpha(.2f)
        .setDuration(850)
        .withEndAction {
          with(anim_2) {
            scaleX = .7f
            scaleY = .7f
            alpha = 1f
          }
        }

      val scaleDown: ObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(
        me_card,
        PropertyValuesHolder.ofFloat("scaleX", .7f),
        PropertyValuesHolder.ofFloat("scaleY", .7f)
      )
      scaleDown.duration = 500
      scaleDown.repeatCount = ObjectAnimator.INFINITE
      scaleDown.repeatMode = ObjectAnimator.REVERSE

      scaleDown.start()

      handler.postDelayed(runnable, 1000)
    }

}
