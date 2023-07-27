from dataclasses import dataclass
import unittest
from types import MappingProxyType
from assertpy import assert_that
from typing import Tuple

@dataclass
class Increment:
    amount: int
    counter: int

@staticmethod
def roman_to_int(s: str) -> int:
    
    def calculate_increment_single(s: str, i: int) -> Increment:
        # print(f"s = {s}")
        match s:
            case "I" : return Increment(1, 1)
            case "V" : return Increment(5, 1)
            case "X" : return Increment(10, 1)
            case "L" : return Increment(50, 1)
            case "C" : return Increment(100, 1)
            case "D" : return Increment(500, 1)
            case "M" : return Increment(1000, 1)
            case _ :  raise Exception(f"Unrecognized symbol {s}")

    def calculate_increment(s: str, i: int) -> Increment:
        # print(f"match_double: s = {s} sub2={sub2} i={i} s[i:i]={s[i:i+1]}")
        match s:
            case "IV" : return Increment(4, 2)
            case "IX" : return Increment(9, 2)
            case "XL" : return Increment(40, 2)
            case "XC" : return Increment(90, 2)
            case "CD" : return Increment(400, 2)
            case "CM" : return Increment(900, 2)
            case _ : return calculate_increment_single(s[0:1], i)
               
    i = 0
    result = 0                                    
    while i < len(s):
        if i < len(s)-1:
            sub2 = s[i:i+2]
        else:
            sub2 = s[i:i+1]
        increment = calculate_increment(sub2, i)
        result += increment.amount
        i+= increment.counter

    return result


class Leet013RomanToNumber(unittest.TestCase):

    @staticmethod
    def test_case_1():
        assert_that(roman_to_int("III")).is_equal_to(3)

    @staticmethod
    def test_case_2():
        assert_that(roman_to_int("LVIII")).is_equal_to(58)

    @staticmethod
    def test_case_3():
        assert_that(roman_to_int("MCMXCIV")).is_equal_to(1994)


if __name__ == "__main__":
    unittest.main()
