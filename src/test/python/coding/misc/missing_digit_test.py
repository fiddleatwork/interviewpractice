import unittest

from assertpy import assert_that


def missing_digit(input: str) -> str:
    tokens = move_x_to_left_side(input.split(" "))
    print(f"tokens: {tokens}")

    operator = tokens[1]
    rhs = calculate_right_hand_side(operator, tokens)
    print(f"rhs: {rhs}")
    return solve_x(tokens[0], str(rhs))


def calculate_right_hand_side(operator: str, tokens: list[str]) -> int:
    if operator != "=":
        inverse_operators = {
            "/": lambda a,b: a*b,
            "*": lambda a,b: a/b,
            "+": lambda a,b: a-b,
            "-": lambda a,b: a+b,
        }
        return inverse_operators[operator](int(tokens[4]), int(tokens[2]))
    else:
        operators = {
            "*": lambda a,b: a*b,
            "/": lambda a,b: a/b,
            "+": lambda a,b: a+b,
            "-": lambda a,b: a-b,
        }
        return operators[tokens[3]](int(tokens[2]), int(tokens[4]))



def solve_x(left: str, right:str) -> str:
    return right[left.find('x')]

def move_x_to_left_side(tokens: list[str])->list[str]:
    equals_index = tokens.index("=")
    x_index = next((i for i, item in enumerate(tokens) if "x" in item), None)
    if x_index < equals_index:
        return tokens
    #         0 1 2 3 4
    # tokens: 2,-,4,=,x
    # equalsIndex = 3
    # xIndex = 4
    return tokens[equals_index+1:] + ["="] + tokens[:equals_index]

class MissingDigitTest(unittest.TestCase):

    @staticmethod
    def test_flip_tokens_to_put_x_on_left_side() -> None:
        assert_that(
            move_x_to_left_side(["x", "=", "4", "-", "2"])
        ).is_equal_to(["x", "=", "4", "-", "2"])
        assert_that(
            move_x_to_left_side(["4", "-", "2", "=", "x"])
        ).is_equal_to(["x", "=", "4", "-", "2"])

    @staticmethod
    def test_solve_x() -> None:
        assert_that(solve_x("3x", "34")).is_equal_to("4")
        assert_that(solve_x("1x0", "100")).is_equal_to("0")

    @staticmethod
    def test_example_1() -> None:
        # 3x + 12 = 46 -> 3x = 46 - 12 -> 3x = 34 -> x = 4
        assert_that(missing_digit("3x + 12 = 46")).is_equal_to("4")

    @staticmethod
    def test_example_2a() -> None:
        # 4 - 2 = x -> x = 4 - 2 -> x = 2
        assert_that(missing_digit("4 - 2 = x")).is_equal_to("2")

    @staticmethod
    def test_example_2b() -> None:
        # x = 4 - 2 -> x = 2
        assert_that(missing_digit("x = 4 - 2")).is_equal_to("2")

    @staticmethod
    def test_example_3() -> None:
        # 1x0 * 12 = 1200 -> 1x0 = 1200 / 12 -> 1x0 = 100 -> x = 0
        assert_that(missing_digit("1x0 * 12 = 1200")).is_equal_to("0")