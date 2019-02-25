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
			case Nil => throw new NoSuchElementException("No tail for empty list")
			case Cons(_, tail) => tail
		}

		def setHead[A](list: List[A], newHead: A) = list match {
			case  Nil => throw new NoSuchElementException("No head for empty list")
			case Cons(_, tail) => Cons(newHead, tail)
		}

		def drop[A](l: List[A], n: Int): List[A] = l match {
				case Cons(_, tail) => if(n == 0) l else drop(tail, n-1)
				case  _ => Nil
			}

		def dropWhile[A](l: List[A], f: A=>Boolean): List[A] = l match {
				case Cons(head, tail) => if(f(head)) dropWhile(tail, f) else l
				case _ => Nil
			}

		def revert[A](l: List[A]): List[A] = {
			def loop(left: List[A], right: List[A]): List[A] = left match {
				case Nil => right
					case Cons(head, tail) => loop(tail, Cons(head, right))
			}
			loop(l, Nil)
		}

		def init[A](l: List[A]): List[A] = {
			def loop(left: List[A], right: List[A]): List[A] = right match {
				case Cons(_, Nil) => left
				case Cons(head, tail) => loop(Cons(head, left), tail)
				case Nil => throw new NoSuchElementException("Init of empty element")
			}
			revert(loop(Nil, l))
		}

		def plus[A](l: List[A], r: List[A]): List[A] = revert(l) match {
			case Nil => r
			case Cons(head, tail) => plus(tail, Cons(head, r))
		}

	}

}