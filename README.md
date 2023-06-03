# Android-Music-Player
Kotlin和XML-音乐播放器安卓(Android)程序
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">
  这行代码定义了一个垂直方向的线性布局，并设置其宽度和高度为填满父容器。tools:context属性指定了与该布局文件相关联的活动（Activity）的上下文。
  <!-- 音乐文件选择和显示 -->
<TextView
    android:id="@+id/tvSelectedMusic"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="选择的音乐文件："
    android:textSize="18sp" />
  这段代码创建了一个文本视图（TextView），用于显示选择的音乐文件。android:id属性定义了该视图的唯一标识符，可以在代码中使用。android:layout_width和android:layout_height属性指定了视图的宽度和高度。android:text属性设置了文本内容，而android:textSize属性设置了文本的大小。
  <!-- 歌词选择和显示 -->
<TextView
    android:id="@+id/tvSelectedLyrics"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="选择的歌词："
    android:textSize="18sp" />
  这段代码创建了另一个文本视图，用于显示选择的歌词。它具有类似于上一个文本视图的属性和设置。
  <!-- 倍数控制 -->
<SeekBar
    android:id="@+id/seekBarPlaybackRate"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:progress="50"
    android:max="100" />
  这段代码创建了一个滑动条（SeekBar），用于控制音乐播放的倍数。android:id属性为滑动条指定了唯一标识符。android:layout_width属性设置滑动条的宽度为填满父容器。android:progress属性设置滑动条的初始进度，android:max属性设置滑动条的最大值。
  <!-- 音量控制 -->
<SeekBar
    android:id="@+id/seekBarVolume"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:progress="50"
    android:max="100" />
  这段代码创建了另一个滑动条，用于控制音量大小。它具有类似于前一个滑动条的属性和设置。
  <!-- 播放列表管理 -->
<Button
    android:id="@+id/btnAddToPlaylist"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="添加到播放列表" />

<Button
    android:id="@+id/btnShowPlaylist"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="显示播放列表" />
  这段代码创建了两个按钮，一个用于将音乐添加到播放列表，另一个用于显示播放列表。每个按钮都具有唯一的android:id属性和指定的文本内容。<!-- 播放和暂停按钮 -->
<Button
    android:id="@+id/btnPlay"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="播放" />

<Button
    android:id="@+id/btnPause"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="暂停" />
  这段代码创建了两个按钮，一个用于播放音乐，另一个用于暂停音乐。它们的属性与前面的按钮相似。
  <!-- 显示当前歌词 -->
<TextView
    android:id="@+id/tvCurrentLyrics"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="当前歌词："
    android:textSize="18sp" />
  这段代码创建了一个文本视图，用于显示当前的歌词。它具有类似于前面的文本视图的属性和设置。
  import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
  这段代码导入所需的Android类和库，包括MediaPlayer音频播放器类、Bundle数据传递类、Button按钮类、SeekBar滑动条类和TextView文本视图类等。AppCompatActivity是一个为了向后兼容而提供的基类，用于创建应用程序的活动。
  class MainActivity : AppCompatActivity() {
这段代码定义了名为MainActivity的类，它是AppCompatActivity类的子类，用于表示应用程序的主活动。
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
这段代码声明了一些私有属性，用于引用布局文件中的视图元素，例如MediaPlayer对象、TextView、SeekBar和Button等。
 override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
这段代码是MainActivity类的onCreate方法的重写。当活动创建时，会调用该方法。在该方法中，首先调用父类的onCreate方法，然后通过setContentView方法将布局文件activity_main与该活动关联起来。
  selectedMusicTextView = findViewById(R.id.tvSelectedMusic)
selectedLyricsTextView = findViewById(R.id.tvSelectedLyrics)
playbackRateSeekBar = findViewById(R.id.seekBarPlaybackRate)
volumeSeekBar = findViewById(R.id.seekBarVolume)
addToPlaylistButton = findViewById(R.id.btnAddToPlaylist)
showPlaylistButton = findViewById(R.id.btnShowPlaylist)
playButton = findViewById(R.id.btnPlay)
pauseButton = findViewById(R.id.btnPause)
currentLyricsTextView = findViewById(R.id.tvCurrentLyrics)
这段代码通过findVimediaPlayer = MediaPlayer()
ewById方法初始化之前声明的属性，将它们与布局文件中对应的视图元素进行关联。
  这段代码创建一个MediaPlayer对象，并将其赋值给之前声明的mediaPlayer属性。
  playbackRateSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        val playbackRate = progress / 50f
        mediaPlayer.playbackParams = mediaPlayer.playbackParams.setSpeed(playbackRate)
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {}

    override fun onStopTrackingTouch(seekBar: SeekBar?) {}
})
这段代码为倍数控制的滑动条playbackRateSeekBar设置了一个OnSeekBarChangeListener监听器。在滑动条的值发生改变时，将触发相应的回调方法。在onProgressChanged方法中，根据滑动条的值计算播放速率，并通过MediaPlayer的playbackParams属性设置播放速率。
  volumeSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        val volume = progress / 100f
        mediaPlayer.setVolume(volume, volume)
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {}

    override fun onStopTrackingTouch(seekBar: SeekBar?) {}
})
这段代码为音量控制的滑动条volumeSeekBar设置了一个OnSeekBarChangeListener监听器。在滑动条的值发生改变时，将触发相应的回调方法。在onProgressChanged方法中，根据滑动条的值计算音量，并通过MediaPlayer的setVolume方法设置音量。
  addToPlaylistButton.setOnClickListener {
    // 添加逻辑代码
}
这段代码为添加到播放列表按钮addToPlaylistButton设置了一个点击事件监听器。当按钮被点击时，将执行相关的逻辑代码。
  showPlaylistButton.setOnClickListener {
    // 添加逻辑代码
}这段代码为显示播放列表按钮showPlaylistButton设置了一个点击事件监听器。当按钮被点击时，将执行相关的逻辑代码。
  
playButton.setOnClickListener {
    // 添加逻辑代码
}
这段代码为播放按钮playButton设置了一个点击事件监听器。当按钮被点击时，将执行相关的逻辑代码。
  pauseButton.setOnClickListener {
    // 添加逻辑代码
}
这段代码为暂停按钮pauseButton设置了一个点击事件监听器。当按钮被点击时，将执行相关的逻辑代码。
  
  
  
