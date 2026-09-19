package edu.luc.cs.laufer.cs371.shapes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import Shape.*
import TestFixtures.*

class TestHeight:
  @Test
  def testConcreteShapes(): Unit =
    assertEquals(1, height(simpleRectangle))
    assertEquals(1, height(simpleEllipse))

  @Test
  def testLocation(): Unit =
    assertEquals(2, height(simpleLocation))

  @Test
  def testGroups(): Unit =
    assertEquals(1, height(Group()))
    assertEquals(2, height(basicGroup))
    assertEquals(3, height(simpleGroup))
    assertEquals(6, height(complexGroup))

