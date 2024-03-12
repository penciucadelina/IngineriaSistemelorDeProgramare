package isp.lab3.exercise1;

public class Tree {
    private int height;

    //constructor
    public Tree() {
        this.height = 15;
    }


    //metoda
    public void grow(int meters) {
        if (meters >= 1) {
            this.height += meters;
        }
    }

    //override
    public String toString() {
        return "Height of the tree: " + height + " meters";
    }

    public int getHeight() {
        return height;
    }

    public static void main(String[] args) {


        Tree tree1 = new Tree();
        Tree tree2 = new Tree();
        Tree tree3 = new Tree();

        tree1.grow(2);  //17
        tree2.grow(-1); //15
        tree3.grow(3);  //18

        System.out.println(tree1);
        System.out.println(tree2);
        System.out.println(tree3);

    }
}


