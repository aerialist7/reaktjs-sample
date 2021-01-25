@file:JsModule("react-share")
@file:JsNonModule

import react.RClass
import react.RProps

external interface ShareButtonProps : RProps {
    var url: String
}

external interface IconProps : RProps {
    var size: Int
    var round: Boolean
}

@JsName("EmailShareButton")
external val emailShareButton: RClass<ShareButtonProps>

@JsName("TelegramShareButton")
external val telegramShareButton: RClass<ShareButtonProps>

@JsName("EmailIcon")
external val emailIcon: RClass<IconProps>

@JsName("TelegramIcon")
external val telegramIcon: RClass<IconProps>
