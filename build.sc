import mill._, scalalib._

object RedBook extends ScalaModule {
	def scalaVersion = "2.12.8"

	def scalacOptions = Seq(
		"-deprecation",
		"-feature",
		"-unchecked",
		"-encoding", "utf8",
		"-Ypartial-unification",
		"-Ywarn-unused:_",
		"-Xfatal-warnings",
		"-Xlint:unsound-match"
	)

	def ivyDeps = Agg(ivy"org.scalatest::scalatest:3.0.5")

	object test extends Tests {
		def testFrameworks = Seq("org.scalatest.tools.Framework")		
	}
}