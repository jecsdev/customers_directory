package com.jcampusano.customersdirectory.data.database.TypeConverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import org.json.JSONObject


object Converters {

    @JvmStatic
    @TypeConverter
    fun fromString(value: String): Map<Int, String>? {
        val mapType = object : TypeToken<Map<Int, String>?>() {}.type
        return Gson().fromJson(value, mapType)
    }

    @TypeConverter
    @JvmStatic
    fun fromStringMap(map: Map<Int, String>?): String {
        val gson = Gson()
        return gson.toJson(map)
    }
}