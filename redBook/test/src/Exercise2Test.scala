package redBook.test

import redBook.Exercise2

class Exercise2Test extends UnitSpec {

	def ordered(a: Int, b: Int): Boolean = a > b

	val sortedA = Array(1,2,3,4,5,6,7,8,9)
	val unsorted = Array(1,2,3,4,5,6,7,8,0)
	val oneElem = Array(1)

	"isSorted" should "return true for empty or one elem array" in {
		Exercise2.isSorted[Int](Array.empty[Int], ordered) shouldBe true
		Exercise2.isSorted[Int](oneElem, ordered) shouldBe true
	}

	it should "return true for sorted array" in {
		Exercise2.isSorted[Int](sortedA, ordered) shouldBe true
	}

	it should "return false for unsorted array" in {
		Exercise2.isSorted[Int](unsorted, ordered) shouldBe false
	}

}