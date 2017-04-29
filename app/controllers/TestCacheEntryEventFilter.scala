package controllers

import javax.cache.event.{CacheEntryEvent, CacheEntryEventFilter}

class TestCacheEntryEventFilter extends CacheEntryEventFilter[Int, Int] {
  val logger = play.api.Logger(getClass)

  override def evaluate(event: CacheEntryEvent[_ <: Int, _ <: Int]): Boolean = {
    logger.info(s"evaluate: event = $event")
    return false
  }
}
