package com.example.malgorzata.bydgoszcz.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.malgorzata.bydgoszcz.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

public class BaseBottomPagerFragment extends Fragment {

	private int mPage;
	private ImageLoader mImageLoader;

	private static final String PHOTO_URLS[] = {"http://www.globtroter.pl/zdjecia/polska/b211888_polska_kujawsko_pomorskie_bydgoszcz.jpg"};

	public static BaseBottomPagerFragment newInstance(int page) {
		BaseBottomPagerFragment baseBottomPagerFragment = new BaseBottomPagerFragment();
		Bundle args = new Bundle();
		args.putInt("page", page);
		baseBottomPagerFragment.setArguments(args);

		return baseBottomPagerFragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mImageLoader = ImageLoader.getInstance();
		mPage = getArguments().getInt("page");
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.base_bottom_pager_fragment, container, false);
		ImageView imageView = ((ImageView) view.findViewById(R.id.image));

		mImageLoader.displayImage(PHOTO_URLS[0], imageView);

		return view;
	}
}
