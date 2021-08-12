class Solution(object):
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums = [0] + nums;
        nums.sort()
        for i in range(1,len(nums)):
            if (nums[i] < 0):
                continue
                
            if (nums[i] - nums[i-1] > 1):
                if (nums[i-1]+1 > 0):
                    return nums[i-1]+1
        
        return max(1,nums[len(nums)-1]+1)
