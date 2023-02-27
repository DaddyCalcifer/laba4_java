import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        int[][] arr = FileManager.ReadIntArray("C:\\Users\\1\\Desktop\\numbers.txt");

        GUI ui = new GUI(5,5,500,300,"Значения");
        ui.InputIntArrayWindow();
        for (int i = 0; i < arr.length;i++)
        {
            for (int j = 0; j < arr[i].length;j++)
            {
                System.out.print(arr[i][j] + " ");
            }
            System.out.print('\n');
        }
        System.out.println("Сделано!");
    }
    static int[] Add(int[] arr, int element) {
        final int N = arr.length;
        arr = Arrays.copyOf(arr, N + 1);
        arr[N] = element;
        return arr;
    }
    static int[][] Add(int[][] arr, int[] element) {
        final int N = arr.length;
        arr = Arrays.copyOf(arr, N + 1);
        arr[N] = element;
        return arr;
    }

    public static int[][] Task8(int[][] array) {
        for (int out = array[0].length - 1; out >= 1; out--)
        {
            for (int in = 0; in < out; in++)
            {
                if (isBigger(array, in, in + 1) == 1)
                        swap(array, in, in + 1);
            }
        }
        return array;
    }

    private static void swap(int[][] array, int left, int minInd) {
        int[] tempo = new int[array.length];
        for (int i = 0; i < array.length; i++)
        {
            tempo[i] = array[i][left];
        }
        for (int i = 0; i < array.length; i++)
        {
            array[i][left] = array[i][minInd];
        }
        for (int i = 0; i < array.length; i++)
        {
            array[i][minInd] = tempo[i];
        }
    }

    public static int isBigger (int[][] matrix,int ind1,int ind2, int line)
    {
        if (matrix[line][ind1] == matrix[line][ind2]) return 0;
        else return (matrix[line][ind1] > matrix[line][ind2]) ? 1 : -1;
    }
    public static int isBigger (int[][] matrix,int ind1,int ind2)
    {
        for(int line = 0;;line++) {
            if (matrix[line][ind1] != matrix[line][ind2])
                return (matrix[line][ind1] > matrix[line][ind2]) ? 1 : -1;
        }
    }
    public static boolean isEquals(int[][] arr1, int[][] arr2)
    {
        if(arr1.length != arr2.length) return false;
        for (int i=0;i < arr1.length; i++)
        {
            if(Arrays.equals(arr1[i],arr2[i])==false)
                return false;
        }
        return true;
    }
    public static Coordinates FindSubarrInArr(int[][] main_arr, int[][] sub_arr)
    {
        for(int i=0; i < main_arr.length-(sub_arr.length-1); i++) {
            for (int j = 0; j < main_arr[0].length-(sub_arr[0].length-1); j++) {
                if(main_arr[i][j] == sub_arr[0][0]) {
                    System.out.println("cord: " + j + " " + i);
                    int[][] subb = CreateSubarr(main_arr, new Coordinates(j, i), sub_arr.length, sub_arr[0].length);
                    if (isEquals(sub_arr,subb))
                    {
                        return new Coordinates(i,j);
                    }
                }
            }
        }
        return new Coordinates(-1,-1);
    }

    public static int[][] CreateSubarr(int[][] arr, Coordinates startIndex, int y, int x)
    {
        int[][] result = new int[y][x];

        for(int i=0; i < y; i++)
        {
            for(int j=0; j < x; j++)
            {
                if(startIndex.y+i >= arr.length || startIndex.x+j >= arr[0].length)
                    return new int[0][0];
                result[i][j] = arr[startIndex.y+i][startIndex.x+j];
            }
        }
        //
        //
        System.out.println();
        for(int i=0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.println();
        //
        //
        return result;
    }
}