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
    
    lookup_doubles = {
        "IV": Increment(4, 2),
        "IX": Increment(9, 2),
        "XL": Increment(40, 2),
        "XC": Increment(90, 2),
        "CD": Increment(400, 2),
        "CM": Increment(900, 2),
    }

    lookup_singles = {
        "I": Increment(1, 1),
        "V": Increment(5, 1),
        "X": Increment(10, 1),
        "L": Increment(50, 1),
        "C": Increment(100, 1),
        "D": Increment(500, 1),
        "M": Increment(1000, 1),
    }

    i = 0
    result = 0
    while i < len(s):
        
        if i < len(s) - 1:
            sub2 = s[i : i + 2]
        else:
            sub2 = s[i : i + 1]
            
        increment = lookup_doubles.get(sub2)
        if increment is None:
            increment = lookup_singles[sub2[0:1]]
        result += increment.amount
        i += increment.counter

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
