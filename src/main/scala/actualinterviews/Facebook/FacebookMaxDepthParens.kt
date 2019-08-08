package actualinterviews.Facebook

/**
Welcome to Facebook!

This is just a simple shared plaintext pad, with no execution capabilities.

When you know what language you'd like to use for your interview,
simply choose it from the dropdown in the top bar.

Enjoy your interview!


Write a function that takes a string as an input and returns the maximum depth of parentheses in this string

String -> Int

() -> 1
()() - > 1
(()) -> 2
()(()) -> 2
(() -> throw InvalidParenthesesException()
-> 0
)( -> throw InvalidParenthesesException()
 */

const val OPEN: Char = '('
const val CLOSE: Char = ')'

//((({[<>]})))

// depths: HashMap<Char, Int> = hashMapOf( '(' to 3, '{' to 1, '[' to 1)

fun maxParenDepth(input: String): Int {
    // keep track of opens and closes and make sure it's balanced
    var parens: Int = 0
    var maxDepth: Int = 0

    input.forEach { c ->
        when (c) {
            OPEN -> {
                parens += 1
                if (parens > maxDepth) maxDepth = parens
            }
            CLOSE -> {
                parens -= 1
                if (parens < 0) throw InvalidParenthesesException()
            }
        }
    }
    if (parens != 0) throw InvalidParenthesesException()

    return maxDepth
}

class InvalidParenthesesException() : Exception()