package org.vilc

import java.awt.Rectangle
import java.nio.ByteBuffer

data class Stripe(val size: Rectangle, var data: ByteBuffer)