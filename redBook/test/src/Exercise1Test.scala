package redBook.test

import redBook.Exercise1

class Exercise1Test extends UnitSpec {
  "Fibbonachi from 0" should "be 0" in {
    Exercise1.func(0) shouldBe 0
  }

  "Fibbonachi from 1" should "be 1" in {
    Exercise1.func(1) shouldBe 1
  }

  "Fibbonachi from 5" should "be correct" in {
    Exercise1.func(5) shouldBe 5
  }

  "Fibbonachi from 11" should "be correct" in {
    Exercise1.func(11) shouldBe 89
  }
}