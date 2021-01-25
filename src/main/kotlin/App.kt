import kotlinx.browser.window
import kotlinx.coroutines.*
import react.RProps
import react.dom.div
import react.dom.h1
import react.dom.h3
import react.functionalComponent
import react.useEffect
import react.useState

// TODO: Use state object or properties
/*external interface AppState : RState {
    var currentVideo: Video?
    var unwatchedVideos: List<Video>
    var watchedVideos: List<Video>
}*/

val App = functionalComponent<RProps> {
    val (currentVideo, setCurrentVideo) = useState<Video?>(null)
    var (unwatchedVideos, setUnwatchedVideos) = useState<List<Video>>(emptyList())
    var (watchedVideos, setWatchedVideos) = useState<List<Video>>(emptyList())

    useEffect(emptyList()) {
        GlobalScope.launch {
            val videos = fetchVideos()
            setUnwatchedVideos(videos)
        }
    }

    h1 { +"KotlinConf Explorer" }

    div {
        h3 { +"Videos to watch" }
        videoList {
            videos = unwatchedVideos
            selectedVideo = currentVideo
            onSelectVideo = {
                setCurrentVideo(it)
            }
        }

        h3 { +"Videos watched" }
        videoList {
            videos = watchedVideos
            selectedVideo = currentVideo
            onSelectVideo = {
                setCurrentVideo(it)
            }
        }
    }

    currentVideo?.let {
        videoPlayer {
            video = it
            unwatchedVideo = it in unwatchedVideos
            onWatchedButtonPressed = {
                if (video in unwatchedVideos) {
                    unwatchedVideos -= video
                    setUnwatchedVideos(unwatchedVideos)

                    watchedVideos += video
                    setWatchedVideos(watchedVideos)

                } else {
                    watchedVideos -= video
                    setWatchedVideos(watchedVideos)

                    unwatchedVideos += video
                    setUnwatchedVideos(unwatchedVideos)
                }
            }
        }
    }
}

suspend fun fetchVideos(): List<Video> = coroutineScope {
    (1..25).map {
        async {
            fetchVideo(it)
        }
    }.awaitAll()
}

private suspend fun fetchVideo(id: Int): Video =
    window.fetch("https://my-json-server.typicode.com/kotlin-hands-on/kotlinconf-json/videos/$id")
        .await()
        .json()
        .await()
        .unsafeCast<Video>()
