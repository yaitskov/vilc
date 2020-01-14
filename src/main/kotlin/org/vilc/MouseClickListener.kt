package org.vilc

import org.jnativehook.mouse.NativeMouseEvent
import org.jnativehook.mouse.NativeMouseListener

class MouseClickListener(val app: App) : NativeMouseListener {
  override fun nativeMousePressed(p0: NativeMouseEvent) {
    // ignore
  }

  override fun nativeMouseClicked(p0: NativeMouseEvent) {
    if (p0.button == 3) {
      print("Mouse middle clicked at ${p0.x} ${p0.y} with ${p0.button}")
      app.onClickTarget(p0.x, p0.y)
    }
  }

  override fun nativeMouseReleased(p0: NativeMouseEvent) {
    // ignore
  }
}