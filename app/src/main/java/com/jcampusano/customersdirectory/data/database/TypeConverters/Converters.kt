package com.jcampusano.customersdirectory.data.database.TypeConverters

import androidx.room.TypeConverter

import org.json.JSONObject


object Converters {

    @JvmStatic
    @TypeConverter
    fun toSqlValue(value: Map<String, String?>?): String {
        if(value == null)
            return ""

        val jObject = JSONObject()
        for (key in value.keys) {
            val currentValue = value[key]
            if (currentValue.isNullOrEmpty())
                continue

            jObject.put(key, currentValue)
        }

        return jObject.toString()
    }

    @JvmStatic
    @TypeConverter
    fun fromSqlValue(value: String): Map<String, String?> {
        val result = mutableMapOf<String, String?>()
        if (value.isEmpty() || value.isBlank())
            return result

        try {
            // First, we try to deserialize the object
            val jObject = JSONObject(value)
            for (key in jObject.keys()) {
                val currentValue = jObject.getString(key)
                if (currentValue.isNullOrEmpty())
                    continue

                result[key] = currentValue
            }
        } catch (e: Exception) {
        }

        return result
    }
}