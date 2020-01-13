package org.vilc

import org.junit.Test
import java.awt.Rectangle
import java.awt.Robot
import java.awt.Toolkit
import java.awt.image.BufferedImage
import java.io.ByteArrayOutputStream
import java.io.File
import javax.imageio.ImageIO
import kotlin.test.assertTrue

class CaptureScreenTest {
  @Test
  fun capture() {
    val screenRect = Rectangle(Toolkit.getDefaultToolkit().getScreenSize())
    assertTrue(screenRect.width > screenRect.height)
    assertTrue(screenRect.width > 0)
    val capture: BufferedImage = Robot().createScreenCapture(screenRect)
    val stream = ByteArrayOutputStream()
    ImageIO.write(capture, "bmp", stream)
    assertTrue(stream.size() > screenRect.width * screenRect.height)
  }
}