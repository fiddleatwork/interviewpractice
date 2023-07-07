import unittest

from assertpy import assert_that


class MyTestCase(unittest.TestCase):

    @staticmethod
    def two_sum_brute(nums: int(), target: int) -> int():
        for i, m in enumerate(nums):
            for j, n in enumerate(nums):
                if i != j and m + n == target:
                    return i, j
        return ()



    @staticmethod
    def test_case_1():
        assert_that(
            MyTestCase.two_sum_brute((2, 7, 11, 15), 9)
        ).is_equal_to((0, 1))  # add assertion here


if __name__ == '__main__':
    unittest.main()
