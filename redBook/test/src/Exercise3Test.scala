package redBook.test

import redBook.Exercise3

class Exercise3Test extends UnitSpec with Exercise3 {

	val emptyList = List[Int]()
	val list9 = List(1,2,3,4,5,6,7,8,9)
	val list3 = List(1,2,3)

	"List" should "create empty list" in {
		emptyList shouldBe Nil
	}

	it should "create list" in {
		list3 shouldBe Cons(1,Cons(2,Cons(3,Nil)))
	}

	"Tail" should "return tail of the list" in {
		List.tail(list9) shouldBe List(2,3,4,5,6,7,8,9)
	}

	it should "return exception on empty List" in {
		an [EmptyListException] should be thrownBy List.tail(emptyList)
	}

	"SetHead" should "return exception on empty List" in {
		an [EmptyListException] should be thrownBy List.setHead(emptyList, 0)
	}

	it should "set new head for list" in {
		List.setHead(list9, 0) shouldBe List(0,2,3,4,5,6,7,8,9)
	}

	"Drop" should "return empty list for empty" in {
		List.drop(emptyList, 5) shouldBe Nil
	}

	it should "drop first 2 elem of list" in {
		List.drop(list9, 2) shouldBe List(3,4,5,6,7,8,9)
	}

	it should "return empty if n > size of list" in {
		List.drop(list3, 5) shouldBe Nil
	}

	"dropWhile" should "same list if predicate false" in {
		List.dropWhile(list9, {x: Int  => x < 0}) shouldBe list9
	}

	it should "return correct answer" in {
		List.dropWhile(list9, {x: Int  => x < 4}) shouldBe List(4,5,6,7,8,9)
	}

}
