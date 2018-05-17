package com.ravi.daggerdemos;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ravi.daggerdemos.utils.LogUtils;

import java.util.Random;

import javax.inject.Inject;

public class DaggerDemosFragment extends Fragment implements View.OnClickListener {

    private TextView mDaggerTxv;
    private final Random RANDOM = new Random();

    private final String[] RANDOM_TEXT = {"OOPS without SOLID principles", "One of them is Inversion of Control",
            "Rise of Dependency Injection", "DI Frameworks were lesser famous back then",
            "Dagger was a sweet surprise after Guice's impressions",
            "And then Dagger 2 was phenomenal in revolutionizing DI"};

    @Inject
    LogUtils mLogUtils;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dagger_demos, container, false);
        init(view);
        return view;
    }

    private void init(View iView) {
        // Inject Dependency
        DaggerDemosApplication.getApp().getServiceComponent().inject(this);

        mLogUtils.logD("Init content view for fragment");

        mDaggerTxv = iView.findViewById(R.id.dagger_txv);
        final Button daggerBtn = iView.findViewById(R.id.dagger_btn);

        mDaggerTxv.setText(RANDOM_TEXT[0]);
        daggerBtn.setOnClickListener(this);

        mLogUtils.showToast("Fragment setup completed");
    }

    @Override
    public void onClick(View iView) {
        // Update the text
        mDaggerTxv.setText(RANDOM_TEXT[RANDOM.nextInt(6)]);
    }
}
