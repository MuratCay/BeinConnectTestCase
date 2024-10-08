package com.muratcay.beinconnecttestcase.feature.player

import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isVisible
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.muratcay.beinconnecttestcase.R
import com.muratcay.beinconnecttestcase.databinding.ActivityPlayerBinding
import com.muratcay.remote.models.Movie
import com.muratcay.remote.utils.RemoteConstants.VIDEO_URL
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlayerActivity : AppCompatActivity(), Player.Listener {

    private lateinit var binding: ActivityPlayerBinding
    private lateinit var simpleExoPlayer: SimpleExoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movie = intent.getSerializableExtra("movie") as Movie

        movie.title?.let { setupToolbar(it) }

        hideStatusBar()

        setupPlayer(movie)
    }

    private fun setupToolbar(title: String) {
        val toolbar = binding.root.findViewById<Toolbar>(R.id.exo_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setTitle(title)
            setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun hideStatusBar() {
        @Suppress("DEPRECATION") if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
    }

    private fun setupPlayer(movie: Movie) {
        simpleExoPlayer = SimpleExoPlayer.Builder(this).build()
        binding.exoPlayer.player = simpleExoPlayer

        val mediaItem = MediaItem.fromUri(VIDEO_URL)
        simpleExoPlayer.apply {
            setMediaItem(mediaItem)
            prepare()
            playWhenReady = true
            addListener(this@PlayerActivity)
        }
    }

    override fun onStop() {
        super.onStop()
        simpleExoPlayer.pause()
    }

    override fun onBackPressed() {
        showStatusBar()
        super.onBackPressed()
    }

    private fun showStatusBar() {
        @Suppress("DEPRECATION") if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.show(WindowInsets.Type.statusBars())
        } else {
            window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }
    }

    override fun onDestroy() {
        simpleExoPlayer.release()
        super.onDestroy()
    }

    override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
        binding.exoPb.isVisible = playbackState == Player.STATE_BUFFERING
        super.onPlayerStateChanged(playWhenReady, playbackState)
    }
}