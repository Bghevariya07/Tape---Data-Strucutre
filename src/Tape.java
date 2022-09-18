import java.util.Stack;

/**
 * CSCI 2110: PoW 2
 * This class creates an object called tape
 * It is inspired from the Turing's Machine and works exactly like a tape.
 * It contains two stacks and its writing cursor is on the top element of the right stack
 * All the elements in the tape are described as a bit
 * @author Bhavya Ghevariya
 * BannerID: B00872733
 * Email: B.Ghevariya@dal.ca
 */
public class Tape {

    //Declaration of instance stacks
    Stack<bit> leftSide;
    Stack<bit> rightSide;

    /**
     * This constructor creates a tape object
     */
    public Tape() {

        //Assign new stacks to the instance variables
        leftSide = new Stack<>();
        rightSide = new Stack<>();
    }

    /**
     * This method writes the data to the cell
     * @param x bit - data that needs to be written
     */
    public void writeToCell(bit x) {

        //If condition to check if the right stack is empty
        if (rightSide.size() == 0) {

            //Create a new cell with 0 value
            rightSide.push(new bit());
        }

        //Write the data into the first cell
        rightSide.pop();
        rightSide.push(x);
    }

    /**
     * This method reads the data from the cell
     * @return bit - the data that is written in the current cell
     */
    public bit readFromCell() {

        //If condition to check if the right stack is empty
        if (rightSide.size() == 0) {

            //Create a new cell with 0 value
            rightSide.push(new bit());
        }

        //Return the read data from the current cell
        return rightSide.peek();
    }

    /**
     * This method moves one cell to left
     * for that it transfers top element of the left stack
     * to the right stack which will be current cell
     */
    public void moveLeftOneCell() {

        //If condition to check if the right stack is empty
        if (rightSide.size() == 0) {

            //Add a new element with value 0
            rightSide.push(new bit());
            return;
        }

        //If condition to check if the left stack is empty
        if (leftSide.size() == 0) {

            //Add a new element with value 0
            leftSide.push(new bit());
        }

        //Add element from the left stack to right stack
        rightSide.push(leftSide.pop());
    }

    /**
     * This method moves one cell to right
     * for that it transfers top element of the right stack
     * to the left stack which will make the right stack's top cell current
     */
    public void moveRightOneCell() {

        //This method checks if the right stack is empty or not
        if (rightSide.size() == 0) {

            //Add a new element with 0 value
            rightSide.push(new bit());
            return;
        }

        //Add element from the right stack to the left stack
        leftSide.push(rightSide.pop());

        //Check if the right stack has only one element
        if (rightSide.size() == 1) {

            //Add a new element with 0 value
            rightSide.push(new bit());
        }
    }

    /**
     * This class creates a bit object and contains method to manipulate it
     */
    public static class bit {

        //an instance bit
        private final char bit;

        /**
         * This constructor creates a new bit
         * It creates a bit with value 0
         */
        public bit() {

            //Assign 0 to the current bit
            this.bit = '0';
        }

        /**
         * This constructor creates a new bit with the given value
         * @param x char - the value of the bit
         */
        public bit(char x) {

            //Assign the value to the bit
            this.bit = x;
        }

        /**
         * This method coverts the bit to a string
         * @return A String of the bit
         */
        public String toString() {
            String bitString = "";
            return bitString + bit;
        }
    }
}
