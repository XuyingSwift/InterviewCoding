package BinarySearchTree.XuyingBinaryTree.NumberOfBST;

public class BstNum {

    // A function to find
// factorial of a given number
    static int factorial(int n)
    {
        int res = 1;

        // Calculate value of
        // [1*(2)*---*(n-k+1)] /
        // [k*(k-1)*---*1]
        for (int i = 1; i <= n; ++i)
        {
            res *= i;
        }

        return res;
    }

    static int binomialCoeff(int n,
                             int k)
    {
        int res = 1;

        // Since C(n, k) = C(n, n-k)
        if (k > n - k)
            k = n - k;

        // Calculate value of
        // [n*(n-1)*---*(n-k+1)] /
        // [k*(k-1)*---*1]
        for (int i = 0; i < k; ++i)
        {
            res *= (n - i);
            res /= (i + 1);
        }

        return res;
    }

    // A Binomial coefficient
// based function to find
// nth catalan number in
// O(n) time
    static int catalan( int n)
    {

        // Calculate value of 2nCn
        int c = binomialCoeff(2 * n, n);

        // return 2nCn/(n+1)
        return c / (n + 1);
    }

    // A function to count number of
// BST with n nodes using catalan
    static int countBST( int n)
    {
        // find nth catalan number
        int count = catalan(n);

        // return nth catalan number
        return count;
    }

    // A function to count number
// of binary trees with n nodes
    static int countBT(int n)
    {
        // find count of BST
        // with n numbers
        int count = catalan(n);

        // return count * n!
        return count * factorial(n);
    }

    // Driver Code
    public static void main (String[] args)
    {
        int count1, count2, n = 5;

        // find count of BST and
        // binary trees with n nodes
        count1 = countBST(n);
        count2 = countBT(n);

        // print count of BST and
        // binary trees with n nodes
        System.out.println("Count of BST with "+
                n +" nodes is "+
                count1);
        System.out.println("Count of binary " +
                "trees with "+
                n + " nodes is " +
                count2);
    }
}


