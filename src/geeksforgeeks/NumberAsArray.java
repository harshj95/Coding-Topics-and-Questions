package geeksforgeeks;

/*
For an array A=[1,2,3,4] return 1235, i.e. All elements of the array are digits of a number. Add 1 to the last element of the array and print the result.

Preset conditions
0<=A[i]<=9; A[0]!=0

Asked in Google Interview

This is my solution off the top of my getHead. There is a more optimal solution.
Complexity: O(2n) = O(n)

There is a much more shorter solution, although it has the same time complexity. But this is easier to understand stepwise and clearly differentiates different test cases;
*/

import utils.CommonLib;

import java.util.Scanner;

public class NumberAsArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n];

        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }

        modify(arr, n);
    }

    public static void modify(int[] arr, int len)
    {
        int n = len-1;

        if(arr[n]==9)
        {
            //Now count all subsequent 9(s)
            int count=1;
            for(int i=n-1;i>0;i--)
            {
                if(arr[i]==9)
                {
                    count++;
                }
                else
                {
                    break;
                }
            }

            if(count==len) //If all are 9. Create new array, and set first digit to 1
            {
                int newArr[] = new int[len+1];
                newArr[0] = 1;
                CommonLib.printArray(arr);
            }
            else
            {
                for(int i=n;i>n-count;i--)
                {
                    arr[i]=0;
                }
                arr[n-count]+=1;
                CommonLib.printArray(arr);
            }
        }
        else
        {
            arr[n]+=1;
            CommonLib.printArray(arr);
        }
    }
}
