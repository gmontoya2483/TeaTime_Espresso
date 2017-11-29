# TeaTime Code

This is a exercise repository for the TeaTime example app which is part of Udacity's Advanced Android course. TeaTime is a mock tea ordering app that demonstrates various uses of the Espresso Testing framework (i.e. Views, AdapterViews, Intents, IdlingResources). You can learn more about how to use this repository [here](https://classroom.udacity.com/courses/ud857/lessons/8b2a9d63-0ff5-48ff-90d3-a9855b701dae/concepts/41b82e3c-2797-46e5-8a66-684098ca8cbb).

## Adding the Gradle application dependencies

```gradle
    dependencies {
        compile 'com.android.support:design:26.1.0'
        compile 'com.android.support:support-annotations:27.0.1'
        compile 'com.google.android.gms:play-services-appindexing:9.8.0'
        androidTestCompile 'junit:junit:4.12'


        //Testing-only dependencies
        androidTestCompile 'com.android.support:support-annotations:27.0.1'
        androidTestCompile 'com.android.support.test.espresso:espresso-core:3.0.1'

    }
```

**Note:** ```compile 'com.android.support:support-annotations:27.0.1'``` and ```androidTestCompile 'com.android.support:support-annotations:27.0.1'``` must have the same versions.


## Creating a simple user Interface (UI) test

1. Create a new class file within the *androidTest* folder (Instrumented test)

![Screenshot1](screenshots/test_cases_folder.png)

Name the file correctly using the following convention ```OrderActivityBasicTest```, that means that this class will be used for performing basic teston the ```OrderActivity```class.
The *Test* at the end of the name shows others developers that the class is just for testing proposals.

2. Start off this file with the ```@RunWith(AndroidJUnit4.class)```

```java
    import android.support.test.runner.AndroidJUnit4;

    import org.junit.runner.RunWith;

    @RunWith(AndroidJUnit4.class)
    public class OrderActivityBasicTest {

    }
```

**NOTE:** This line makes the *AndroidStudio* know that this class have to be executed with the ***AndroidJUnit4***

3. Add the ```ActivityTestRule``` in the body of the test

```java
    @RunWith(AndroidJUnit4.class)
    public class OrderActivityBasicTest {

        @Rule public ActivityTestRule<OrderActivity> mActivityTestRule = new ActivityTestRule<>(OrderActivity.class);

    }
```

**NOTE** The ```ActivityTestRule``` provides functional test for a specific single Activity. In this case for the ```OrderActivity.class```

4. Add the tests

```java
    @RunWith(AndroidJUnit4.class)
    public class OrderActivityBasicTest {

        @Rule public ActivityTestRule<OrderActivity> mActivityTestRule
                = new ActivityTestRule<>(OrderActivity.class);


         @Test
            public void clickIncrementButton_ChangesQuantityAndCost(){
                //1. Fin the View and 2. Perform action on the view
                onView((withId(R.id.increment_button))).perform(click());

                //3. Check if the view does what you expected
                onView(withId(R.id.quantity_text_view)).check(matches(withText("1")));
                onView(withId(R.id.cost_text_view)).check(matches(withText("$5.00")));
            }

        @Test
         public void test2(){
             //1. Fin the View
             //2. Perform action on the view
             //3. Check if the view does what you expected

         }

    }

```

5. Run the test



## General steps of Espresso View Testing

1. Find the view
2. Perform action on the view
3. Check if the view does what you expected

## References
[Testing Apps on Android - Espresso](https://developer.android.com/training/testing/espresso/index.html)

[Android Espresso cheat sheet](https://developer.android.com/training/testing/espresso/cheat-sheet.html)

