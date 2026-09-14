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
      Location(0,0, Rectangle(0,0))


end boundingBox
