//给你一个在 XY 平面上的 width x height 的网格图，左下角 的格子为 (0, 0) ，右上角 的格子为 (width - 1, height
// - 1) 。网格图中相邻格子为四个基本方向之一（"North"，"East"，"South" 和 "West"）。一个机器人 初始 在格子 (0, 0) ，方
//向为 "East" 。 
//
// 机器人可以根据指令移动指定的 步数 。每一步，它可以执行以下操作。 
//
// 
// 沿着当前方向尝试 往前一步 。 
// 如果机器人下一步将到达的格子 超出了边界 ，机器人会 逆时针 转 90 度，然后再尝试往前一步。 
// 
//
// 如果机器人完成了指令要求的移动步数，它将停止移动并等待下一个指令。 
//
// 请你实现 Robot 类： 
//
// 
// Robot(int width, int height) 初始化一个 width x height 的网格图，机器人初始在 (0, 0) ，方向朝 "Ea
//st" 。 
// void move(int num) 给机器人下达前进 num 步的指令。 
// int[] getPos() 返回机器人当前所处的格子位置，用一个长度为 2 的数组 [x, y] 表示。 
// String getDir() 返回当前机器人的朝向，为 "North" ，"East" ，"South" 或者 "West" 。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：
//["Robot", "move", "move", "getPos", "getDir", "move", "move", "move", "getPos"
//, "getDir"]
//[[6, 3], [2], [2], [], [], [2], [1], [4], [], []]
//输出：
//[null, null, null, [4, 0], "East", null, null, null, [1, 2], "West"]
//
//解释：
//Robot robot = new Robot(6, 3); // 初始化网格图，机器人在 (0, 0) ，朝东。
//robot.move(2);  // 机器人朝东移动 2 步，到达 (2, 0) ，并朝东。
//robot.move(2);  // 机器人朝东移动 2 步，到达 (4, 0) ，并朝东。
//robot.getPos(); // 返回 [4, 0]
//robot.getDir(); // 返回 "East"
//robot.move(2);  // 朝东移动 1 步到达 (5, 0) ，并朝东。
//                // 下一步继续往东移动将出界，所以逆时针转变方向朝北。
//                // 然后，往北移动 1 步到达 (5, 1) ，并朝北。
//robot.move(1);  // 朝北移动 1 步到达 (5, 2) ，并朝 北 （不是朝西）。
//robot.move(4);  // 下一步继续往北移动将出界，所以逆时针转变方向朝西。
//                // 然后，移动 4 步到 (1, 2) ，并朝西。
//robot.getPos(); // 返回 [1, 2]
//robot.getDir(); // 返回 "West"
//
// 
//
// 
//
// 提示： 
//
// 
// 2 <= width, height <= 100 
// 1 <= num <= 105 
// move ，getPos 和 getDir 总共 调用次数不超过 104 次。 
// 
// Related Topics 设计 模拟 
// 👍 20 👎 0


import com.sun.org.apache.regexp.internal.REUtil;

import java.util.UUID;

//leetcode submit region begin(Prohibit modification and deletion)
class Robot {

    int width;// 宽最大值
    int height;// 高最大值
    int direction;// "East"为1，"North"为2，"West"为3，"South"为4。
    int x;
    int y;

    // 构造函数
    public Robot(int width, int height) {
        x = 0;
        y = 0;
        direction = 0;
        this.width = width;
        this.height = height;
    }

    /**
     * 根据题意来看，机器人只能在边缘移动
     * @param num
     */
    public void step(int num) {

        int sum = 2 * width + 2 * height - 4;
        if (num >= sum) {
            num %= sum;
            //注意再次回到原点时，方向是向南
            if (x == 0 && y == 0) {
                direction = 3;
            }
        }

        while (num > 0) {
//            if (direction == 1 && x == width-1) {
//                // 朝向East，并且x=maxWidth
//                direction = 2;
//            } else if (direction == 2 && y == height-1) {
//                // 朝向North，并且y=maxHeight
//                direction = 3;
//            } else if (direction == 3 && x == 0) {
//                // 朝向West，并且x=0
//                direction = 4;
//            } else if (direction == 4 && y == 0) {
//                // 朝向South，并且y=0
//                direction = 1;
//            }


            if (direction == 0 && x < width - 1) {
                // 机器人朝向East
                ++x;
                --num;
            } else if (direction == 1 && y < height - 1) {
                // 机器人朝向North
                ++y;
                --num;
            } else if (direction == 2 && x > 0) {
                // 机器人朝向West
                --x;
                --num;
            } else if (direction == 3 && y > 0) {
                // 机器人朝向South
                --y;
                --num;
            } else {
                direction = (direction + 1) % 4;
            }

        }
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    public String getDir() {
        switch (direction) {
            case 0: return "East";
            case 1:return "North";
            case 2: return "West";
            case 3: return "South";
        }
        return "East";

    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */
//leetcode submit region end(Prohibit modification and deletion)
