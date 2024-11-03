import unittest
from itertools import takewhile, groupby

from assertpy import assert_that


class Leet3330FindTheOriginalTypedString(unittest.TestCase):


    def find_possible_words_count_optimal(self, word: str) -> int:
        total = 1
        for g, t in groupby(word):
            total += len(list(t)) - 1
        return total

    @staticmethod
    def find_possible_words_count(word: str) -> int:
        count = 1
        previous_char: str | None = None
        for i in range(0, len(word)):
            print(f"i = {i}")
            if word[i] != previous_char or previous_char is None:
                combos = Leet3330FindTheOriginalTypedString.count_variations(word[i:])
                count = count + combos
                previous_char = word[i]
        return count

    @staticmethod
    def count_variations(word: str) -> int:
        if not word:
            return 0
        return sum(1 for _ in takewhile(lambda x: x == word[0], word)) -1

    def test_count_variations(self) -> None:
        assert_that(self.count_variations("abc")).is_equal_to(0) # no variations, only the original
        assert_that(self.count_variations("aabc")).is_equal_to(1) # only one variation (removing the a)
        assert_that(self.count_variations("aaabc")).is_equal_to(2) # two variations (remove 1 a or remove two a's)
        assert_that(self.count_variations("a")).is_equal_to(0)
        assert_that(self.count_variations("ab")).is_equal_to(0)
        assert_that(self.count_variations("")).is_equal_to(0)

    def test_example_1(self) -> None:
        assert_that(self.find_possible_words_count("abbcccc")).is_equal_to(5)

    def test_example_2(self) -> None:
        assert_that(self.find_possible_words_count("abcd")).is_equal_to(1)

    def test_example_3(self) -> None:
        assert_that(self.find_possible_words_count("aaaa")).is_equal_to(4)

    def test_ere(self) -> None:
        assert_that(self.find_possible_words_count("ere")).is_equal_to(1)
