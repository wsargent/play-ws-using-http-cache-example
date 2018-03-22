package controllers

import javax.inject._
import play.api.mvc._
import play.api.libs.ws._

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class HomeController @Inject()(ws: WSClient, cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

  def index = Action { implicit request =>
    // Cache for 30 seconds
    val form = RequestForm.empty.fill(RequestForm("https://httpbin.org/cache/30"))

    Ok(views.html.index(form, None))
  }

  def postRequest = Action.async { implicit request =>
    RequestForm.empty.bindFromRequest.fold(formWithErrors => {
      // binding failure, you retrieve the form containing errors:
      Future.successful{
        BadRequest(views.html.index(formWithErrors, None))
      }
    },
      requestData => {
        val form = RequestForm.empty.fill(RequestForm(requestData.url))

        ws.url(requestData.url).get().map { response =>
          Ok(views.html.index(form, Some(response)))
        }
      })
  }

  // cacheManager needs to be shutdown explicitly
}
