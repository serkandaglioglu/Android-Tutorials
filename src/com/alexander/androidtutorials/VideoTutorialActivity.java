package com.alexander.androidtutorials;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoTutorialActivity extends Activity
{
	VideoView	videoView;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video_tutorial);

		videoView = (VideoView) findViewById(R.id.video_player);
		videoView.setVideoURI(Uri.parse("http://www.youtube.com/watch?v=AoS9VTSiwBA"));
		videoView.setMediaController(new MediaController(this));
		videoView.requestFocus();
		videoView.start();

		videoView.setOnCompletionListener(new OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp)
			{
				Toast.makeText(getApplicationContext(), "Video Sonlandı", Toast.LENGTH_LONG).show();

			}
		});

	}
}
