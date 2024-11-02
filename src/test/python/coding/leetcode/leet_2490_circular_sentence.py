import unittest

from assertpy import assert_that


def is_circular_sentence(sentence: str) -> bool:
    words = sentence.split(" ")
    for i in range(0, len(words)):
        next_word = words[i+1] if i < len(words)-1 else words[0]
        if words[i][-1] != next_word[0]:
            return False
    return True

class Leet2490CircularSentenceTest(unittest.TestCase):

    @staticmethod
    def test_example_1():
        # Example 1: "leetcode exercises sound delightful"
        sentence = "leetcode exercises sound delightful"
        expected_output = True
        assert_that(is_circular_sentence(sentence)).is_equal_to(expected_output)

    @staticmethod
    def test_example_2():
        # Example 2: "eetcode"
        sentence = "eetcode"
        expected_output = True
        assert_that(is_circular_sentence(sentence)).is_equal_to(expected_output)

    @staticmethod
    def test_example_3():
        # Example 3: "Leetcode is cool"
        sentence = "Leetcode is cool"
        expected_output = False
        assert_that(is_circular_sentence(sentence)).is_equal_to(expected_output)


