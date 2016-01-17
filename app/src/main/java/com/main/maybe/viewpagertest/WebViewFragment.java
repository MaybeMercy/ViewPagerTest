package com.main.maybe.viewpagertest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Maybe霏 on 2016/1/17.
 */
public class WebViewFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.web_fragment, container, false);
        TextView web = (TextView) root.findViewById(R.id.web);
        Bundle bundle = getArguments();
        if (bundle != null) {
            int position = bundle.getInt(MainActivity.POSITION);
            web.setText("I am " + position);
        }
        return root;
    }
}
