package com.brins.translation.translation.model

class Translation {
    var type : String? = null
    var errorcode : Int? = null
    var elapsedTime : Int? = null
    var translateResult : MutableList<MutableList<TranslateResult>>? = null

    companion object {
        class TranslateResult {
            var src : String? = null
            var target : String ? = null
        }
    }
}