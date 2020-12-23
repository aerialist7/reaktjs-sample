@file:Suppress("NON_EXPORTABLE_TYPE", "EXPERIMENTAL_API_USAGE")

import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import org.w3c.dom.HTMLInputElement
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import react.dom.input
import react.dom.label
import react.dom.output

external interface WelcomeProps : RProps {
    var name: String
}

data class WelcomeState(val name: String) : RState

@JsExport
class Welcome(props: WelcomeProps) : RComponent<WelcomeProps, WelcomeState>(props) {

    init {
        state = WelcomeState(props.name)
    }

    override fun RBuilder.render() {
        div {
            +"Hello, ${state.name}"
        }
        input {
            attrs {
                type = InputType.text
                value = state.name
                onChangeFunction = {
                    setState(
                        WelcomeState(name = it.target.unsafeCast<HTMLInputElement>().value)
                    )
                }
            }
        }
        label {
            attrs.htmlFor = "root"
            console.log(attrs)
            +"Label"
        }
        output {
            attrs.htmlFor = "root"
            console.log(attrs)
            +"Output"
        }
    }
}
