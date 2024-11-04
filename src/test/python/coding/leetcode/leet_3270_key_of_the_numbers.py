import unittest
from assertpy import assert_that


class TestGenerateKey(unittest.TestCase):

    def generate_key(self, num1: int, num2: int, num3: int, digits: int) -> int:
        key: list[str] = []
        num1_str = self.pad_left(num1, digits)
        num2_str = self.pad_left(num2, digits)
        num3_str = self.pad_left(num3, digits)
        for i in range(0, 4):
            key.append(min(num1_str[i], num2_str[i], num3_str[i]))
        return int(key[0] + key[1] + key[2] + key[3])

    @staticmethod
    def pad_left(num: int, digits: int) -> str:
        num_str = str(num)
        for i in range(0, digits - len(num_str)):
            num_str = "0" + num_str
        return num_str

    def test_pad_left(self):
        assert_that(self.pad_left(0, 4)).is_equal_to("0000")
        assert_that(self.pad_left(100, 4)).is_equal_to("0100")
        assert_that(self.pad_left(1000, 4)).is_equal_to("1000")

    def test_example_1(self):
        num1, num2, num3 = 1, 10, 1000
        result = self.generate_key(num1, num2, num3, 4)
        assert_that(result).is_equal_to(0)

    def test_example_2(self):
        num1, num2, num3 = 987, 879, 798
        result = self.generate_key(num1, num2, num3, 4)
        assert_that(result).is_equal_to(777)

    def test_example_3(self):
        num1, num2, num3 = 1, 2, 3
        result = self.generate_key(num1, num2, num3, 4)
        assert_that(result).is_equal_to(1)

    def test_additional_example(self):
        # Additional case to verify four-digit handling: num1 = 4321, num2 = 5432, num3 = 6543
        num1, num2, num3 = 4321, 5432, 6543
        result = self.generate_key(num1, num2, num3, 4)
        assert_that(result).is_equal_to(4321)


if __name__ == '__main__':
    unittest.main()
