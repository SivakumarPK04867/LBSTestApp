package com.lbg.testapp.presentation.ui

import androidx.test.espresso.idling.CountingIdlingResource

/**
 * Created by Siva kumar boddu 
 */
object CoroutinesIdlingResource {

    private val idlingResourceName = "COROUTINES_IDLING_RESOURCE"

    val idlingResource = CountingIdlingResource(idlingResourceName)

}