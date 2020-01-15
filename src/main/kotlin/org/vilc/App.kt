package org.vilc

import java.awt.Desktop
import java.awt.Rectangle
import java.awt.Robot
import java.awt.Toolkit
import java.awt.image.BufferedImage
import java.nio.file.Files
import java.nio.file.Paths

class App(val ocr: Ocr,
          val stripper: Stripper,
          val interpreter: OcrTextInterpreter) {
  fun onClickTarget(cursorX: Int, cursorY: Int) {
    val stripe = stripper.makeStripe(cursorX, cursorY)
    val buffer = ImageConverter.bufferedImageToByteBuffer(stripe)

    val ocrText = ocr.pictureToText(buffer, stripe.width, stripe.height)
    val mayBeUrl = interpreter.extractUrl(ocrText)
    if (mayBeUrl.isPresent) {
      if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
        Desktop.getDesktop().browse(mayBeUrl.get().toURI());
      }
    }
    Files.write(Paths.get("extracted.txt"), "url $mayBeUrl from:\n$ocrText".toByteArray())
  }
}