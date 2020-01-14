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

  @Test
  fun withPort() {
    assertThat(OcrTextInterpreterFactory.create().extractUrl(
        "X @ U a https://foodfest.net:8443/festival/kelner/serve/order/233/E1\n"),
        Is.`is`(Optional.of(URL("http://foodfest.net:8443/festival/kelner/serve/order/233/E1"))))
  }

  @Test
  fun withParams() {
    assertThat(OcrTextInterpreterFactory.create().extractUrl(
        "X @ U a https://www.google.com/search?client=firefox-b-1-d&q=who+calls+liftShowsPrec\n"),
        Is.`is`(Optional.of(URL("http://www.google.com/search?client=firefox-b-1-d&q=who+calls+liftShowsPrec"))))
  }

  @Test
  fun stackFromChrome() {
    assertThat(OcrTextInterpreterFactory.create().extractUrl(
        "C' @ stackoverflow.com/questions/10967451/open-a-link-in-browser-with-java-button\n"),
        Is.`is`(Optional.of(URL("http://stackoverflow.com/questions/10967451/open-a-link-in-browser-with-java-button"))))
  }

  @Test
  fun stackGithub() {
    assertThat(OcrTextInterpreterFactory.create().extractUrl(
        "< C' @ https;/github.expedia.biz/Brand-Expedia/Ins-templates/pull/320/files "),
        Is.`is`(Optional.of(URL("http://github.expedia.biz/Brand-Expedia/Ins-templates/pull/320/files"))))
  }
}