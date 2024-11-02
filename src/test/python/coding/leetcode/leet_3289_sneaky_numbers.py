import unittest
from itertools import groupby

from assertpy import assert_that


def find_two_duplicates(nums: list[int]) -> list[int]:
    sorted_nums = nums.copy()
    sorted_nums.sort()
    grouped = {key: list(group) for key, group in groupby(sorted_nums)}
    result = [key for key, group in grouped.items() if len(group) > 1]
    return result


class Leet3289SneakyNumbersOfDigitville(unittest.TestCase):

    def test_example_1(self):
        nums = [0, 1, 1, 0]
        expected_output = [0, 1]
        result = find_two_duplicates(nums)
        assert_that(result).contains_only(*expected_output)

    def test_example_2(self):
        nums = [0, 3, 2, 1, 3, 2]
        expected_output = [2, 3]
        result = find_two_duplicates(nums)
        assert_that(result).contains_only(*expected_output)

    def test_example_3(self):
        nums = [7, 1, 5, 4, 3, 4, 6, 0, 9, 5, 8, 2]
        expected_output = [4, 5]
        result = find_two_duplicates(nums)
        assert_that(result).contains_only(*expected_output)
