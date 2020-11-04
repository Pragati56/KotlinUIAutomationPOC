package com.example.sampleapplication




import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
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
import androidx.test.uiautomator.UiSelector
import androidx.test.uiautomator.UiObject
import org.junit.Assert


private const val BASIC_SAMPLE_PACKAGE = "com.example.sampleapplication"
private const val LAUNCH_TIMEOUT = 5000L
private const val STRING_TO_BE_TYPED = "UiAutomator"

@RunWith(AndroidJUnit4::class)
class TestUIAppwithSeetest{


    @Test
    fun startSeetestActivityFromHomeScreenSeetest() {
        // Initialize UiDevice instance
        val device2: UiDevice  = UiDevice.getInstance(InstrumentationRegistry
            .getInstrumentation())

        device2.pressHome()
      /*  val launcherPackage: String = device2.launcherPackageName
        device2.wait(
            Until.hasObject(By.pkg(launcherPackage).depth(0)),
            LAUNCH_TIMEOUT
        )*/
        val launcherPackage=getLauncherPackageName();
        Assert.assertThat(launcherPackage, CoreMatchers.notNullValue())
        device2!!.wait(
            Until.hasObject(By.pkg(launcherPackage).depth(0)),
            LAUNCH_TIMEOUT.toLong()
        )
        // Launch the app
       // val context = ApplicationProvider.getApplicationContext<Context>()
        val context: Context= ApplicationProvider.getApplicationContext()
        val intent = context.packageManager.getLaunchIntentForPackage(
            BASIC_SAMPLE_PACKAGE)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        context.startActivity(intent)
        device2.wait(
            Until.hasObject(By.pkg(BASIC_SAMPLE_PACKAGE).depth(0)),
            LAUNCH_TIMEOUT
        )
        Thread.sleep(20000)

    }


    private fun getLauncherPackageName(): String? { // Create launcher Intent
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        // Use PackageManager to get the launcher package name
        val pm =
            ApplicationProvider.getApplicationContext<Context>().packageManager
        val resolveInfo = pm.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY)
        Log.i("intent",resolveInfo.activityInfo.packageName)
        return resolveInfo.activityInfo.packageName

    }
}