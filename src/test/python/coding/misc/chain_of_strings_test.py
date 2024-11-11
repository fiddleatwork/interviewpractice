import unittest

def check_chain(
        first_char: str,
        last_char: str,
        remaining: list[str],
) -> bool:
    if not remaining:
        return last_char == first_char
    starts_with = [word for word in remaining if word[0] == last_char]
    for word in starts_with:
        if check_chain(first_char, word[-1], [c for c in remaining if c != word]):
            return True
    return False

def is_chainable(input: list[str]):
    if not input:
        return False
    return check_chain(
        input[0][0],
        input[0][-1],
        input[1:],
    )


class ChainOfStringsTest(unittest.TestCase):

    def test_example_1_can_chain(self):
        self.assertTrue(is_chainable(["aab", "bac", "aaa", "cda"]))

    def test_example_2_cannot_chain(self):
        self.assertFalse(is_chainable(["aaa", "bbb"]))

    def test_multiple_possible_chains(self):
        self.assertTrue(is_chainable(["abc", "bca", "cab"]))

    def test_dead_end(self):
        self.assertFalse(is_chainable(["abc", "bcd", "cde"]))

    def test_overlapping_strings(self):
        self.assertFalse(is_chainable(["ab", "abc"]))

    def test_basic_chainable_example_with_3_strings(self):
        self.assertFalse(is_chainable(["abc", "cde", "eab"]))

    def test_chainable_with_repeated_characters(self):
        self.assertFalse(is_chainable(["aab", "bbc", "cca", "aad"]))

    def test_all_strings_with_same_first_and_last_character(self):
        self.assertFalse(is_chainable(["aba", "cac", "ded", "efe"]))

    def test_larger_set_of_chainable_strings(self):
        self.assertTrue(is_chainable(["giraffe", "elephant", "tiger", "rabbit", "tapir", "rat", "tig"]))

    def test_chainable_edge_case_with_two_strings(self):
        self.assertTrue(is_chainable(["ab", "ba"]))

    def test_chainable_with_duplicate_strings(self):
        self.assertFalse(is_chainable(["aba", "aba", "bac", "cab"]))

    def test_non_chainable_due_to_single_mismatch(self):
        self.assertFalse(is_chainable(["abc", "cde", "efg"]))

    def test_non_chainable_due_to_isolated_string(self):
        self.assertFalse(is_chainable(["abc", "cba", "xyz"]))

    def test_one_string_breaks_the_circle(self):
        self.assertFalse(is_chainable(["ab", "bc", "cd", "de", "fa"]))

    def test_non_chainable_with_duplicate_strings_that_cant_chain(self):
        self.assertFalse(is_chainable(["abc", "cba", "bac", "dcb"]))

    def test_non_chainable_edge_case_with_two_strings(self):
        self.assertFalse(is_chainable(["ab", "cd"]))

    def test_self_contained_loop_but_no_complete_circle(self):
        self.assertFalse(is_chainable(["ab", "bc", "ca", "de"]))

    def test_single_string_that_can_form_a_circle(self):
        self.assertTrue(is_chainable(["aba"]))

    def test_single_string_that_cannot_form_a_circle(self):
        self.assertFalse(is_chainable(["abc"]))

    def test_empty_array(self):
        self.assertFalse(is_chainable([]))

    def test_array_of_single_character_strings_with_all_the_same_character(self):
        self.assertTrue(is_chainable(["a", "a", "a"]))

    def test_array_of_single_character_strings_with_mixed_characters(self):
        self.assertFalse(is_chainable(["a", "b", "c"]))

    def test_all_strings_with_same_start_and_end_characters_but_no_chain(self):
        self.assertFalse(is_chainable(["ab", "bc", "ca", "da"]))
