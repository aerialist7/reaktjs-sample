@file:JsModule("react-player")
@file:JsNonModule

import react.RClass
import react.RProps

external interface ReactPlayerProps : RProps {
    var url: String
}

@JsName("default")
external val reactPlayer: RClass<ReactPlayerProps>
