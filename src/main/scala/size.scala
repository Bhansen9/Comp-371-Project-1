package edu.luc.cs.laufer.cs371.shapes

import org.slf4j.LoggerFactory
import Shape.*


object size:
  private val logger = LoggerFactory.getLogger(getClass)

  def apply(shape: Shape): Int =
    logger.debug("Computing size for {}", shape)
    shape match
      case Rectangle(_, _)       => 1
      case Ellipse(_, _)         => 1
      case Location(_, _, child) => apply(child)
      case Group(children*)      => children.map(apply).sum

