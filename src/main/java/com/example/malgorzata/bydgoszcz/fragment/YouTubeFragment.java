package com.example.malgorzata.bydgoszcz.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.malgorzata.bydgoszcz.R;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

public class YouTubeFragment extends YouTubePlayerSupportFragment {

	private YouTubePlayer mPlayer;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.youtube_fragment, container, false);
	}

	public static YouTubeFragment newInstance(String url) {

		YouTubeFragment youTubeFragment = new YouTubeFragment();

		Bundle bundle = new Bundle();
		bundle.putString("url", url);

		youTubeFragment.setArguments(bundle);

		return youTubeFragment;
	}

	private void init() {

		initialize("AIzaSyADsbwFVcSU2F4U91ZtQWfj9g5-7uY3PG0", new YouTubePlayer.OnInitializedListener() {

			@Override
			public void onInitializationFailure(YouTubePlayer.Provider arg0, YouTubeInitializationResult arg1) { }

			@Override
			public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
				mPlayer = player;
				if (!wasRestored) {
					mPlayer.loadVideo("t99N223fqCo");
					mPlayer.play();
				}
			}

		});
	}
}


