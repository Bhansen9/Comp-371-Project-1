package edu.luc.cs.laufer.cs371.shapes

// TODO: implement this behavior


import Shape.*

object boundingBox:
  def apply(s: Shape): Location = s match
    case Rectangle(width, height) =>
      Location(0, 0, Rectangle(width, height))

    case Location(x, y, shape) =>
      val Location(boxX, boxY, rectangle) = apply(shape)
      Location(x + boxX, y + boxY, rectangle)
    
    case Ellipse(width, height) =>
      Location(-width, -height, Rectangle(width * 2, height * 2))

    case Group(shapes*) =>
  val boxes = shapes.map(apply)

  val minX = boxes.map(_.x).min
  val minY = boxes.map(_.y).min
  val maxX = boxes.map {
    case Location(x, _, Rectangle(width, _)) => x + width
    case _ => throw MatchError(s)
  }.max
  val maxY = boxes.map {
    case Location(_, y, Rectangle(_, height)) => y + height
    case _ => throw MatchError(s)
  }.max

  Location(minX, minY, Rectangle(maxX - minX, maxY - minY))


end boundingBox
