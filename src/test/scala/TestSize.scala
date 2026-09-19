package edu.luc.cs.laufer.cs371.shapes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import Shape.*
import TestFixtures.*

class TestSize:
  @Test
  def testConcreteShapes(): Unit =
    assertEquals(1, size(simpleRectangle))
    assertEquals(1, size(simpleEllipse))

  @Test
  def testLocationDoesNotIncreaseSize(): Unit =
    assertEquals(1, size(simpleLocation))

  @Test
  def testGroupsCountTheirLeaves(): Unit =
    assertEquals(0, size(Group()))
    assertEquals(2, size(basicGroup))
    assertEquals(2, size(simpleGroup))
    assertEquals(5, size(complexGroup))

