package com.example.android.teatime;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Gabriel on 29/11/2017.
 */

@RunWith(AndroidJUnit4.class)
public class OrderActivityBasicTest {

    @Rule public ActivityTestRule<OrderActivity> mActivityTestRule
            = new ActivityTestRule<>(OrderActivity.class);



    @Test
    public void clickDecrementButton_ChangesQuantityAndCost() {
        //Verify the original values
        onView(withId(R.id.quantity_text_view)).check(matches(withText("0")));
        onView(withId(R.id.cost_text_view)).check(matches(withText("$0.00")));

        // Click on decrement button
        onView((withId(R.id.decrement_button))).perform(click());

        //Verify the values has not changed
        onView(withId(R.id.quantity_text_view)).check(matches(withText("0")));
        onView(withId(R.id.cost_text_view)).check(matches(withText("$0.00")));

    }



    @Test
    public void clickIncrementButton_ChangesQuantityAndCost(){
        //1. Fin the View and 2. Perform action on the view
        onView((withId(R.id.increment_button))).perform(click());

        //3. Check if the view does what you expected
        onView(withId(R.id.quantity_text_view)).check(matches(withText("1")));
        onView(withId(R.id.cost_text_view)).check(matches(withText("$5.00")));
    }
}
