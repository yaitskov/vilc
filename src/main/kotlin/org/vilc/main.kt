package org.vilc

import org.bytedeco.javacpp.tesseract
import org.jnativehook.GlobalScreen
import java.lang.Exception

fun main() {
  print("Start")

  val tessApi = tesseract.TessBaseAPICreate()
  val initCode = tessApi.Init(null, "eng")

  if (initCode > 0) {
    throw Exception("tesseract init code $initCode")
  }

  val ocr = Ocr(tessApi)

  val app = App(ocr, OcrTextInterpreterFactory.create())
  GlobalScreen.registerNativeHook()
  GlobalScreen.addNativeMouseListener(MouseClickListener(app))

  print("Press enter to exit...")
  readLine()
  System.exit(0)
}