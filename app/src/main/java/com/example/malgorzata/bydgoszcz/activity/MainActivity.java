package com.example.malgorzata.bydgoszcz.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.malgorzata.bydgoszcz.R;
import com.example.malgorzata.bydgoszcz.adapter.MyBottomPagerAdapter;
import com.example.malgorzata.bydgoszcz.adapter.MyCenterPagerAdapter;
import com.example.malgorzata.bydgoszcz.adapter.MyTopPagerAdapter;
import com.example.malgorzata.bydgoszcz.fragment.YouTubeFragment;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.viewpagerindicator.CirclePageIndicator;

public class MainActivity extends AppCompatActivity {

	private Toolbar mToolbar;

	private ViewPager mPager1;
	private ViewPager mPager2;
	private ViewPager mPager3;

	private MyTopPagerAdapter mTopPagerAdapter;
	private MyCenterPagerAdapter mCenterPagerAdapter;
	private MyBottomPagerAdapter mBottomPagerAdapter;

	private ImageView mAddress;
	private ImageView mPhone;
	private ImageView mMessage;
	private ImageView mWWW;

	private CirclePageIndicator mIndicatorTop;
	private CirclePageIndicator mIndicatorBottom;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
		ImageLoader.getInstance().init(config);

		setContentView(R.layout.scroll_view);

		YouTubeFragment youTubeFragment;
		FragmentManager supportFragmentManager = getSupportFragmentManager();

		if (savedInstanceState != null) {
			youTubeFragment = ((YouTubeFragment) supportFragmentManager.findFragmentById(R.id.youtube_fragment_container));
		} else {
			youTubeFragment = YouTubeFragment.newInstance("t99N223fqCo");

			supportFragmentManager.beginTransaction()
					.add(R.id.youtube_fragment_container, youTubeFragment)
					.commit();
		}

		initViews();

		enlargeIcon(mAddress);

		initPagers();

		initPagerAdapters();

		setAdapters();

		mIndicatorTop = (CirclePageIndicator)findViewById(R.id.indicator_top);
		mIndicatorTop.setViewPager(mPager1);

		mIndicatorBottom = (CirclePageIndicator)findViewById(R.id.indicator_bottom);
		mIndicatorBottom.setViewPager(mPager3);

		mPager1.setOffscreenPageLimit(3);
		mPager2.setOffscreenPageLimit(4);
		mPager3.setOffscreenPageLimit(3);

		mPager2.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
				switch (position) {
					case 0:
						resetViews(mAddress, mMessage, mPhone, mWWW);
						enlargeIcon(mAddress);
						break;
					case 1:
						resetViews(mAddress, mMessage, mPhone, mWWW);
						enlargeIcon(mPhone);
						break;
					case 2:
						resetViews(mAddress, mMessage, mPhone, mWWW);
						enlargeIcon(mMessage);
						break;
					case 3:
						resetViews(mAddress, mMessage, mPhone, mWWW);
						enlargeIcon(mWWW);
						break;
					default:
						resetViews(mAddress, mMessage, mPhone, mWWW);
						enlargeIcon(mAddress);
						break;
				}
			}

			@Override
			public void onPageSelected(int position) { }

			@Override
			public void onPageScrollStateChanged(int state) { }
		});

		mAddress.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mPager2.setCurrentItem(0);
			}
		});

		mPhone.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mPager2.setCurrentItem(1);
			}
		});

		mMessage.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mPager2.setCurrentItem(2);
			}
		});

		mWWW.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mPager2.setCurrentItem(3);
			}
		});

		initToolbar();
	}

	private void initViews() {
		mAddress = ((ImageView) findViewById(R.id.address_icon));
		mPhone = ((ImageView) findViewById(R.id.phone_icon));
		mMessage = ((ImageView) findViewById(R.id.email_icon));
		mWWW = ((ImageView) findViewById(R.id.www_icon));
	}

	private static void enlargeIcon(View v) {
		ObjectAnimator scaleUpX = ObjectAnimator.ofFloat(v, "scaleX", 1.25f);
		ObjectAnimator scaleUpY = ObjectAnimator.ofFloat(v, "scaleY", 1.25f);
		scaleUpX.setDuration(10);
		scaleUpY.setDuration(10);

		AnimatorSet scaleUp = new AnimatorSet();
		scaleUp.play(scaleUpX).with(scaleUpY);
		scaleUp.start();
	}

	private static void resetViews(ImageView icon1, ImageView icon2, ImageView icon3, ImageView icon4) {
		setNormalIconSize(icon1);
		setNormalIconSize(icon2);
		setNormalIconSize(icon3);
		setNormalIconSize(icon4);
	}

	private static void setNormalIconSize(View v) {
		ObjectAnimator scaleNormalX = ObjectAnimator.ofFloat(v, "scaleX", 1f);
		ObjectAnimator scaleNormalY = ObjectAnimator.ofFloat(v, "scaleY", 1f);
		scaleNormalX.setDuration(10);
		scaleNormalY.setDuration(10);

		AnimatorSet scaleNormal = new AnimatorSet();
		scaleNormal.play(scaleNormalX).with(scaleNormalY);
		scaleNormal.start();
	}

	private void setAdapters() {
		mPager1.setAdapter(mTopPagerAdapter);
		mPager2.setAdapter(mCenterPagerAdapter);
		mPager3.setAdapter(mBottomPagerAdapter);
	}

	private void initPagerAdapters() {
		mTopPagerAdapter = new MyTopPagerAdapter(getSupportFragmentManager());
		mCenterPagerAdapter = new MyCenterPagerAdapter(getSupportFragmentManager());
		mBottomPagerAdapter = new MyBottomPagerAdapter(getSupportFragmentManager());
	}

	private void initPagers() {
		mPager1 = (ViewPager) findViewById(R.id.pager_1);
		mPager2 = (ViewPager) findViewById(R.id.pager_2);
		mPager3 = (ViewPager) findViewById(R.id.pager_3);
	}

	private void initToolbar() {
		mToolbar = (Toolbar) findViewById(R.id.toolbar);

		mToolbar.setTitle("MIEJSCA");

		setSupportActionBar(mToolbar);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);

		mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				onBackPressed();
			}
		});
	}
}
