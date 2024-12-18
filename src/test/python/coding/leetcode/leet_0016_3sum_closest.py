import unittest

import math


class Leet00163SumClosestTest(unittest.TestCase):

    # [-1,2,1,-4], target = 1
    # [-4,-1,1,2]
    def threeSumClosest(self, nums: list[int], target: int) -> int:
        if len(nums) < 3:
            raise Exception("nums is too small for a 3 sum")

        sorted_nums = nums.copy()
        sorted_nums.sort()
        closest_sum = math.inf
        for i in range(0, len(sorted_nums)):
            for j in range(i+1, len(sorted_nums)):
                for k in range(j+1, len(sorted_nums)):
                    new_sum = sorted_nums[i] + sorted_nums[j] + sorted_nums[k]
                    if abs(new_sum - target) < abs(closest_sum-target):
                        closest_sum = new_sum
        return closest_sum

    def test_example1(self):
        assert self.threeSumClosest([-1,2,1,-4], 1) == 2

    def test_example2(self):
        assert self.threeSumClosest([0,0,0], 1) == 0

    def test_big_case(self):
        assert self.threeSumClosest(
            [779,967,867,32,-774,426,391,914,-862,-642,74,-707,-498,190,656,-964,764,746,-697,245,135,-770,-715,-568,-75,124,-738,770,313,45,-648,-296,-871,-208,237,482,-739,63,-211,-599,-921,678,858,-904,-49,312,892,659,-392,-287,557,-436,795,94,126,768,-710,-6,689,-521,890,-321,578,179,-182,-661,-822,-473,760,-696,-850,836,-149,985,692,-156,-934,806,-986,-762,486,137,-670,-577,904,-5,968,-780,-852,830,496,990,809,881,-961,368,969,490,606,-633,-63,-701,159,896,64,977,510,68,118,-785,294,595,-384,-157,-932,161,723,-614,951,657,331,-451,833,-48,207,566,919,-504,878,-316,425,399,143,-587,785,-440,-818,-454,-905,-135,430,622,-640,-736,503,-10,429,912,706,-142,740,-576,285,-278,-683,-704,-918,363,932,-859,587,-954,373,-751,901,897,802,-41,97,948,576,843,191,-32,728,234,102,492,521,694,-273,396,610,424,599,680,-70,-468,-246,992,-902,-759,-857,854,743,322,674,100,-516,484,-702,-117,744,-397,-81,-570,269,-636,-339,820,565,-220,80,-22,107,501,-479,-19,-419,263,672,643,876,736,302,773,-725,718,247,667,-33,742,-456,-609,366,-947,605,-537,662,-199,-452,-619,-66,581,653,-680,361,-101,-204,-854,356,-207,958,468,-989,983,404,156,549,-464,227,-347,-860,111,-639,358,-635,406,-180,966,-475,297,-93,877,-868,-733,-679,410,473,-685,491,580,-102,887,542,-354,219,-92,-617,-44,355,-40,-682,421,-972,-238,787,351,268,934,796,513,-668,140,-781,-650,-35,-580,509,57,-55,-391,-767,812,23,-162,-789,129,-945,409,439,340,-185,607,138,240,162,-474],
            -6847
        ) == -6847
