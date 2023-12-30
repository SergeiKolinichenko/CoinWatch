package info.sergeikolinichenko.coinwatch.preferences

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

/** Created by Sergei Kolinichenko on 10.10.2023 at 13:27 (GMT+3) **/

object PreferencesCoinWatch {

    private const val SHARED_PREFERENCES_NAME = "shared_preferences"
    private var INSTANCE: SharedPreferences? = null
    private val LOCK = Any()

    fun getInstance(application: Application): SharedPreferences {
      INSTANCE?.let {
        return it
      }
      synchronized(LOCK) {
        INSTANCE?.let {
          return it
        }
        val sharPref =
          application.applicationContext.getSharedPreferences(
            SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
        INSTANCE = sharPref
        return sharPref
      }
    }
}