package me.ibrahimsn.lib.core

import io.michaelrocks.libphonenumber.android.NumberParseException
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil
import io.michaelrocks.libphonenumber.android.Phonenumber
import java.util.*

class Core(
    val phoneUtil: PhoneNumberUtil
) {

    fun isValidPhoneNumber(
        number: String?,
        defaultRegion: String?
    ): Boolean {
        return try {
            phoneUtil.isValidNumber(
                phoneUtil.parseAndKeepRawInput(
                    number,
                    defaultRegion?.toUpperCase(Locale.ROOT)
                )
            )
        } catch (e: NumberParseException) {
            false
        }
    }

    fun parsePhoneNumber(
        number: String?,
        defaultRegion: String?
    ): Phonenumber.PhoneNumber? {
        return try {
            phoneUtil.parseAndKeepRawInput(
                number,
                defaultRegion?.toUpperCase(Locale.ROOT)
            )
        } catch (e: NumberParseException) {
            null
        }
    }

    fun formatPhoneNumber(phoneNumber: Phonenumber.PhoneNumber?): String? {
        return try {
            phoneUtil.format(
                phoneNumber,
                PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL
            )
        } catch (e: Exception) {
            null
        }
    }

    /**
     * Provides an example phone number according to country iso2 code
     */
    fun getExampleNumber(iso2: String?): Phonenumber.PhoneNumber? {
        return try {
            phoneUtil.getExampleNumberForType(
                iso2?.toUpperCase(Locale.ROOT),
                PhoneNumberUtil.PhoneNumberType.MOBILE
            )
        } catch (e: Exception) {
            null
        }
    }
}
