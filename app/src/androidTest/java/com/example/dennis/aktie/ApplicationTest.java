package com.example.dennis.aktie;

import android.test.ActivityInstrumentationTestCase2;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ActivityInstrumentationTestCase2<AktiendetailActivity> {
    private AktiendetailActivity myActivity;
    private MainActivity myMain;

    public ApplicationTest() {
        super(AktiendetailActivity.class);


    }

    protected void setUp() throws Exception {
        super.setUp();

        myActivity = getActivity();
    }

    //  @Test
    public void testMyActivity() {
        assertNull("meine AktiendeteilActivity ist nicht null", myActivity);
    }


}