import unittest
from assertpy import assert_that

def letter_to_int(letter: str) -> int:
    return ord(letter) - ord('a') + 1

def color(coordinate: str) -> int:
    # 0 == black
    # 1 == white
    return (letter_to_int(coordinate[0]) + int(coordinate[1])) % 2

def same_color(coordinate1: str, coordinate2: str) -> bool:
    return color(coordinate1) == color(coordinate2)

class TestSameColor(unittest.TestCase):

    def test_example_1(self):
        # Example 1: Both squares "a1" and "c3" are black
        coordinate1 = "a1"
        coordinate2 = "c3"
        expected_output = True
        assert_that(same_color(coordinate1, coordinate2)).is_equal_to(expected_output)

    def test_example_2(self):
        # Example 2: Square "a1" is black, square "h3" is white
        coordinate1 = "a1"
        coordinate2 = "h3"
        expected_output = False
        assert_that(same_color(coordinate1, coordinate2)).is_equal_to(expected_output)

