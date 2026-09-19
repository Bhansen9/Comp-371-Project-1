package edu.luc.cs.laufer.cs371.shapes

import org.junit.jupiter.api.Assertions.{assertEquals, assertThrows}
import org.junit.jupiter.api.Test
import Shape.*

class TestValidation:
  @Test
  def testRectangleValidation(): Unit =
    assertEquals(Rectangle(0, 0), Rectangle(0, 0))
    assertThrows(classOf[IllegalArgumentException], () => { Rectangle(-1, 2); () })
    assertThrows(classOf[IllegalArgumentException], () => { Rectangle(1, -2); () })
    ()

  @Test
  def testEllipseValidation(): Unit =
    assertEquals(Ellipse(0, 0), Ellipse(0, 0))
    assertThrows(classOf[IllegalArgumentException], () => { Ellipse(-1, 2); () })
    assertThrows(classOf[IllegalArgumentException], () => { Ellipse(1, -2); () })
    ()

