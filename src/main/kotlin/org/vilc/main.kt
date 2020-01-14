package org.vilc

import org.jnativehook.GlobalScreen


fun main() {
  print("Start")

  val app = App()
  GlobalScreen.registerNativeHook()
  GlobalScreen.addNativeMouseListener(MouseClickListener(app))

  print("Press enter to exit...")
  readLine()
  System.exit(0)
}