package sanity

import android.app.Application
import android.content.Context
import android.content.Intent
import android.util.Log


import androidx.test.uiautomator.*
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith

import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Before
import androidx.test.uiautomator.UiDevice
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.equalTo


private const val BASIC_SAMPLE_PACKAGE = "com.example.sampleapplication"
private const val LAUNCH_TIMEOUT = 5000L
private const val STRING_TO_BE_TYPED = "UiAutomator"

@RunWith(AndroidJUnit4::class)

class TestUIAutomationOnSeetest {


    @Test
    fun startMainActivityFromHomeScreen() {
        // Initialize UiDevice instance
        val device: UiDevice  = UiDevice.getInstance(InstrumentationRegistry
            .getInstrumentation())

        // Start from the home screen
        device.pressHome()
        // Wait for launcher
        val launcherPackage: String = device.launcherPackageName

        assertThat(launcherPackage, notNullValue())
        device.wait(
            Until.hasObject(By.pkg(launcherPackage).depth(0)),
            LAUNCH_TIMEOUT
        )

        // Launch the app
        val context = ApplicationProvider.getApplicationContext<Context>()
        val intent = context.packageManager.getLaunchIntentForPackage(
            BASIC_SAMPLE_PACKAGE).apply {
            // Clear out any previous instances
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        context.startActivity(intent)
        device.wait(
            Until.hasObject(By.pkg(BASIC_SAMPLE_PACKAGE).depth(0)),
            LAUNCH_TIMEOUT
        )
        assertThat(device, notNullValue())

        val loginButton=device!!
            .wait(
                Until.findObject(By.res(BASIC_SAMPLE_PACKAGE, "button4")),
                5000 /* wait 500ms */
            )

        loginButton.click()



        device.pressBack()



    }

}
