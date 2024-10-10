package code

/**
 * 二分法查找
 */

fun main() {

    binarySearch()
}

/**
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4,
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 */
private fun binarySearch() {
    val nums = intArrayOf(-1, 0, 3, 3, 5, 9, 12)
    val target = 3
    val lowIndex = 0
    val highIndex = nums.size - 1

    val result = binarySearch2(nums, target, lowIndex, highIndex)
    println("result: $result")
}

private fun binarySearch1(
    nums: IntArray,
    target: Int,
    lowIndex: Int,
    highIndex: Int,
): Int {
    // 终止条件
    if (lowIndex > highIndex) {
        return -1
    }
    // 中间值的取值
    val middleIndex = lowIndex + (highIndex - lowIndex) / 2
    val middleValue = nums[middleIndex]

    return when {
        middleValue == target -> middleIndex

        middleValue > target -> binarySearch1(nums, target, lowIndex, middleIndex - 1) // 记得 -1

        else -> binarySearch1(nums, target, middleIndex + 1, highIndex) // 记得 + 1
    }
}

/**
 *  查找第一个值等于给定值的元素
 * 输入: nums = [-1,0,3,3,5,9,12], target = 3
 * 输出: 2
 * 解释: 第一个 3 出现在 nums 中并且下标为 2,
 */
private fun binarySearch2(
    nums: IntArray,
    target: Int,
    lowIndex: Int,
    highIndex: Int,
): Int {
    // 终止条件
    if (lowIndex > highIndex) {
        return -1
    }
    // 中间值的取值
    val middleIndex = lowIndex + (highIndex - lowIndex) / 2
    val middleValue = nums[middleIndex]

    return when {
        middleValue == target -> {
            var lessIndex = middleIndex
            while (lessIndex > 0 && nums[lessIndex -1] == target) {
                lessIndex--
            }
            lessIndex
        }

        middleValue > target -> binarySearch1(nums, target, lowIndex, middleIndex - 1) // 记得 -1

        else -> binarySearch1(nums, target, middleIndex + 1, highIndex) // 记得 + 1
    }
}