package tw.edu.pu.s1114859.media

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import tw.edu.pu.s1114859.media.ui.theme.MediaTheme

class VideoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MediaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2("第二頁")

                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    val context = LocalContext.current

    val link = "https://redirector.googlevideo.com/videoplayback?expire=1716992879&ei=D-dWZvjmJNm76dsP27O2sAw&ip=148.251.92.112&id=o-AJoH24q3UFSVoRu-YMYSbkmotjOJEmeHucD3yqZ93u7x&itag=22&source=youtube&requiressl=yes&xpc=EgVo2aDSNQ%3D%3D&mh=lu&mm=31%2C29&mn=sn-4g5e6nss%2Csn-4g5edndd&ms=au%2Crdu&mv=m&mvi=3&pl=21&initcwndbps=542500&siu=1&vprv=1&svpuc=1&mime=video%2Fmp4&rqh=1&cnr=14&ratebypass=yes&dur=260.806&lmt=1695189444682005&mt=1716970373&fvip=5&c=ANDROID_TESTSUITE&txp=1432434&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cxpc%2Csiu%2Cvprv%2Csvpuc%2Cmime%2Crqh%2Ccnr%2Cratebypass%2Cdur%2Clmt&sig=AJfQdSswRgIhANh1v13feNOgSzbQmGWWAXiGs3TkfhE6hATmgETYwmmYAiEAzcwsHLvx-a9XYCvV-zZ8ZOsTKofTMNpIR5xSRJmhHWo%3D&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AHWaYeowRAIgbkIHxSa2GyeUDJuS61n0P5oZJvcw6T3B9MrcIFv-pLACIBlRQYaznedpfWqng1xiWGJDTEl0hzxlxQ7gpLms87H8&range=0-51070592&title=X2Download.com-I%20Love%20Taiwan%20Part%20I%20%E6%88%91%E6%84%9B%E5%8F%B0%E7%81%A3%E7%AC%AC%E4%B8%80%E9%83%A8"
    val exoPlayer = ExoPlayer.Builder(context).build()

    val mediaItem = MediaItem.fromUri(android.net.Uri.parse(link))
    exoPlayer.setMediaItem(mediaItem)

    val playerView = PlayerView(context)
    playerView.player = exoPlayer
    DisposableEffect(AndroidView(factory = {playerView})){
        exoPlayer.prepare()
        exoPlayer.playWhenReady = true

        onDispose{
            exoPlayer.release()
        }
    }


}
