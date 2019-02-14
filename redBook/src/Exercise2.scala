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
}