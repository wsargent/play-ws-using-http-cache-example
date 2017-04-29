package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.ws._
import play.twirl.api._
import scala.concurrent.ExecutionContext

@Singleton
class HomeController @Inject()(ws: WSClient, cc: ControllerComponents)(implicit ec: ExecutionContext) extends AbstractController(cc) {

  def index = Action.async {
    // Cache for 30 seconds
    ws.url("https://httpbin.org/cache/30").get().map { response =>
      Ok(Html(response.body))
    }
  }
}
