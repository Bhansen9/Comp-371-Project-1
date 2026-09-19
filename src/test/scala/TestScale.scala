package edu.luc.cs.laufer.cs371.shapes

import org.junit.jupiter.api.Assertions.{assertEquals, assertThrows}
import org.junit.jupiter.api.Test
import Shape.*

class TestScale:
  @Test
  def testRectangleAndEllipse(): Unit =
    assertEquals(Rectangle(6, 9), scale(Rectangle(2, 3), 3))
    assertEquals(Ellipse(8, 12), scale(4, Ellipse(2, 3)))

  @Test
  def testLocationAndGroupRecursively(): Unit =
    val original = Group(
      Location(2, -3, Rectangle(4, 5)),
      Ellipse(6, 7)
    )
    val expected = Group(
      Location(4, -6, Rectangle(8, 10)),
      Ellipse(12, 14)
    )
    assertEquals(expected, scale(original, 2))

  @Test
  def testScaleFactorValidation(): Unit =
    assertEquals(Rectangle(0, 0), scale(Rectangle(2, 3), 0))
    assertThrows(
      classOf[IllegalArgumentException],
      () => { scale(Rectangle(2, 3), -1); () }
    )
    ()

