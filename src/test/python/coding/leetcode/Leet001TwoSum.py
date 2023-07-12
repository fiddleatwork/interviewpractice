import unittest
from types import MappingProxyType
from assertpy import assert_that
from typing import Tuple


class MyTestCase(unittest.TestCase):

    @staticmethod
    def two_sum_brute(nums: Tuple[int, ...], target: int) -> Tuple[int, ...]:
        for i, m in enumerate(nums):
            for j, n in enumerate(nums):
                if i != j and m + n == target:
                    return i, j
        return ()

    @staticmethod
    def two_sum(nums: Tuple[int, ...], target: int) -> Tuple[int, ...]:
        lookup = MappingProxyType({target - nums[i]: i for i, _ in enumerate(nums)})
        for i, n in enumerate(nums):
            m = lookup.get(n, None)
            if m is not None and m != i:
                return i, m
        return ()

    @staticmethod
    def test_case_1():
        assert_that(
            MyTestCase.two_sum((2, 7, 11, 15), 9)
        ).is_equal_to((0, 1))  # add assertion here


if __name__ == '__main__':
    unittest.main()
