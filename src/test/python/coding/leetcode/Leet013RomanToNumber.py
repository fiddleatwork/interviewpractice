import unittest
from types import MappingProxyType
from assertpy import assert_that
from typing import Tuple


class Leet013RomanToNumber(unittest.TestCase):

    @staticmethod
    def romanToInt(s: str) -> int:
        i = 0
        result = 0

        def increment(amount: int, counterIncrement: int):
            nonlocal result
            nonlocal i
            result += amount
            i+= counterIncrement

        def match_single(s: str, i: int):
            print(f"s = {s}")
            match s:
                case "I" : increment(1, 1)
                case "V" : increment(5, 1)
                case "X" : increment(10, 1)
                case "L" : increment(50, 1)
                case "C" : increment(100, 1)
                case "D" : increment(500, 1)
                case "M" : increment(1000, 1)
                case _ :  raise Exception(f"Unrecognized symbol {s}")

        def match_double(s: str, sub2: str, i: int):
            print(f"match_double: s = {s} sub2={sub2} i={i} s[i:i]={s[i:i+1]}")
            match sub2:
                case "IV" : increment(4, 2)
                case "IX" : increment(9, 2)
                case "XL" : increment(40, 2)
                case "XC" : increment(90, 2)
                case "CD" : increment(400, 2)
                case "CM" : increment(900, 2)
                case _ : match_single(s[i:i+1], i)
                                     
        while i < len(s):
            if i < len(s)-1:
                sub2 = s[i:i+2]
            else:
                sub2 = ""
            match_double(s, sub2, i)

        return result


    @staticmethod
    def test_case_1():
        assert_that(Leet013RomanToNumber.romanToInt("III")).is_equal_to(3)

    @staticmethod
    def test_case_2():
        assert_that(Leet013RomanToNumber.romanToInt("LVIII")).is_equal_to(58)

    @staticmethod
    def test_case_3():
        assert_that(Leet013RomanToNumber.romanToInt("MCMXCIV")).is_equal_to(1994)


if __name__ == "__main__":
    unittest.main()
