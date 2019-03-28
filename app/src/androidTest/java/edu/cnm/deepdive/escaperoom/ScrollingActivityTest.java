package edu.cnm.deepdive.escaperoom;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ScrollingActivityTest {

  @Rule
  public ActivityTestRule<ScrollingActivity> activityTestRule =
          new ActivityTestRule<>(ScrollingActivity.class);
  @Test
  public void NavigateToHistory() {
    //Click on history item in toolbar

    openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());

    onView(withText("History"))
        .perform(click());

    //Make sure fragment is loaded
    onView(withId(R.id.history_list))
        .check(matches(isDisplayed()));
  }
}