package com.example.malgorzata.bydgoszcz.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.malgorzata.bydgoszcz.R;
import com.nostra13.universalimageloader.core.ImageLoader;

public class BaseTopPagerFragment extends Fragment {

	private ImageLoader mImageLoader;
	private int mPage;

	private static final String PHOTO_URLS[] = {"http://kobi.blog.onet.pl/files/2014/03/bydgoszcz_by_majass.jpg",
												"http://bezprzewodnika.com//images/zdjecia/bydgoszcz/bydgoszcz_13.jpg",
												"http://bezprzewodnika.com//images/zdjecia/bydgoszcz/bydgoszcz_8.jpg"};

	public static BaseTopPagerFragment newInstance(int page) {
		BaseTopPagerFragment baseTopPagerFragment = new BaseTopPagerFragment();
		Bundle args = new Bundle();
		args.putInt("page", page);
		baseTopPagerFragment.setArguments(args);

		return baseTopPagerFragment;
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
		View view = inflater.inflate(R.layout.base_top_pager_fragment, container, false);
		ImageView imageView = ((ImageView) view.findViewById(R.id.image));

		switch (mPage) {
			case 0:
				mImageLoader.displayImage(PHOTO_URLS[0], imageView);
				break;
			case 1:
				mImageLoader.displayImage(PHOTO_URLS[1], imageView);
				break;
			case 2:
				mImageLoader.displayImage(PHOTO_URLS[2], imageView);
				break;
			default:
				mImageLoader.displayImage(PHOTO_URLS[0], imageView);
				break;
		}

		return view;
	}
}
