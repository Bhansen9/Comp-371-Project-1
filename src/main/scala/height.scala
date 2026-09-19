package edu.luc.cs.laufer.cs371.shapes

import org.slf4j.LoggerFactory
import Shape.*


object height:
  private val logger = LoggerFactory.getLogger(getClass)

  def apply(shape: Shape): Int =
    logger.debug("Computing height for {}", shape)
    shape match
      case Rectangle(_, _)       => 1
      case Ellipse(_, _)         => 1
      case Location(_, _, child) => 1 + apply(child)
      case Group()               => 1
      case Group(children*)      => 1 + children.map(apply).max

