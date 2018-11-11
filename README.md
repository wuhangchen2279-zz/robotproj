# Documentation
How to run app:
1. Download the application from github by running command - git clone https://github.com/wuhangchen2279/robotproj.git
2. Put all robot commands under input.txt in the root directory
3. compile project: run command - mvn clean install
3. run project - mvn exec:java
4. run unit testing - mvn test

Assumption:
1. robot will move within a 5*5 table
2. all robot commands are read from input.txt in the root directory
3. Each line in the input.txt contains only one command
4. The program only support PLACE, MOVE, LEFT, RIGHT, REPORT commands
5. Robot can only face 4 directions: NORTH, WEST, EAST, SOUTH

Design Decision:
1. Each type of commands extends from parent abstract Command class. Each child command will define the implementation of commnd execute method.
2. Command make use of the robot, so that it can tell how the robot should behaviour for different types of command
3. Command handler is the central place to manage the full list of commands in the app, and provides easier way to excute all commands.
4. Command File Reader extends from Reader abstract class, and the command file reader define how to read the commands from file.
5. Define Robot's facing direction to have NORTH, SOUTH, EAST, WEST. And it also holds the information to check if the direction is horizontal or vertical, as well as the index for rotating left and right.
6. Robot implements RobotAction interface, and the robot gives the implementation for all robot behaviours. Robot holds the reference to the table, then it is easier to check if the robot is on the table or not.

Unit tests I made:
1. Robot Test
* Test Case 1: test robot place command. A place command will place a robot at a position within the table and specify its facing direction
* Test Case 2: test robot move command. A valid move command will move a robot one step forward according to its facing direction
* Test Case 3: test robot rotating left command. A valid left command will rotate a robot 90 degree on its left side.
* Test Case 4: test robot rotating right left command. A valid right command will rotate a robot 90 degree on its right side
* Test Case 5: test robot report command. A valid report command will print out the robot current position and its facing direction
* Test Case 6: if robot is not the table, the robot will ignore move command
* Test Case 7: if robot is not the table, the robot will ignore rotate left command
* Test Case 8: if robot is not the table, the robot will ignore rotate right command
* Test Case 9: if robot is not the table, the robot will ignore report command
* Test Case 10: ignore horizontal move which may cause robot move out of the table
* Test Case 11: ignore vertical move which may cause robot move out of the table


2. Command Handler Test
* Test Case 1: the first valid command must be place command
* Test Case 2: the initial place command must be on the table
* Test Case 3: After we have the first valid place command, any other commands can be entered in any sequence.
* Test Case 4: multiple place commands can be accepted

