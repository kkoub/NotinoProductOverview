package cz.koubicl.example.remote.adapters

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter

class BooleanAdapter : JsonAdapter<Boolean>() {

    override fun fromJson(reader: JsonReader): Boolean {
        val type = reader.peek()
        reader.isLenient
        return when (type) {
            JsonReader.Token.BOOLEAN -> reader.nextBoolean()
            JsonReader.Token.STRING -> reader.nextString().toLowerCase() == "true"
            else -> throw IllegalArgumentException("Unexpected type: ${type.name}")
        }
    }

    override fun toJson(writer: JsonWriter, value: Boolean?) {
        writer.value(value ?: false)
    }
}