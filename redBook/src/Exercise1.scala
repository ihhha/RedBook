package redBook

object Exercise1 {

	def func(n: Int): Int = {
		def helper(prev1: Int, prev2: Int, count: Int): Int = {
			if(n == 0) 0
			else if(n == 1) 1
			else count match {
				case c if(c > n-1) => prev1 + prev2
				case _ => helper(prev2, prev1 + prev2, count + 1)
			}
		}
		helper(0,1,2)
	}
}