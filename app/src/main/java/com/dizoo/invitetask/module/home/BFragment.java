package com.dizoo.invitetask.module.home;

import android.view.View;
import android.widget.TextView;

import com.dizoo.baselibrary.base.BaseFragment;
import com.dizoo.invitetask.R;

public class BFragment extends BaseFragment {

    private TextView tv;




    @Override
    protected int layoutId() {
        return R.layout.fragment_a;
    }

    @Override
    protected void init(View rootView) {
        tv = rootView.findViewById(R.id.tv);
        tv.setText(this.getClass().toString());
    }

    @Override
    protected void initData() throws NullPointerException {

    }
}
