package com.lbg.testapp.presentation.ui.userdetail

import android.os.Bundle
import android.view.MenuItem
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.BounceInterpolator
import android.view.animation.ScaleAnimation
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.doOnPreDraw
import androidx.databinding.DataBindingUtil
import com.lbg.testapp.R
import com.lbg.testapp.presentation.ui.userlist.UserListActivity.Companion.USER_ID
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber
import com.lbg.testapp.databinding.ActivityUserDetailBinding as Binding

/**
 * Created by Siva kumar boddu 
 */
class UserDetailActivity : AppCompatActivity() {

    private val binding by lazy {
        DataBindingUtil.setContentView<Binding>(this, R.layout.activity_user_detail)
    }

    private val viewModel by viewModel<UserDetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportPostponeEnterTransition()

        intent.extras?.let {
            if(intent.hasExtra(USER_ID)) {
                viewModel.getUser(it.getLong(USER_ID))
            }
        }

        this.let { activity ->
            binding.apply {
                lifecycleOwner = activity
                viewModel = activity.viewModel
            }
        }

        setupToolbar()
        observeError()
        viewModel.user.observe(this) {
            (window.decorView as ViewGroup).doOnPreDraw {
                supportStartPostponedEnterTransition()
            }
        }

        binding.includeContent.buttonFavorite.setOnCheckedChangeListener { buttonView, isChecked ->
            buttonView.startAnimation(buildAnimation())
            viewModel.setFavourite(viewModel.user.value?.id, isChecked)
        }
    }

    private fun buildAnimation() : ScaleAnimation {
        val scaleAnimation = ScaleAnimation(0.7f, 1.0f, 0.7f, 1.0f, Animation.RELATIVE_TO_SELF, 0.7f, Animation.RELATIVE_TO_SELF, 0.7f)
        scaleAnimation.duration = 500
        scaleAnimation.interpolator = BounceInterpolator()
        return scaleAnimation
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) finish()
        return super.onOptionsItemSelected(item)
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = null
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun observeError() {
        viewModel.error.observe(this) {
            Timber.e(it)
        }
    }

}
