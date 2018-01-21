package com.sew.rewardsapp.enums;

import com.sew.rewardsapp.R;

/**
 * Created by siddharthkumar on 19/1/18.
 */

public enum ModelObject {

    SAVED_WATER_WAVE(R.string.saved_water_wave, R.layout.saved_water_wave),
    WATER_PROGRESS(R.string.water_progress_ring, R.layout.water_progress),
    POINT_COUNTER(R.string.points_counter, R.layout.point_counter);

    private int mTitleResId;
    private int mLayoutResId;

    ModelObject(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

}
