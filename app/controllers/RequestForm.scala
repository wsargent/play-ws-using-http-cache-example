package controllers

import play.api.data._
import play.api.data.Forms._

object RequestForm {

  val empty = Form(
    mapping(
      "url" -> nonEmptyText,
    )(RequestForm.apply)(RequestForm.unapply)
  )
}

case class RequestForm(url: String)