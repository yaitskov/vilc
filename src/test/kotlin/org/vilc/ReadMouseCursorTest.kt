package org.vilc

import org.junit.Test
import java.awt.MouseInfo
import kotlin.test.assertTrue

class ReadMouseCursorTest {
  @Test
  fun read() {
    val loc = MouseInfo.getPointerInfo().location;
    assertTrue(loc.x >= 0, "x < 0 $loc")
    assertTrue(loc.y >= 0, "x < 0 $loc")
  }
}