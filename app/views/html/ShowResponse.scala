package views.html

import play.api.libs.ws.WSResponse
import play.twirl.api.Html

object ShowResponse {

  def apply(maybeResponse: Option[WSResponse]): Html = {
    maybeResponse.map { response =>
      Html(
        s"""<pre>
           |${response.headers.map{ case (k, v) => v.map(v1 => s"$k: $v1").mkString("\n") }.mkString("\n")}
           |
         |${response.body}
         </pre>
       """.stripMargin)
    }.getOrElse(Html(""))
  }

}
