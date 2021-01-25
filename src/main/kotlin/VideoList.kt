import kotlinx.html.js.onClickFunction
import react.*
import react.dom.p

external interface VideoListProps : RProps {
    var videos: List<Video>
    var selectedVideo: Video?
    var onSelectVideo: (Video) -> Unit
}

val VideoList = functionalComponent<VideoListProps> { props ->
    props.videos.forEach { video ->
        p {
            key = "${video.id}"
            attrs {
                onClickFunction = { props.onSelectVideo(video) }
            }
            if (video == props.selectedVideo) {
                +"▶ "
            }
            +"${video.speaker}: ${video.title}"
        }
    }

}

fun RBuilder.videoList(
    handler: VideoListProps.() -> Unit
): ReactElement = child(VideoList) {
    attrs(handler)
}
