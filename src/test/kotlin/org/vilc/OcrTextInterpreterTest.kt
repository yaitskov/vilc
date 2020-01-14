package org.vilc

import org.hamcrest.core.Is
import org.junit.Assert.assertThat
import org.junit.Test
import java.net.URL
import java.util.*

class OcrTextInterpreterTest {
  @Test
  fun catch1() {
    assertThat(OcrTextInterpreterFactory.create().extractUrl(
        "X @ U a https://medium.com/fuzzy-sharp/purescript-and-haskell-at-lumi-7e852b16fb13\n"),
        Is.`is`(Optional.of(URL("http://medium.com/fuzzy-sharp/purescript-and-haskell-at-lumi-7e852b16fb13"))))
  }
}