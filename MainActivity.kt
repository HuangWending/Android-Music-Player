import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var selectedMusicTextView: TextView
    private lateinit var selectedLyricsTextView: TextView
    private lateinit var playbackRateSeekBar: SeekBar
    private lateinit var volumeSeekBar: SeekBar
    private lateinit var addToPlaylistButton: Button
    private lateinit var showPlaylistButton: Button
    private lateinit var playButton: Button
    private lateinit var pauseButton: Button
    private lateinit var currentLyricsTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 初始化视图
        selectedMusicTextView = findViewById(R.id.tvSelectedMusic)
        selectedLyricsTextView = findViewById(R.id.tvSelectedLyrics)
        playbackRateSeekBar = findViewById(R.id.seekBarPlaybackRate)
        volumeSeekBar = findViewById(R.id.seekBarVolume)
        addToPlaylistButton = findViewById(R.id.btnAddToPlaylist)
        showPlaylistButton = findViewById(R.id.btnShowPlaylist)
        playButton = findViewById(R.id.btnPlay)
        pauseButton = findViewById(R.id.btnPause)
        currentLyricsTextView = findViewById(R.id.tvCurrentLyrics)

        // 初始化MediaPlayer
        mediaPlayer = MediaPlayer()

        // 设置倍数控制
        playbackRateSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val playbackRate = progress / 50f
                mediaPlayer.playbackParams = mediaPlayer.playbackParams.setSpeed(playbackRate)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        // 设置音量控制
        volumeSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val volume = progress / 100f
                mediaPlayer.setVolume(volume, volume)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        // 添加到播放列表按钮点击事件
        addToPlaylistButton.setOnClickListener {
            // 添加逻辑代码
        }

        // 显示播放列表按钮点击事件
        showPlaylistButton.setOnClickListener {
            // 添加逻辑代码
        }

        // 播放按钮点击事件
        playButton.setOnClickListener {
            // 添加逻辑代码
        }

        // 暂停按钮点击事件
        pauseButton.setOnClickListener {
            // 添加逻辑代码
        }
    }
}
