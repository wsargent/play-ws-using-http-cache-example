package controllers

import org.scalatest.concurrent.PatienceConfiguration.Timeout
import org.scalatest.concurrent.ScalaFutures
import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.libs.ws.WSClient
import play.api.test._

import scala.concurrent.duration._
import scala.concurrent.ExecutionContext

class WSCacheClientSpec extends PlaySpec with GuiceOneAppPerTest with Injecting with ScalaFutures {

  "WSClient" should {
    "Call out to a cached URL" in {
      val client = inject[WSClient]
      implicit val executionContext = inject[ExecutionContext]

      val url = "https://httpbin.org/cache/60"
      whenReady(client.url(url).get(), Timeout(1 seconds)) { response =>
        response.header("Cache-Control").get === "public, max-age=60"
      }

      // XXX should use a cache listener here to verify that entry made it into the cache...
    }
  }

}
