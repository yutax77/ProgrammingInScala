abstract class Component {
	def topLeft: Point
	def bottomRight: Point
	def left = topLeft.x
	def right = bottomRight.x
	def width = right - left
}
