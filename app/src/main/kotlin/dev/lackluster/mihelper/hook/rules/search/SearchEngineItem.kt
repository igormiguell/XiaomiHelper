package dev.lackluster.mihelper.hook.rules.search

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class SearchEngineItem(
    val searchEngineName: String,
    val channelNo: String,
    val showIcon: Boolean,
    val searchUrl: String,
    val iconUrl: String,
    val titleLzhCN: String,
    val titleLzhTW: String,
    val titleLenUS: String,
    val titleLboCN: String,
    val titleLugCN: String
) {
    companion object {
        const val ICON_BASE64_BING = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEYAAABGCAYAAABxLuKEAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAzuSURBVHgB7VtdjFxlGX7fb2bX7WrTnRSqJIBTlQAXhl0i0kZIZ6MiGAgleuEdP4mJdy1e6J07vTJeQY1XxrhwR0wIxRAlkThTC2lDSZcarxTYEUQQo7ulpH9zzvf6/n3nTKGl3TmzZdfsm8yeM2fOnJnzzPM+79+3ABu2YRu2YatnCBXtjkMf3AJ9fIIAbkHEZzM4++iR2UYP1rlVAqbVWZrq5+MLQNQsrkawHHPYd/juzzwO69gqAbPj96eboZa/wRdBIr8YCjZAvDmY5/2Hj9yzPtkToJKdAcgJY2QsIoGAE3PSY5RTK0B9YefvTuyFdWgVgWFqRP6TRwECKOMnUY8R2XYLRHxsx3MnOzueWWrCOrJqwDBhQABhXIhJIj4kzxkcBYpZhHIcI7WwXj92+2/XD3uqM0bgYNdR9zGWgIFi+wwKqujk1AjE7Hn25BysA6sOjABCpjHKFmGNguLg8LGorCLdpzy2b3967TOnuiupxhg4+jAQSI4zIGQaVDJIzyeYa80vTcEatsqMSaygzNzJn+sWnCWJRaUw09Spydr9sIatEjBZBs2Yx8J1JGw7ELaNqBokxyOzSB6mRwJePgNr2OpQ0VC0VRIYfQJpn6sDNJ3RXC+9LDpM8iIECltgDVtlYERHvBRA/yOwCDvkOSoYhociozqDVIK5Rq0aMBkYZRgIMCXxGzaWeKBGxQtRFVmAEumBtY1LdcZYqI6ofoSl36jSSIKHwdSX91E5ZYiE6oX9qlpFxjBlMAgbjBoCBKgDacprJ0VnDypQeoghihqm1q5Vd6WaUgPkbuUQeXHtQdr0VoxZ5QpkElw9UVhVqwSMSkwEFRl5LtFY1JbAGVPiYIwhcq3RUgHWslVnTDD3KUwjlGgLQOEt1rCRSlOBi7Dmg9IIgBmzu0xSOqgcKW9Jz5LOKG3wwhqzo9PnPg60+NXukdmxLnxCNooisqiD/EFl+k/Fc/IiU88RtLKPXmtHJ59DDH9k6H7Ckt752sF+5w4GCj4BGwkwxUNbEOdX1hqJiroJ7HgW8UJ5DFPpIT4ZhU8c5flPbEEt79x56Eyndeh0C66gVQNGwnX0BpXcfCY9GQUg1UpeZTNWuec1CbTsQq4kYJhaq+PxNoiUI+3id3Z2vXSKATrZgitgFYERdkQs3SYxxAFykDQB1GNFWwIuzBh6cgAMfwhQEVW9GSB+sTP70kkGaKkFq2gjcKXEDhhsLfh+AgkcIG9L6Gsf/ejxWN/P30iivYUx3Y8lSJRrasj7rVq91vn64fc7rZeXpmEVrDJjio6dCys4CGlfXUhbEan1qffKGH3UlbqzuMzIHVRXssxIk2oBJYj2MFDCphASm2KrTnjsmy8vzd99eLTN9mr9GPDWZqSi1yttTE3uBvcLwKgALWYXviafsc+SHhVhMDFWwREX02PuVpRe53c9GAMdu+uVpQdhRFaNMRJlyFlhLcukKzY5yFOoTq4EaYJw0er6xTs3dRmEZbtpUm1JrgXuUsoejClypecN/qD5u47+Zw5GYNU1JtOuXNHs9sEbqSjz947mRvI6equTdD+/eOrLb/q5MUNLKlTW6IMsYpkbSXMHC6Guybk5e1ts333035XBqQZMP7PeVCx6vcYiHcBBYgxZ/lJMC/CShXWWPS4SY9EoFmCYICcXcnBCqUGmP6JLsX3P0XcrTSKq9nyT6FIKwaQzJLCIRDqqLTToPK3pXxyd7mxjmd/VNXD4SwYowbHQrYDYcQNEB1gJNHGvgHPffvm9oSPWCEa0NnkEz36L2VKaSpLrSwrpAxODj7Ma5PtSpgdQ5jPFIbmA6Y7pjHYSlb5QE8BC3BLG8sdgSBvJ+ET7vlJOD0wiKfP5dTYgwEWC533yj7EXdja6TLUTQS+sbmShO7mO9AaFLeDRiwGykJ6AUia17l14qwVDWCVgWEqWNS+hNKuGcgpJ7kISnqJpTpHsiTBnl/MJcX9qsGPBGisVEv3KDDle5AFDCXElYGr9/jIHAstLXGxjPlhN80k5UsqCU4UNdt4lLZsIsvioB6nXTtHZI4kenA+KAGYJIBbHQV2sdd+f39oFK7QRaQx5ThZTSPZEzhhT5jjuTqTCfMlrd2cayyHiLL+rJ8+VMZYR43lssX3Csnyw/aDAQI2yWVihjQIYTBlvWR8NbPOB6jq5U2LRZdjzOxs9zPjGuMAkBYhKgHxkZdto8uNaExJYojkBV8yYah08HupTsKmRzWXl4EDP2/vh9gunFsz5J12OPb/zmh5vHpL93QvvTWcQd7FI7Wa4W+BijB4KFbNA6QvYEjjEFYftyoxBz2jLyJMaUl4aSKarDEkuhgQpERzCDsxse/W5mc/tf3b62lmm3na+0CP90/G41lIaprWno8WmakzQCDa1e2FhRasrqg/coo9MqBig+BjFD5ANZO0IFtNawOpzpQMz23vXfu9vPYZ+anwzwHWtQJ+9Fax34zNy+1z+xIkpAWb5cq9d2ZWgbkkc+7E2otRLHJyB/iWaU5UDfkdxaGv+YLFJZ/L5mFELMqRzJwj++nSGy68jNb8BuGkrEvqwr/yyl28jYQyA5TGUSEI2zfc5E/hC12LFq71vOMY09y5O1c/Bnvxc3Mu/xhaJPDrCMS2h9xY4uXod4KuPIo5N+uxcROfUmctmi1gljZHfoGxfQkrqijYmeGnjbc6y3Rnh0rH6AnbT3sXWeI4LvNtmhk5hsAkNyl1IB70mwotwliH4xyHv5YjOQH7iwMzMioCpzBgDJGIijv61iIRWUyY6o7IoTdpW4kg3/XixiVCfJ3EbWx8qRaTNswIq0BqJ5EfQF5HePER4/S6gsU3ivvgqrNCqh+va4I+fhDcNJwldcEtBBihc7lI23V6cinFiT8wjP2hK2VGzskK4Ll5krT0f+erWPCc7Q3DybcTGlxSx47BCGw1joMxYtDeH6aezQJTA8bpba0G6hMR85advtfJYn8eMmvJGvb1gnJTqUOe8QcsAy/GCAa6prkw7OXb/9zWCxhc5B450AFZo1cV3oBPnax5UXxDTfxXoWZbQ6dIQWxONF3Gm6cfeaY7F2nyecfJmEZ67c2hdv5IRct+2qgQ9C0C/KCb3UuWXNKv31M1f7sIKbQRRqQjPko+jfiHwrAVhoCRKQckWEH2YMLK89cypbA9fb0/sx6lQEw0nFVOtt1IZEHxVgAhulI6d5ZicyKGUakWp4Asu+FAbhrBKUan31PbexNbaQOabOnXlcA2KQRxoR69Y4jqAzJ2/Xrq/n9MC1sIc/+INcQ+7QW262GLGmo0JvAdR1kvBU6fgY4Tgi7t4u+mqsPibG298EoawyoyZuHps4fS/+jNQ5CxJedPyEE/t3KcA0n/vRGFJk8ZQkzSPNHZjwedP4iIBNdXPo7YyUXUmaOWubBL2WJ/BW55oxP1UA2BsMzwCQ1rlWun6bzX+tOkqXQuCMbUa8nJ+LbVRwZzc2pyhjrD1ts+0cDIs8s21lBXBNMLdRadq6dcvHh6E9LyQjmNaL6o+qisCVJSx/cJ9N3RhSKvedqjVnvnCd6+C8c11E9ei6S19GCseve+rLjZ5zRg2H9gKjZsnm4oCWk1DJlE+VQO7x1BohkqLJXSpMNe7J3U7j04qvkGrk/Ybv7xhH1SwagWL2+4j/U48F1vvHDwB7770vn9xwqL7wLf96esnaNuOzThxzTjxhEBandorZjfSZSG5MIz3YxZ1+b30d1iEFdDox6MtzdctTzL5vZxYytb+Vwr1vBj3vfnEDW2oaKMB5nC/FerQAQ6r/RM5nvrnWfjg7XO65q42jqxD4zB57bjdtN+ogWDL7GM/N6Dk5tNxbX7Ja6TN5bxvLjp4DQNIH+Kuf8+z7OHer4Z3n0EbCTBi33kl6zCNGSDt6xP5l5a5kvzyxa+tQDhj/Lhqk4DCx8vnCgIWIApIWbqmHpceM2/jcp7B46/94vOVXOfDNrJFpXmt9gBJ4zot+nGd8La+qWqqmlLh4ALqJQOakFjK4lpq7wsuuFhoiZ0BMpSLM6MGRb8jjNAeOEa3hJB3pfIVVZVf3DWhZInpih+P7lYMrHT6XDOSXuSSLPZdbwrNUfb06Gx8+C8/u64Lq2QjXYb8zK14PFCc5eSuJ3T3lqszILV90wBt4I2JNUoJBs0TOeWOtRRSG1ko066FczOrCYp/pdHb7oXTTYxjHflHdfKhvrIgL4RVNESbW7npEBkjTJPyzNiTBNmFuptjePTVH21bcQthGFsVYJLtPtqf48Z3W+nvCxKlZMj70eZLFpZT2PWoQwPhV6PPMh9vH/3htv1wBW1VV/QfuG1sH9/tdvanJzm566nDqG+FgdqycJpkLq24zGLcnowfbL/SoKQvccXs3j+cbnGEvZ/1Z5qFd5pdZYuHcRbj2FNR7efHmUEHXvz+1V3YsA3bsA37P7X/AQB+2jaC4DyxAAAAAElFTkSuQmCC"
        const val ICON_BASE64_GOOGLE = "data:image/png;base64,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"

        val Bing = SearchEngineItem(
            "bing",
            "",
            true,
            "https://www.bing.com/search?q={searchTerms}",
            ICON_BASE64_BING,
            "必应",
            "Bing",
            "Bing",
            "Bing",
            "Bing"
        )

        val Google = SearchEngineItem(
            "google",
            "",
            true,
            "https://www.google.com/search?q={searchTerms}",
            ICON_BASE64_GOOGLE,
            "谷歌",
            "Google",
            "Google",
            "Google",
            "Google"
        )

        fun decodeFromString(string: String): SearchEngineItem {
            return Json.decodeFromString(string)
        }

        fun encodeToString(searchEngineItem: SearchEngineItem): String {
            return Json.encodeToString(searchEngineItem)
        }
    }
}