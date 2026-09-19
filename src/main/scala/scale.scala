package edu.luc.cs.laufer.cs371.shapes

import org.slf4j.LoggerFactory
import Shape.*

object scale:
  private val logger = LoggerFactory.getLogger(getClass)

  def apply(shape: Shape, factor: Int): Shape =
    require(factor >= 0, "scale factor must be nonnegative")
    logger.debug("Scaling {} by {}", shape, factor)

    shape match
      case Rectangle(width, height) =>
        Rectangle(width * factor, height * factor)
      case Ellipse(xRadius, yRadius) =>
        Ellipse(xRadius * factor, yRadius * factor)
      case Location(x, y, child) =>
        Location(x * factor, y * factor, apply(child, factor))
      case Group(children*) =>
        Group(children.map(apply(_, factor))*)

  def apply(factor: Int, shape: Shape): Shape = apply(shape, factor)

