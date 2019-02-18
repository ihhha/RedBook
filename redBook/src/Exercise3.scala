package redBook

trait Exercise3 {
	sealed trait List[+A]
	case object Nil extends List[Nothing]
	case class Cons[+A](head: A, tail: List[A]) extends List[A]

	final class EmptyListException(private val message: String = "", 
		private val cause: Throwable = None.orNull
	) extends Exception(message, cause)

	object List {

		def apply[A](a: A*): List[A] = if(a.isEmpty) Nil else Cons(a.head, apply(a.tail: _*))

		def tail[A](list: List[A]) = list match {
			case Nil => throw new EmptyListException("No tail for empty list")
			case Cons(_, tail) => tail
		}

		def setHead[A](list: List[A], newHead: A) = list match {
			case  Nil => throw new EmptyListException("No head for empty list")
			case Cons(_, tail) => Cons(newHead, tail)
		}

		def drop[A](l: List[A], n: Int): List[A] = {
			def loop(count: Int, tempList: List[A]): List[A] = tempList match {
				case Cons(_, tail) => if(count == n-1) tail else loop(count + 1, tail)
				case  nil => nil
			}

			loop(0,l)
		}

		def dropWhile[A](l: List[A], f: A=>Boolean): List[A] = {
			def loop(count: Int, tempList: List[A]): List[A] = tempList match {
				case Cons(head, tail) => if(f(head)) loop(count + 1, tail) else tempList
				case nil => nil
			}

			loop(0,l)
		}

	}

}