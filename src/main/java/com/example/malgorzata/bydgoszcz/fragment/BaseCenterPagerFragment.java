package com.example.malgorzata.bydgoszcz.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.malgorzata.bydgoszcz.R;

public class BaseCenterPagerFragment extends Fragment {

	private int mPage;

	public static Fragment newInstance(int page) {
		BaseCenterPagerFragment baseCenterPagerFragment = new BaseCenterPagerFragment();
		Bundle args = new Bundle();
		args.putInt("page", page);
		baseCenterPagerFragment.setArguments(args);

		return baseCenterPagerFragment;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mPage = getArguments().getInt("page");
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.base_center_pager_fragment, container, false);

		TextView mTextView = ((TextView) view.findViewById(R.id.text));
		Button mButton = ((Button) view.findViewById(R.id.button));

		switch (mPage) {
			case 0:
				mTextView.setText(R.string.address);
				mButton.setText(R.string.map);
				break;
			case 1:
				mTextView.setText(R.string.phone_number);
				mButton.setText(R.string.call);
				break;
			case 2:
				mTextView.setText(R.string.email);
				mButton.setWidth(325);
				mButton.setText(R.string.send_email);
				break;
			case 3:
				mTextView.setText(R.string.www);
				mButton.setVisibility(View.GONE);
		}

		return view;
	}
}
