package redBook

object Exercise2 {
	def isSorted[A](as: Array[A], ordered: (A,A) => Boolean ): Boolean = {
		
		def loop(index: Int): Boolean = {
			if (index == 0) true
			else if ( ordered(as(index), as(index-1)) ) loop(index-1)
			else false
		}

		if(as.isEmpty || as.size == 1) true
		else 	loop(as.size - 1)
	}

	def curry[A, B, C](f: (A, B) => C): A => (B => C) = (a: A) => ((b: B) => f(a,b))

	def uncurry[A, B, C](f: A => B => C): (A,B) => C = (a: A, b: B) => f(a)(b)

	def compose[A, B, C](f: B => C, g: A => B): A => C = (a: A) => f(g(a))

}