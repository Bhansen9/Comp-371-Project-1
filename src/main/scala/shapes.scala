package edu.luc.cs.laufer.cs371.shapes

enum Shape derives CanEqual:
  case Rectangle(width: Int, height: Int)
  case Location(x: Int, y: Int, shape: Shape)
  case Ellipse(width: Int, height: Int)
  case Group(shapes: Shape*)

  this match
    case Rectangle(width, height) =>
      require(width >= 0, "rectangle width must be nonnegative")
      require(height >= 0, "rectangle height must be nonnegative")
    case Ellipse(xRadius, yRadius) =>
      require(xRadius >= 0, "ellipse horizontal radius must be nonnegative")
      require(yRadius >= 0, "ellipse vertical radius must be nonnegative")
    case _ => ()
